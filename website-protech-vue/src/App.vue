<template>
  <section class="main-content w-50 mx-auto">
    <MainNavigation @sessions="show('sessions')" @codes="show('codes')"
                    @profile="show('profile')"/>
  </section>
</template>


<script>
import MainNavigation from "./components/MainNavigation.vue";

export default {
  name: 'App',
  components: {
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
</style>
