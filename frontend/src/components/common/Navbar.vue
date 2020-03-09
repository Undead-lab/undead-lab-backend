<template>
  <div>
    <nav role="navigation" class="navbar navbar-container" aria-label="main navigation" :class="currentRoute.name== 'blog'  || toggleOff ? 'reversed' : ''">
      <div class="navbar navbar-centered">
        <div class="navbar-brand">
          <router-link to="/" tabindex="0" class="navbar-item logo-title">
            <img src="../../assets/fox-75.png" class="logo-title-img"/> <b>Wootlab</b>.io<span class="logo-brackets">{ }</span>
          </router-link>
          <a tabindex="0" role="button" class='navbar-burger burger' :class="{'reversed-burger': currentRoute.name == 'blog' || toggleOff, 'is-active' : showMenu}"
             id="navbar-burger" aria-label="menu" :aria-expanded="showMenu" @click="toggleMenu(null)">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
        <div :class="{'is-active' : showMenu}" class="navbar-menu">
          <div class="navbar-start">
          </div>
          <div class="navbar-end">
            <router-link to="/" @click.native="toggleMenu(false)" exact tabindex="0" class="navbar-item link-nav">
              Home
            </router-link>
            <router-link to="/blog" @click.native="toggleMenu(false)" tabindex="0" class="navbar-item link-nav">
              Blog
            </router-link>
          </div>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'Navbar',
  data () {
    return {
      showMenu: false
    }
  },
  methods: {
    toggleMenu (forceDisplay = null) {
      this.showMenu = forceDisplay !== null ? forceDisplay : !this.showMenu
    }
  },
  computed: {
    currentRoute () {
      return this.$route
    },
    toggleOff () {
      return this.$store.state.toggleOffNavbar
    }
  },
  watch: {
    currentRoute () {
      this.toggleMenu(false)
    }
  }
}
</script>

<style scoped type="scss">

  .navbar {
    background:transparent;
  }
  .reversed{
    background:white;
    box-shadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.12);
  }

  .navbar-item{
    color:white;
  }

  .reversed .navbar-item{color:black;}

  .navbar-container-white-bg {
    box-shadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.12);
  }

  .navbar-container{
    width:100%;
    position:absolute ;
    height:80px;
  }

  .navbar-centered{
    width:1024px;
    margin:auto;
  }

  .navbar-burger{
    height:4.25em;
    color:white;
  }

  .reversed-burger{color:black;}

  .logo-title{
    font-size:28px;
  }

  .logo-title::before{
    width:0% !important;
  }

  .link-nav {
    height: 3.5rem;
    line-height: 3.5rem;
    padding: 0px 1rem;
    position: relative;
    display: flex;
    -moz-box-pack: center;
    justify-content: center;
  }

  .link-nav::before, .router-link-active::before {
    position: absolute;
    content: " ";
    display: block;
    width: 0px;
    background-color: #a70055;
    height: 4px;
    bottom: 0.6rem;
    transition: width 0.2s ease-in-out 0s;
  }

  .router-link-active::before{
    width:50%;
  }

  .link-nav:hover::before {
    width: 50%;
  }

  .logo-title-img{margin-right:10px;}
  .logo-brackets{color:lightgray;margin-left: 5px;}

  @media (min-width: 1024px){
    .logo-title{padding-left:0px;}
  }
  @media (max-width: 1024px) {
    .link-nav{
      font-size: 2rem;
      color:black
    }
    .link-nav:hover::before {
      width: 0%;
    }
    .router-link-active::before{
      width:0%;
    }

    .navbar-centered{
      width:100%;
    }

    .navbar-container{
      height:70px;
    }

  }
</style>
