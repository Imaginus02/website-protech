<template>
  <div class="building border border-secondary rounded p-2 mb-2">
    <div class="fw-bold pe-3">{{code.name}}</div>
    <InstructionListItem v-for="instruction in sortedInstructions" :instruction="instruction" :key="instruction.id"></InstructionListItem>
    <hr/>
    <button class="btn btn-danger" @click="handleDeleteClick">Supprimer</button>
  </div>
</template>

<script>
import InstructionListItem from "@/components/codes/InstructionListItem.vue";

export default {
  components: {
    InstructionListItem,
  },
  name: "CodeListItem",
  props: ['code'],
  computed: {
    sortedInstructions() {
      return this.code.instructions.slice().sort((a, b) => a.orderInCode - b.orderInCode);
    }
  },
  methods: {
    handleDeleteClick() {
      console.log("CodeListItem : user clicked on delete button")
      this.$emit("delete-click", this.code);
      console.log("CodeListItem : emitted delete-click to CodeList with code attached")
    },
  }
}

</script>

<style scoped lang="scss">

</style>