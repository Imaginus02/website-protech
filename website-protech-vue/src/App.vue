<template>
  <section class="content">
    <MainNavigation @sessions="show('sessions')" @codes="show('codes')"
                    @profile="show('profile')"/>
    <SessionList v-if="this.selected === 'sessions'"></SessionList>
    <CodeList v-if="this.selected === 'codes'"></CodeList>
    <UserList v-if="this.selected === 'profile'"></UserList>
  </section>
</template>


<script>
import MainNavigation from "./components/MainNavigation.vue";
import SessionList from "@/components/sessions/SessionList.vue";
import CodeList from "@/components/codes/CodeList.vue";
import UserList from "@/components/profile/UserList.vue";

export default {
  name: 'App',
  components: {
    UserList,
    CodeList,
    SessionList,
    MainNavigation
  },
  data: function () {
    return {
      selected: 'sessions'
    }
  },
  methods: {
    show(string) {
      this.selected = string;
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
.content{
    width:100%;
    background-color: white;
    height:75px;
}
</style>
