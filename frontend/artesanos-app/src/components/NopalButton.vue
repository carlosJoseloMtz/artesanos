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
@import 'material-icons/css/material-icons.scss';

@mixin pushed_transition($args...) {
    -webkit-transition: $args;
    -moz-transition: $args;
    -ms-transition: $args;
    -o-transition: $args;
    transition: $args;
  }

button {
  @include pushed_transition(background-color 0.4s ease);

  background-color: $primary-color;
  border: none;
  border-radius: 4.5px;
  width: 100%;
  padding: 1em;
  color:$primary-text-color;
  &:focus{
    outline: none;
    box-shadow: none;
  }
  &:active{
    outline: none;
    box-shadow: none;
    background-color: $primary-color-accentuated;
  }
  &:hover{
    cursor:pointer;
  }
}
</style>
