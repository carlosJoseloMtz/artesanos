<template>
  <div class="nopal-input">
    <label :for="id">{{label}}</label>
    <input :id="id"
      :name="name"
      :value="value"
      @input="handleInput"
      @focus="handleFocus"
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
    id: String,
    label: String,
    value: String
  },
  methods: {
    handleInput (ev) {
      this.$emit('input', ev.target.value)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
// import variables
@import '../styles/_variables.scss';

.nopal-input {
  margin: 0 auto;
  text-align: left;
  width: 99%;
  label {
    width: 100%;
  }
  input {
    border: none;
    border-bottom: 1px solid gray;
    outline: none;
    width: 100%;
    &:focus {
      padding: .3em 5px;
    }
  }
}
</style>
