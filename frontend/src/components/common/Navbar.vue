<template>
  <nav role="navigation" class="navbar navbar-container" aria-label="main navigation" :class="currentRoute.name== 'blog' ? 'reversed' : ''">
    <div class="navbar navbar-centered">
      <div class="navbar-brand">
        <router-link to="/" tabindex="0" class="navbar-item logo-title">
          <img src="../../assets/fox-75.png" class="logo-title-img"/> <b>Wootlab</b>.io<span class="logo-brackets">{ }</span>
        </router-link>
        <a tabindex="0" role="button" class='navbar-burger burger' id="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>
      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
        </div>
        <div class="navbar-end">
          <router-link to="/" exact tabindex="0" class="navbar-item link-nav">
            Home
          </router-link>
          <router-link to="/blog" tabindex="0" class="navbar-item link-nav">
            Blog
          </router-link>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'Navbar',
  mounted () {
    const navBarBurger = document.getElementById('navbar-burger burger')
    navBarBurger.addEventListener('click', () => {
      const target = navBarBurger.dataset.target
      const $target = document.getElementById(target)
      navBarBurger.classList.toggle('is-active')
      $target.classList.toggle('is-active')
    })
  },
  computed: {
    currentRoute () {
      return this.$route
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
  }
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
