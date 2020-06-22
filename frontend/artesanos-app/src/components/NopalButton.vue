<template>
  <button :class="type">{{text}}</button>
</template>

<script>
export default {
  name: 'nopal-button',
  props: {
    text: String,
    type: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
@import '../styles/_variables.scss';
/* TODO: remove dependency for material icons and all usages */
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

  @mixin background_color($color1,$color2){
    background: $color1;
    background: -moz-linear-gradient(-45deg, $color1 58%, $color1 58%, $color2 58%);
    background: -webkit-gradient(left top, right bottom, color-stop(58%, $color1), color-stop(58%, $color1), color-stop(58%, $color2));
    background: -webkit-linear-gradient(-45deg, $color1 58%, $color1 58%, $color2 58%);
    background: -o-linear-gradient(-45deg, $color1 58%, $color1 58%, $color2 58%);
    background: -ms-linear-gradient(-45deg, $color1 58%, $color1 58%, $color2 58%);
    background: linear-gradient(135deg, $color1 58%, $color1 58%, $color2 58%);
  }
.primary{
    @include background_color($primary-color,$disabled-light-color);
  }
  .secundary{
    @include background_color($secundary-color,$disabled-light-color);
  }
  .primary-light{
    @include background_color($primary-light-color,$disabled-light-color);
  }
  .secundary-light{
    @include background_color($secundary-light-color,$disabled-light-color);
  }
button {
  @include pushed_transition(background-color 0.4s ease);
  @include avoid_textselection(none);

  border: none;
  /* TODO: actually find and set the proper radius */
  border-radius: 15px;
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
    -webkit-box-shadow: 0px 5px 0px -1px $primary-shadow-color;
    -moz-box-shadow: 0px 5px 0px -1px $primary-shadow-color;
    box-shadow: 0px 5px 0px -1px $primary-shadow-color;
  }
}
</style>
