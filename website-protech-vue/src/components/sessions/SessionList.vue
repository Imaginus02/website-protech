<<<<<<< HEAD
<template>
  <div class="sessions-list pt-3">
    <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
                @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
    <p v-if="sessions.length === 0 && this.alertMessage === ''" class="fw-bold">Aucune Session créée</p>
    <session-list-item v-else v-for="session in sessions" :session="session" :key="session.id"></session-list-item>
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
  }
}

</script>

<style scoped lang="scss">

=======
<template>
  <div class="sessions-list pt-3">
    <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
                @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
    <p v-if="sessions.length === 0 && this.alertMessage === ''" class="fw-bold">Aucune Session créée</p>
    <session-list-item v-else v-for="session in sessions" :session="session" :key="session.id"></session-list-item>
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
  }
}

</script>

<style scoped lang="scss">
.sessions-list{
    width: 50% ;
    margin: auto;
}
>>>>>>> 6350d7fb9ef6b1a566a43e37cc6749ed2c128716
</style>