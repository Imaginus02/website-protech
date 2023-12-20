<<<<<<< HEAD
<template>
  <div class="codes-list pt-3">
    <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
                @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
    <CodeListItem v-for="code in codes" :code="code" :key="code.id"></CodeListItem>
  </div>
</template>


<script>
import CodeListItem from "@/components/codes/CodeListItem.vue";
import AlertPopUp from "@/components/AlertPopUp.vue";

export default {
  components: {
    AlertPopUp,
    CodeListItem
  },
  name: "CodeList",
  data: function () {
    return {
      codes: [],
      alertMessage: '',
      alertType: ''
    }
  },
  created: async function () {
    fetch('/api/codes')
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
          this.codes = data;
        })
  }
}
</script>

<style scoped lang="scss">

=======
<template>
  <div class="codes-list pt-3">
    <AlertPopUp v-if="alertMessage !== ''" :message="this.alertMessage" :type="this.alertType"
                @close-alert="this.alertMessage = ''; this.alertType = ''"></AlertPopUp>
    <CodeListItem v-for="code in codes" :code="code" :key="code.id"></CodeListItem>
  </div>
</template>


<script>
import CodeListItem from "@/components/codes/CodeListItem.vue";
import AlertPopUp from "@/components/AlertPopUp.vue";

export default {
  components: {
    AlertPopUp,
    CodeListItem
  },
  name: "CodeList",
  data: function () {
    return {
      codes: [],
      alertMessage: '',
      alertType: ''
    }
  },
  created: async function () {
    fetch('/api/codes')
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
          this.codes = data;
        })
  }
}
</script>

<style scoped lang="scss">
.codes-list{
    width:50%;
    margin: auto;
}

>>>>>>> 6350d7fb9ef6b1a566a43e37cc6749ed2c128716
</style>