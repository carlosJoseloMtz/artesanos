<template>
  <div>
    <img />
    <h1>logotipo</h1>
    <NopalButton text="Quiero Comprar"/>
    <br/>
    <NopalButton text="Soy artesano"/>
  </div>
</template>

<script>
import NopalButton from '../components/NopalButton.vue'

export default {
  name: 'HomePage',
  components: {
    NopalButton
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
</style>
