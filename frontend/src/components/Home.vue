<template>
  <div>
    <div class="home">
    </div>
    <div class="home-2">
      <div class="home-container">
        <div>
          <img class="img-logo"
               src="https://avatars1.githubusercontent.com/u/43185161?s=400&u=0f077352dbc68985059720a9bd2f36f936b847af&v=4">
        </div>
        <div class="title-container">
          <div class="title-principal">
            <div class="title-principal-first">Wootlab</div>
            <div class="title-principal-secondary">Blog - Projects - Tools</div>
          </div>
          <div class="title-description">Hello, I'm Jeremy.</div>
          <div class="title-description">I'm a pasionate developer for <a href="https://www.zenika.com">Zenika</a>.</div>
          <div class="btns-list-container">
          </div>
        </div>
      </div>
    </div>
    <SocialNetworkLink :is-floating="true"/>
  </div>
</template>

<script>
import SocialNetworkLink from '@/components/common/SocialNetworkLink'
export default {
  name: 'home',
  components: { SocialNetworkLink },
  mounted () {
    this.$store.state.toggleOffNavbar = false
  },
  metaInfo () {
    return {
      title: 'Home - Wootlab.io',
      meta: [
        { vmid: 'description', name: 'description', content: 'I\'m Jeremy Thulliez, Coding the world @ZenikaLille. I\'m a Tech explorer, Java, Rustlang, Kafka, VueJS, ELK, GCP and more... Also indie game dev during the night..' },
        { vmid: 'og:description', name: 'og:description', content: 'I\'m Jeremy Thulliez, Coding the world @ZenikaLille. I\'m a Tech explorer, Java, Rustlang, Kafka, VueJS, ELK, GCP and more... Also indie game dev during the night..' },
        { vmid: 'twitter:description', name: 'twitter:description', content: 'I\'m Jeremy Thulliez, Coding the world @ZenikaLille. I\'m a Tech explorer, Java, Rustlang, Kafka, VueJS, ELK, GCP and more... Also indie game dev during the night..' }
      ]
    }
  }
}
</script>
<style type="scss" scoped>
  .home-container {
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.3;
    display: flex;
    margin: 4rem 0px 2rem;
  }

  .img-logo {
    border-radius: 50%;
    height: 225px;
    border:3px solid white;
  }

  .home, .home-2 {
    position: absolute;
    width: 100%;
    display: flex;
    -moz-box-pack: center;
    justify-content: center;
    -moz-box-align: center;
    align-items: center;
    overflow: hidden;
    min-height: 100vh;
    font-family: "Arvo", sans-serif;
  }

  .home{
    background-color:rgba(0, 0, 0, 1);
    background-image: url("../assets/space-min.jpg");
    background-position: center;
    background-size: 100%;
    filter: brightness(50%);
  }

  .home-btns {
    margin-top: 15px;
    display: flex;
    font-size: 1.1em;
    font-weight: bold;
    z-index: 1;
    list-style: none;
  }

  .home-btn {
    border: 2px solid rgb(255, 255, 255);
    border-radius: 8px;
    padding: 0.5em 1em;
    color: rgb(255, 255, 255);
    transition-duration: 0.15s;
    transition-timing-function: ease-in-out;
    transition-delay: 0s;
    transition-property: background-color, color;
    margin-left: 1.6em;
  }

  .first {
    margin-left: 0px;
  }

  .home-btn a {
    color: white;
  }

  .home-btn:hover {
    background-color: rgb(255, 255, 255);
    color: black !important;
  }

  .home-btn:hover a {
    color: black;
  }

  .btns-list-container {
    margin-top: 25px;
    display: flex;
  }

  .btns-list-duo{
    display:flex;
  }

  .title-principal-first {
    font-size: 4.2em;
    font-weight: bold;
    margin-top: -10px;
  }

  .title-principal {
    font-size: 1.2em;
    position: relative;
    padding-bottom: 1.2em;
    margin-bottom: 0.8rem;
    padding-top:1.3em;
    color: white;
  }

  .title-principal-secondary {
    font-size: 1.2em;
    position: absolute;
    left: 20px;
    bottom: 0px;
    color: white;
    font-weight: 400;
  }

  .title-description {
    padding-left: 20px;
    opacity: 0.7;
    max-width: 80vw;
    color: white;
  }

  .title-container {
    text-align: left;
  }

  .home-credit{
    position:absolute;
    bottom: 10px;
    color:white;
    font-size:0.8rem;
    width:100%;
    text-align: center;
  }

  @media (max-width: 1024px) {
    .home{
      background-size: 200%;
    }

    .title-principal-first {
      font-size: 3.7em;
    }
    .home-container {
      flex-direction: column;
      margin: 0;
    }
    .home {
      align-items: flex-start;
      padding-top: 100px;
    }
    .btns-list-container{
      flex-direction: column;
      align-items: center;
      flex-basis: 23%;
    }
    .first-duo-btn{
      margin-left:0px;
    }
    .second-duo{
      margin-top:30px;
    }

    .home-btn{
      width:150px;
    }
  }
</style>
