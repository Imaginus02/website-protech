<template>
  <div class="codes-list pt-3">
    <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
                @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
    <CodeListItem v-for="code in codes" :code="code" :key="code.id" @delete-click="handleDelete"></CodeListItem>
  </div>
</template>


<script>
import CodeListItem from "@/components/codes/CodeListItem.vue";
import AlertPopUp from "@/components/AlertPopUp.vue";

export default {
  components: {
    AlertPopUp,
    CodeListItem
  },
  name: "CodeList",
  props: ['elementToDelete'],
  data: function () {
    return {
      codes: [],
      alertMessage: '',
      alertType: ''
    }
  },
  watch: {
    elementToDelete: function (value) {
      console.log("CodeList : ElementToDelete changed")
      if (Object.prototype.hasOwnProperty.call(value, 'instructions')) {
        console.log("CodeList : value changed to code, deleting it")
        this.handleDeleteConfirmed(value);
      }
    }
  },
  created: async function () {
    fetch('/api/codes')
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
          this.codes = data;
        })
  },
  methods: {
    handleDelete(code) {
      console.log("UserList : received delete-click from UserListItem")
      this.$emit("show-delete-popup", code);
      console.log("CodeList : emitted show-delete-popup to App with code attached")
    },
    handleDeleteConfirmed(element) {
      const index = this.codes.findIndex((code) => code.id === element.id);
      if (index !== -1) {
        this.codes.splice(index, 1)
      }
      console.log("CodeList : Element deleted from codes")
    },
  }
}
</script>

<style scoped lang="scss">
.codes-list{
    width:50%;
    margin: auto;
}
</style>