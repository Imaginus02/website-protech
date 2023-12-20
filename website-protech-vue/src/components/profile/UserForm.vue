<template>
  <form @submit.prevent="handleSubmit">
    <input v-model="userInput" type="text" class="form-control mb-3 space-between-elements">
    <button type="submit" class="btn btn-primary">Modifier</button>
    <button type="button" class="btn btn-secondary" @click="this.$emit('cancel')">Annuler</button>
  </form>

</template>

<script>
export default {
  name: "UserForm",
  props: ['usage', 'id'],
  created() {
    console.log('Received prop usage:', this.usage);
    console.log('Received prop usage:', this.id);
  },
  data() {
    return {
      userInput: '',
      // TODO Modify this by the real URL when pushing to clevercloud
      endpoint: '/api/users',
      dataToSend: {}
    }
  },
  methods: {
    async handleSubmit() {
      this.endpoint = '/api/users/' + String(this.id);
      if (this.userInput === '') {
        console.log('Missing argument')
        this.$emit("update-failed", 'Missing argument: ' + this.usage)
      } else {
        console.log(this.userInput)
        console.log(this.usage)
        this.dataToSend = {[this.usage]: this.userInput}
        console.log(this.dataToSend)
        fetch(this.endpoint,
            {
              method: 'POST',
              headers: {
                'Content-type': 'application/json',
              },
              body: JSON.stringify(this.dataToSend)
            })
            .then(response => {
              if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`)
              }
              return response.json();
            })
            .then(data => {
              console.log('Update successful:', data);
              //TODO : also emit this.usage
              this.$emit("update-success", data, this.usage)
            })
            .catch(error => {
              // Handle errors
              this.$emit("update-failed", error.message)
              console.error('Update failed:', error.message);
            });
      }
    }
  }
}

</script>

<style scoped lang="scss">

</style>