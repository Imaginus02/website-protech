<template>
  <dialog class="window">
    <p>Voulez vous vraiment supprimer {{this.element}}</p>
    <div class="boutons">
      <button class="btn btn-danger" @click="confirmDeletion">Supprimer</button>
      <button class="btn btn-secondary" @click="cancelDeletion">Annuler</button>
    </div>
  </dialog>
</template>

<script>
export default {
  name: "DeletePopup",
  props: ["element"],
  methods: {
    confirmDeletion() {
      this.$emit("deletion-confirmed", this.element);
    },
    cancelDeletion() {
      this.$emit("deletion-canceled");
    }
  }
}

</script>

<style scoped lang="scss">

</style>