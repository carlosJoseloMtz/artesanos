
<template>
  <div class="container">
      <img v-for="image in images" v-bind:key="image" class="child" :src="image"/>
  </div>
</template>

<script>
export default {
  name: 'NopalGallery',
  props: {
    images: Array
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
@import '../styles/_variables.scss';
@import 'material-icons/css/material-icons.scss';
img {
  width: 500px;
}

* {
    box-sizing: border-box;
}
.container {
    border: 1px solid lightgray;
    padding: 1rem;
    display: flex;
    overflow-x: scroll;
    scroll-padding: 0 50%;
    scroll-snap-type: x mandatory;
}

.child {
      scroll-snap-align: center;
    display: inline-block;
    height: 83vh;
    border-radius: 3px;
    font-size: 0;
    margin-right: 3rem;
}
</style>
