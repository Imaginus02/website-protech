<template>
  <div class="codes-list pt-3">
    <CodeListItem v-for="code in codes" :code="code" :key="code.id"></CodeListItem>
  </div>
</template>


<script>
import CodeListItem from "@/components/codes/CodeListItem.vue";

export default {
  components: {
    CodeListItem
  },
  name: "CodeList",
  data: function () {
    return {
      codes: []
    }
  },
  created: async function () {
    fetch('/api/codes')
        .then(response => {
          if (!response.ok) {
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

</style>