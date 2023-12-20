<template>
  <div class="sessions-list pt-3">
    <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
                @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
    <p v-if="sessions.length === 0 && this.alertMessage === ''" class="fw-bold">Aucune Session créée</p>
    <session-list-item v-else v-for="session in sessions" :session="session" :key="session.id" @delete-click="handleDelete"></session-list-item>
  </div>
</template>

<script>


import SessionListItem from "@/components/sessions/SessionListItem.vue";
import AlertPopUp from "@/components/AlertPopUp.vue";

export default {
  components: {
    AlertPopUp,
    SessionListItem,
  },
  name: "SessionList",
  props: ['elementToDelete'],
  data: function () {
    return {
      sessions: [],
      alertMessage: '',
      alertType: ''
    }
  },
  created: async function () {
    fetch('/api/sessions')
        .then(response => {
          if (!response.ok) {
            this.alertMessage = `HTTP error! Status: ${response.status}`; // Set error message to alertMessage
            this.alertType = 'danger';
            throw new Error("Server response was not ok");
          }
          console.log(response)
          return response.json();
        })
        .then(data => {
          console.log(data)
          this.sessions = data;
        })
  },
  watch: {
    elementToDelete: function (value) {
      console.log("SessionList : ElementToDelete changed")
      if (Object.prototype.hasOwnProperty.call(value, 'status')) {
        console.log("SessionList : value changed to session, deleting it")
        this.handleDeleteConfirmed(value);
      }
    }
  },
  methods: {
    handleDelete(session) {
      console.log("SessionList : received delete-click from UserListItem")
      this.$emit("show-delete-popup", session);
      console.log("SessionList : emitted show-delete-popup to App with session attached")
    },
    handleDeleteConfirmed(element) {
      const index = this.sessions.findIndex((session) => session.id === element.id);
      if (index !== -1) {
        this.sessions.splice(index, 1)
      }
      console.log("SessionList : Element deleted from sessions")
    },
  }
}
</script>
<style scoped lang="scss">
  .sessions-list{
  width: 50% ;
  margin: auto;
}
</style>
