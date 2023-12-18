<template>
  <!--  <div class="building border border-secondary rounded p-2 mb-2">-->
  <hr/>
  <div class="text-muted">{{ instruction.name }}</div>
  <!--  </div>-->
</template>

<script>
export default {
  name: "InstructionListItem",
  props: ['instruction']
}
</script>

<style scoped lang="scss">

</style>