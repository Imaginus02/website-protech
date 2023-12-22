<template>
  <div class="border border-secondary rounded p-2 mb-2">
    <div class="row d-flex">
      <div class="fw-bold pe-3">Nom : {{session.name}}</div>
      <div class="text-muted">Id : {{session.password}}</div>
      <div class="text-muted">Date de création : {{session.startDate}}</div>
      <div class="text-muted">Date de fin : {{session.endDate}}</div>
      <div class="text-muted">Utilisateur max : {{session.nombreMax}}</div>
    </div>
    <button class="btn btn-danger" @click="handleDeleteClick">Supprimer</button>
  </div>

</template>

<script>
export default {
  name: "SessionListItem",
  props: ['session'],
  methods: {
    handleDeleteClick() {
      console.log("SessionListItem : user clicked on delete button")
      this.$emit("delete-click", this.session);
      console.log("SessionListItem : emitted delete-click to SessionList with session attached")
    },
  }
}
</script>

<style scoped lang="scss">

</style>