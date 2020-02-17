<template>
  <div class="home">
    <div class="home-container">
      <div class="">
        <h1 class="title">
          <span class="main">Wootlab</span>
          <span class="subtitle">Blog - Projects - Tools </span>
        </h1>
        <span class="description">A random passionate developper's place</span>
        <div class="btns-list-container">
            <router-link to="/news" class="home-btn">Blog</router-link>
            <router-link to="/doc" class="home-btn">Projects</router-link>
            <a href="https://twitter.com/zthulj" target="_blank" class="home-btn">Twitter</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'home'
}
</script>
<style type="scss" scoped>
  .home-container {
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    display: flex;
    margin: 4rem 0px 2rem;
  }

  .home {
    position: relative;
    width: 100%;
    display: flex;
    -moz-box-pack: center;
    justify-content: center;
    -moz-box-align: center;
    align-items: center;
    overflow: hidden;
    background-color: #166088;
    min-height: 100vh;
    font-family: "Arvo", sans-serif;
  }

  .home-btns {
    margin-top:15px;
    display: flex;
    font-size: 1.1em;
    font-weight: bold;
    z-index: 1;
    list-style: none;
  }

  .home-btn{
    border: 2px solid
    rgb(255, 255, 255);
    border-radius: 8px;
    padding: 0.5em 1em;
    color:
      rgb(255, 255, 255);
    transition-duration: 0.15s;
    transition-timing-function: ease-in-out;
    transition-delay: 0s;
    transition-property: background-color, color;
    margin-left: 1.6em;
  }

  .home-btn a{
    color:white;
  }

  .home-btn:hover{
    background-color:
      rgb(255, 255, 255);
    color:black !important;
  }

  .home-btn:hover a{
    color:black;
  }

  .btns-list-container{
    margin-top:25px;
  }

  .main {
    font-size: 4.2em;
    font-weight: bold;
  }

  .title {
    font-size: 1.2em;
    position: relative;
    padding-bottom: 1.2em;
    margin-bottom: 0.8rem;
    color: white;
  }

  .subtitle {
    font-size: 1.2em;
    position: absolute;
    left: 20px;
    bottom: 0px;
    color: white;
    font-weight:400;
  }

  .description {
    text-align: center;
    opacity: 0.7;
    max-width: 80vw;
    color: white;
  }
</style>
