<template>
  <nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <router-link to="/" tabindex="0" class="navbar-item logo-title">
        <b>Wootlab</b>.io
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
        <router-link to="blog" tabindex="0" class="navbar-item link-nav">
          Blog
        </router-link>
        <router-link to="blog" tabindex="0" class="navbar-item link-nav">
          Projects
        </router-link>
        <router-link to="admin" tabindex="0" class="navbar-item link-nav">
          Admin
        </router-link>
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
  }
}
</script>

<style scoped type="scss">
  .navbar{
    position:fixed;
    width:100%;
  }
  .navbar-burger{
    height:4.25em;
  }
  .logo-title{
    font-size:28px;
  }

  .link-nav {
    color: rgba(40, 38, 49, 0.9);
    height: 3.5rem;
    line-height: 3.5rem;
    padding: 0px 1rem;
    position: relative;
    display: flex;
    -moz-box-pack: center;
    justify-content: center;
  }

  .link-nav::before {
    position: absolute;
    content: " ";
    display: block;
    width: 0px;
    background-color: #a70055;
    height: 4px;
    bottom: 0.6rem;
    transition: width 0.2s ease-in-out 0s;
  }

  .link-nav:hover::before {
    width: 50%;
  }

  @media (max-width: 1024px) {
    .link-nav{
      font-size: 2rem;
    }
    .link-nav:hover::before {
      width: 0%;
    }

  }
</style>
