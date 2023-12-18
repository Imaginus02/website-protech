<template>
  <div class="border border-secondary rounded p-2 mb-2">
    <div class="top-row d-flex">
      <div class="fw-bold pe-3">Nom d'utilisateur : {{ user.username }}</div>
      <button v-if="!usernameForm" class="btn btn-secondary ms-auto" @click="usernameForm = true">Modifier</button>
      <UserForm v-else :usage="'username'" :id="user.id" @cancel="usernameForm = false" @update-success="handleUpdateSuccess"></UserForm>
    </div>
    <hr/>
    <div class="d-flex">
      <div class="text-muted pe-3">Email : {{ user.email }}</div>
      <button v-if="!emailForm" class="btn btn-secondary ms-auto" @click="emailForm = true">Modifier</button>
      <UserForm v-else :usage="'email'" :id="user.id" @cancel="emailForm = false" @update-success="handleUpdateSuccess"></UserForm>
    </div>
    <hr/>
    <div class="d-flex">
      <div class="text-muted pe-3">Mot de passe : {{ user.password }}</div>
      <button v-if="!passwordForm" class="btn btn-secondary ms-auto" @click="passwordForm = true">Modifier</button>
      <UserForm v-else :usage="'password'" :id="user.id" @cancel="passwordForm = false" @update-success="handleUpdateSuccess"></UserForm>
    </div>
    <hr/>
    <div class="bottom-row d-flew">
      <button class="btn btn-danger">Supprimer</button>
    </div>
  </div>
</template>

<script>
import UserForm from "@/components/profile/UserForm.vue";

export default {
  name: "UserListItem",
  components: {UserForm},
  props: ['user'],
  data() {
    return {
      usernameForm: false,
      emailForm: false,
      passwordForm: false
    }
  },
  methods: {
    handleUpdateSuccess(data) {
      this.$emit("update-user",data);
    }
  }
}
</script>

<style scoped lang="scss">

</style>