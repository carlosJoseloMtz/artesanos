<template>
  <div>
    <img />
    <h1>logotipo</h1>
    <NopalButton text="Quiero Comprar" />
    <br /><br />
    <NopalButton text="Soy artesano" />
    <br />
    <NopalInput :attributes="nopalinput_attr" />
    <NopalGallery :images="images_attr"/>
  </div>
</template>

<script>
import NopalButton from '../components/NopalButton.vue'
import NopalInput from '../components/NopalInput.vue'
import NopalGallery from '../components/NopalGallery.vue'

export default {
  name: 'HomePage',
  components: {
    NopalButton,
    NopalInput,
    NopalGallery
  },
  data () {
    return {
      nopalinput_attr: {
        value: '123',
        placeholder: 'Perenganito Perez Gomez',
        label: 'Nombre artesano',
        type: 'number'
      },
      images_attr:[
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkxdVYdqrPbQXHhdHZf1oq6eQjBGKD_7hTTQ8v1pEldffN5slt&s",
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkxdVYdqrPbQXHhdHZf1oq6eQjBGKD_7hTTQ8v1pEldffN5slt&s",
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkxdVYdqrPbQXHhdHZf1oq6eQjBGKD_7hTTQ8v1pEldffN5slt&s"
      ]

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss"></style>
