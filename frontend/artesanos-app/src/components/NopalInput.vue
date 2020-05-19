<template>
  <div class="nopal-input">
    <i class="material-icons">cloud_upload</i>
    <div class="two">
      <label :for="_uid">{{ attributes.label }}</label>
      <input :id="_uid" v-bind="attributes" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'NopalInput',
  inheritAttrs: false,
  props: {
    attributes: Object
  },
  watch: {
    value (nv, ov) {
      this.c_value = nv
    }
  },
  data: function () {
    return {
      c_value: {}
    }
  },
  beforeMount () {
    this.c_value = this.value
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
// import variables
@import '../styles/_variables.scss';
@import '~material-design-icons/iconfont/material-icons.css';

@mixin transition($args...) {
  -webkit-transition: $args;
  -moz-transition: $args;
  -ms-transition: $args;
  -o-transition: $args;
  transition: $args;
}

@mixin avoid_textselection($args...) {
  -webkit-touch-callout: $args; /* iOS Safari */
  -webkit-user-select: $args; /* Safari */
  -khtml-user-select: $args; /* Konqueror HTML */
  -moz-user-select: $args; /* Firefox */
  -ms-user-select: $args; /* Internet Explorer/Edge */
  user-select: $args; /* Non-prefixed version, currently
                                  supported by Chrome and Opera */
}
.one {
  margin-right: 10px;
  max-width: 2rem;
}
.two {
  width: 100%;
}

.nopal-input {
  display: flex;
  margin: 0 auto;
  text-align: left;
  width: 99%;
  i {
    @include avoid_textselection(none);
    margin-right: 3px;
  }
  label {
    width: 100%;
    font-size: 0.7em;
    font-weight: bold;
  }
  input {
    border: none;
    border-bottom: 1px solid $secundary-color;
    outline: none;
    width: 100%;
    @include transition(border-bottom 0.4s ease);
    &:focus {
      padding-top: 0.3em;
      border-bottom: 1.5px solid $primary-color;
    }
    &::placeholder {
      color: gray;
      font-size: 0.8em;
      font-style: italic;
    }
  }
}
</style>
