<template>
  <div>
    <img />
    <h1>logotipo</h1>
    <NopalButton text="Quiero Comprar" />
    <br /><br />
    <NopalButton text="Soy artesano" />
    <br />
    <NopalInput :attributes="nopalinput_attr" />
  </div>
</template>

<script>
import NopalButton from '../components/NopalButton.vue'
import NopalInput from '../components/NopalInput.vue'

export default {
  name: 'HomePage',
  components: {
    NopalButton,
    NopalInput
  },
  data () {
    return {
      nopalinput_attr: {
        value: '123',
        placeholder: 'Perenganito Perez Gomez',
        label: 'Nombre artesano',
        type: 'number'
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss"></style>
