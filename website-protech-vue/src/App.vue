<template>
  <section class="main-content w-50 mx-auto" :class="backgroundVisibility ? 'radial-gradient(black, transparent)'">
    <DeletePopup v-if="this.deletePopupVisible" :element="this.elementToDelete" @deletion-confirmed="confirmDeletion"
                 @deletion-canceled="hideDeletePopup"></DeletePopup>
    <MainNavigation @sessions="show('sessions')" @codes="show('codes')"
                    @profile="show('profile')"/>
    <SessionList v-if="this.selected === 'sessions'" @show-delete-popup="showDeletePopup"></SessionList>
    <CodeList v-if="this.selected === 'codes'"></CodeList>
    <UserList v-if="this.selected === 'profile'" :elementToDelete="this.elementToDelete" @done-deleting="hideDeletePopup"></UserList>
  </section>
</template>


<script>
import MainNavigation from "./components/MainNavigation.vue";
import DeletePopup from "@/components/DeletePopup.vue";
import SessionList from "@/components/sessions/SessionList.vue";
import CodeList from "@/components/codes/CodeList.vue";
import UserList from "@/components/profile/UserList.vue";

export default {
  name: 'App',
  components: {
    DeletePopup,
    UserList,
    CodeList,
    SessionList,
    MainNavigation
  },
  data: function () {
    return {
      selected: 'sessions',
      backgroundVisibility: 0,
      deletePopupVisible: false,
      elementToDelete: null,
    }
  },
  methods: {
    show(string) {
      this.selected = string;
    },
    showDeletePopup(element) {
      this.backgroundVisibility = 0.5;
      this.deletePopupVisible = true;
      this.elementToDelete = element;
    },
    hideDeletePopup() {
      this.backgroundVisibility = 0;
      this.deletePopupVisible = false;
      this.elementToDelete = null;
    },
    confirmDeletion(user) {
      this.elementToDelete = user;
    }
  }
}
</script>

<style lang="scss" scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
