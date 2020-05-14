<template>
  <div class="nopal-input">
    <label :for="_uid">{{label}}</label>
    <input
      :id="_uid"
      :value="c_value"
      type="text"
      v-bind="$attrs"
    />
  </div>
</template>

<script>
export default {
  name: 'NopalInput',
  inheritAttrs: false,
  props: {
    label: String,
    value: String,
    type: {
      type: String,
      default: 'text'
    }
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

@mixin transition($args...) {
    -webkit-transition: $args;
    -moz-transition: $args;
    -ms-transition: $args;
    -o-transition: $args;
    transition: $args;
  }
.nopal-input {
  margin: 0 auto;
  text-align: left;
  width: 99%;
  label {
    width: 100%;
    font-size: 0.7em;
  }
  input {
    border: none;
    border-bottom: 1px solid $secundary-color;
    outline: none;
    width: 100%;
    @include transition(border-bottom 0.7s ease);
    &:focus {
      padding: .3em 5px;
      border-bottom:1.5px solid $primary-color;
    }
  }
}
</style>
