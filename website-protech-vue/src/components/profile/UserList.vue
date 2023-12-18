<template>
  <div class="user-list pt-3">
    <UserListItem v-for="user in users" :user="user" :key="user.id"></UserListItem>
  </div>
</template>

<script>
import UserListItem from "@/components/profile/UserListItem.vue";

export default {
  name: "UserList",
  components: {UserListItem},
  data: function () {
    return {
      users: []
    }
  },
  created: async function () {
    fetch('/api/users')
        .then(response => {
          if (!response.ok) {
            throw new Error("Server response was not ok");
          }
          console.log(response)
          return response.json();
        })
        .then(data => {
          console.log(data)
          this.users = data;
        })
  }
}
</script>

<style scoped lang="scss">

</style>