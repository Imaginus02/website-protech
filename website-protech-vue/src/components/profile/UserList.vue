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
import {watch} from "vue";

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
  setup(props) {
    watch(() => props.elementToDelete, (newValue, oldValue) => {
      if (newValue !== oldValue) {
        this.handleDeleteConfirmed(newValue);
      }
    })
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
      this.$emit("show-delete-popup", user.name);
    },
    handleDeleteConfirmed(element) {
      this.userList = this.userList.filter(user => user.name !== element.name);
    },
  },
}
</script>

<style scoped lang="scss">

</style>