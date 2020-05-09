<template>
  <button class="button is-primary is-github" v-on:click="login">
    <span class="icon">
      <font-awesome-icon :icon="['fab', 'github']" />
    </span>
    {{ message }}
  </button>
</template>

<script>
export default {
  name: 'Login',
  props: [ 'message', 'anchor' ],
  methods: {
    login () {
      this.$store.dispatch('login', this.anchor)
    }
  }
}
</script>

<style scoped>
  .button .icon {
    margin : auto !important;
  }

  .button {
    padding-left : 0.4em;
    margin: auto;
  }
  .is-github{
    background:#333 !important;
  }

  .is-github:hover{
    background:#222 !important;
  }
</style>
