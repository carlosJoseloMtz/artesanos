<template>
  <div class="page home-page">
    <img />
    <h1>logotipo</h1>
    <nopal-button text="Quiero Comprar" type="primary" />
    <nopal-button text="Soy artesano" type="secundary-light"/>
  </div>
</template>

<script>
import NopalButton from '../components/NopalButton.vue'

export default {
  name: 'HomePage',
  components: {
    NopalButton
  },
  data () {
    return {
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
  .home-page {
    text-align: center;

    img {
      height: 200px;
    }

    button {
      margin: 10px 0;
    }
  }
</style>
