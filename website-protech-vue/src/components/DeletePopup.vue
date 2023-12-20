<template>
  <div class="delete-popup-overlay">
    <div class="window">
      <p>Voulez-vous vraiment supprimer
        {{
          this.element.hasOwnProperty('username') ? ('cet utilisateur :' + this.element.username) : ((this.element.hasOwnProperty("instructions") ? ('ce code : ') : ('cette session : ')) + this.element.name)
        }}
      </p>
      <div class="boutons">
        <button class="btn btn-danger" @click="confirmDeletion">Supprimer</button>
        <button class="btn btn-secondary" @click="cancelDeletion">Annuler</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DeletePopup",
  props: ["element"],
  methods: {
    confirmDeletion() {
      console.log("DeletePopup : user clicked on deletion confirmed")
      this.$emit("deletion-confirmed", this.element);
      console.log("DeletePopup : emitting deletion-confirmed")
    },
    cancelDeletion() {
      console.log("DeletePopup : user clicked on deletion cancelled")
      this.$emit("deletion-canceled");
      console.log("DeletePopup : emitting deletion-cancelled")

    }
  }
}

</script>

<style scoped lang="scss">
.window {
  background-color: white;
  border: 1px solid #ccc;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.delete-popup-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
}
</style>