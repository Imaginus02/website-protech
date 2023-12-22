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
    <div class="contain-link">
        <a class="link" href="../pageTeacher.html"> Accueil </a>
      </div>
      <div class="contain-link" @click="setActiveTab('sessions')">
        <a class="link" :class="{ 'active': activeTab === 'sessions' }" aria-current="page" href="#">Sessions</a>
      </div>
      <div class="contain-link" @click="setActiveTab('codes')">
        <a class="link" :class="{ 'active': activeTab === 'codes' }" href="#" tabindex="-1" aria-disabled="true">Codes</a>
      </div>
      <div class="contain-link" @click="setActiveTab('profile')">
        <a class="link" :class="{ 'active': activeTab === 'profile' }" href="#" tabindex="-1" aria-disabled="true">Profile</a>
      </div>
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
        display: flex;
    }
    .contain-link{
        width:200px;
        height:100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .link{
        text-decoration: none;
        color: black;
        text-align: center;
    }
    .link:hover{
        background-color: rgb(202, 202, 202);
        border-radius: 10px;
        padding: 4px 10px;
    }

</style>