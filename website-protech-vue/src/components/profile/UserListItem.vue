<template>
  <div class="building border border-secondary rounded p-2 mb-2">
    <div class="top-row d-flex">
      <div class="fw-bold pe-3">{{user.name}}</div>
      <div class="text-muted">Email : {{user.email}}</div>
      <div class="text-muted">Mot de passe : {{user.password}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserListItem",
  props: ['user']
}
</script>

<style scoped lang="scss">

</style>