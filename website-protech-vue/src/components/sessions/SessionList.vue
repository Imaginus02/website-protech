<template>
  <div class="sessions-list pt-3">
    <session-list-item v-for="session in sessions" :session="session" :key="session.id"></session-list-item>
  </div>
</template>

<script>


import SessionListItem from "@/components/sessions/SessionListItem.vue";

export default {
  components: {
    SessionListItem,
  },
  name: "SessionList",
  data: function () {
    return {
      sessions: []
    }
  },
  created: async function () {
    fetch('/api/sessions')
        .then(response => {
          if (!response.ok) {
            throw new Error("Server reponse was not ok");
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

</style>