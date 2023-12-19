<template>
  <div class="building border border-secondary rounded p-2 mb-2">
    <div class="top-row d-flex">
      <div class="fw-bold pe-3">{{session.name}}</div>
      <div class="text-muted">Id de la session : {{session.password}}</div>
      <div class="text-muted">Date de création : {{session.startDate}}</div>
      <div class="text-muted">Date de fin : {{session.endDate}}</div>
      <div class="text-muted">Nombre d'utilisateur maximum : {{session.nombreMax}}</div>
    </div>
  </div>

</template>

<script>
export default {
  name: "SessionListItem",
  props: ['session']
}
</script>

<style scoped lang="scss">

</style>