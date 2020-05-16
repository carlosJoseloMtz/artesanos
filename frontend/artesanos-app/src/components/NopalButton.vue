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

@mixin avoid_textselection($args...) {
    -webkit-touch-callout: $args; /* iOS Safari */
    -webkit-user-select: $args; /* Safari */
     -khtml-user-select: $args; /* Konqueror HTML */
       -moz-user-select: $args; /* Firefox */
        -ms-user-select: $args; /* Internet Explorer/Edge */
            user-select: $args; /* Non-prefixed version, currently
                                  supported by Chrome and Opera */
  }

@mixin pushed_transition($args...) {
    -webkit-transition: $args;
    -moz-transition: $args;
    -ms-transition: $args;
    -o-transition: $args;
    transition: $args;
  }

button {
  @include pushed_transition(background-color 0.4s ease);
  @include avoid_textselection(none);
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
