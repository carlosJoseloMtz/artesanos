<template>
  <button>{{text}}</button>
</template>

<script>
export default {
  name: 'NopalButton',
  props: {
    text: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
@import '../styles/_variables.scss';

button {
  background-color: $primary-color;
}
</style>
