<template>
  <div class="text">
    You are connected with <b>Github</b> -
    <a v-on:click="logout">
      logout
    </a>
  </div>
</template>

<script>
export default {
  name: 'Logout',
  methods: {
    logout () {
      this.$store.dispatch('logout')
    }
  }
}
</script>

<style scoped>
  .text{
    font-size: 12px;
  }
</style>
