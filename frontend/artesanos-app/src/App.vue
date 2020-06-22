<template>
  <div id="app">
    <HomePage/>
  </div>
</template>

<script>
import HomePage from './pages/HomePage.vue'

export default {
  name: 'App',
  components: {
    HomePage
  }
}
</script>

<style lang="scss">
@import "./styles/global";
#app {
}
</style>
