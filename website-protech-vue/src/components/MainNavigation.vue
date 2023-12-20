<!-- <template>
  <ul class="nav nav-tabs">
    <li class="nav-item" @click="setActiveTab('sessions')">
      <a class="nav-link" :class="{ 'active': activeTab === 'sessions' }" aria-current="page" href="#">Sessions</a>
    </li>
    <li class="nav-item" @click="setActiveTab('codes')">
      <a class="nav-link" :class="{ 'active': activeTab === 'codes' }" href="#" tabindex="-1" aria-disabled="true">Codes</a>
    </li>
    <li class="nav-item" @click="setActiveTab('profile')">
      <a class="nav-link" :class="{ 'active': activeTab === 'profile' }" href="#" tabindex="-1" aria-disabled="true">Profile</a>
    </li>
  </ul>
</template> -->

<template>
    <nav>
      <div class="" @click="setActiveTab('sessions')">
        <a class="" :class="{ 'active': activeTab === 'sessions' }" aria-current="page" href="#">Sessions</a>
      </div>
      <div class="" @click="setActiveTab('codes')">
        <a class="" :class="{ 'active': activeTab === 'codes' }" href="#" tabindex="-1" aria-disabled="true">Codes</a>
      </div>
      <div class="" @click="setActiveTab('profile')">
        <a class="" :class="{ 'active': activeTab === 'profile' }" href="#" tabindex="-1" aria-disabled="true">Profile</a>
      </div>
      <a href="../mainPage"> Accueil </a>
    </nav>
</template>


<script>
export default {
  name: 'app',
  emits: ['sessions', 'codes', 'profile'],
  data() {
    return {
      activeTab: 'sessions'
    }
  },
  methods: {
    setActiveTab(string) {
      this.activeTab = string
      this.$emit(this.activeTab)
      console.log("Changing active tab to : " + this.activeTab);
    }
  }
}
</script>

<style scoped lang="scss">
    nav{
        width:100%;
        height:75px;
        margin:0;
        background-color: white;
    }
</style>