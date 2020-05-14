<template>
  <div class="nopal-input">
    <i class="one">ico</i>
    <div class="two">
      <label :for="_uid">{{label}}</label>
      <input
        :id="_uid"
        :value="c_value"
        type="text"
        v-bind="$attrs"
        :placeholder="placeholder"

      />
    </div>
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
    },
    placeholder: {
      type: String,
      default: ''
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
  .one{
    margin-right:10px;
    max-width: 2rem;
  }
  .two{
    width:100%;
  }

.nopal-input {
  display:flex;
  margin: 0 auto;
  text-align: left;
  width: 99%;
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
      padding-top:.3em;
      border-bottom:1.5px solid $primary-color;
    }
    &::placeholder{
      color:gray;
      font-size:.8em;
      font-style: italic;
    }
  }
}
</style>
