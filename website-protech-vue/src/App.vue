<template>
  <section class="content w-100 mx-auto">
    <DeletePopup v-if="this.deletePopupVisible" :element="this.elementToDelete" @deletion-confirmed="confirmDeletion"
                 @deletion-canceled="hideDeletePopup"></DeletePopup>
    <MainNavigation @sessions="show('sessions')" @codes="show('codes')"
                    @profile="show('profile')"/>
    <SessionList v-if="this.selected === 'sessions'" :elementToDelete="this.deletedElement" @done-deleting="hideDeletePopup" @show-delete-popup="showDeletePopup"></SessionList>
    <CodeList v-if="this.selected === 'codes' " :elementToDelete="this.deletedElement" @done-deleting="hideDeletePopup" @show-delete-popup="showDeletePopup"></CodeList>
    <UserList v-if="this.selected === 'profile'" :elementToDelete="this.deletedElement" @done-deleting="hideDeletePopup" @show-delete-popup="showDeletePopup"></UserList>
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
      backgroundVisibility: false,
      deletePopupVisible: false,
      elementToDelete: null,
      deletedElement: null
    }
  },
  methods: {
    show(string) {
      this.selected = string;
      this.hideDeletePopup();
    },
    showDeletePopup(element) {
      console.log("App : Received show-delete-popup from UserList, showing deletePopup and changing elementToDelete variable");
      console.log("App : concercened element :");
      console.log(element);
      this.backgroundVisibility = true;
      this.deletePopupVisible = true;
      this.elementToDelete = element;
    },
    hideDeletePopup() {
      console.log("App : received deletion-canceled from DeletionPopup, hiding DeletePopup");
      this.backgroundVisibility = false;
      this.deletePopupVisible = false;
      this.elementToDelete = null;
    },
    confirmDeletion(user) {
      console.log("App : received deletion-confirmed from DeletionPopup, changed deletedElement to user and hiding DeletePopup")
      this.deletedElement = user;
      this.hideDeletePopup()
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

.content {
  width: 100%;
  background-color: white;
  height: 75px;
}
</style>

