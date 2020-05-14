<template>
  <div>
    <img />
    <h1>logotipo</h1>
    <NopalButton text="Quiero Comprar"/>
    <br/>
    <NopalButton text="Soy artesano"/>
    <NopalInput label="Nombre de artesano" value="123" placeholder="Perenganito Perez Gomez"/>

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
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
</style>
