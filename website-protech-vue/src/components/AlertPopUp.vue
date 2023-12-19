<template>
  <div class="alert d-flex align-items-center justify-content-center" :class="'alert-'+this.type" role="alert">
    <p class="error-message">{{ this.message }}</p>
    <button type="button" class="btn-close ms-auto" @click="closeAlert"></button>
  </div>
</template>

<script>
export default {
  name: "AlertPopUp",
  props: ['message', 'type'],
  methods: {
    closeAlert() {
      this.$emit("close-alert");
    }
  }
}

</script>

<style scoped lang="scss">
.error-message {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>