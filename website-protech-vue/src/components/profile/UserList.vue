<template>
  <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
              @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
  <div class="user-list pt-3">
    <UserListItem v-for="user in users" :user="user" :key="user.id" @update-user="updateUser"
                  @delete-click="handleDelete">

    </UserListItem>
  </div>
</template>

<script>
import UserListItem from "@/components/profile/UserListItem.vue";
import AlertPopUp from "@/components/AlertPopUp.vue";

export default {
  name: "UserList",
  components: {AlertPopUp, UserListItem},
  props: ['elementToDelete'],
  data: function () {
    return {
      users: [],
      alertMessage: '',
      alertType: ''
    }
  },
  watch: {
    elementToDelete: function (value) {
      console.log("UserList : ElementToDelete changed")
      if (Object.prototype.hasOwnProperty.call(value, "username")) {
        console.log("UserList : value changed to user, deleting it")
        this.handleDeleteConfirmed(value);
      }
    }
  },
  created: async function () {
    fetch('/api/users')
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
          this.users = data;
        })
  },
  methods: {
    updateUser(data) {
      const index = this.users.findIndex((user) => user.id === data.id);
      if (index !== -1) {
        this.users[index] = data;
      }
    },
    handleDelete(user) {
      console.log("UserList : received delete-click from UserListItem")
      this.$emit("show-delete-popup", user);
      console.log("UserList : emitted show-delete-popup to App with user attached")
    },
    handleDeleteConfirmed(element) {
      const index = this.users.findIndex((user) => user.id === element.id);
      if (index !== -1) {
        this.users.splice(index, 1)
      }
      console.log("UserList : Element deleted from users")
    },
  },
}
</script>

<style scoped lang="scss">

.user-list {
  width: 50%;
  margin: auto;
}
</style>