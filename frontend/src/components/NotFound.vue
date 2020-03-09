<template>
  <div class="centered-page">
    <img src="../assets/fox-75.png"/>
    <div class="is-size-2">Error 404</div>
    <div class="is-size-3">Houston, we have a problem... </div>
    <div class="title"><br/> The page you were looking for doesn't exist.</div>
  </div>
</template>

<script>
export default {
  name: 'NotFound',
  mounted () {
    this.$store.state.toggleOffNavbar = true
  },
  metaInfo () {
    return {
      title: 'Page not found - Wootlab.io',
      meta: [
        { vmid: 'robots', name: 'robots', content: 'noindex, nofollow' }
      ]
    }
  }
}
</script>

<style scoped>
  .centered-page {
    padding-left:10px;
    padding-right:10px;
    position: relative;
    width: 100%;
    display: flex;
    flex-direction: column;
    -moz-box-pack: center;
    justify-content: center;
    -moz-box-align: center;
    align-items: center;
    overflow: hidden;
    background-position: center;
    background-size: 100%;
    min-height: 100vh;
    font-family: "Arvo", sans-serif;
  }
</style>
