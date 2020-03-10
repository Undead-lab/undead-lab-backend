<template>
  <div class="section-title" :class="{'floating': isFloating}">
    <div :class="{'displaynone': isFloating}">
      <b>Connect with me online</b>
    </div>
    <a class="button is-primary is-Twitter" href="https://www.twitter.com/jeremythulliez" target="_blank">
          <span class="icon">
            <font-awesome-icon :icon="['fab', 'twitter']" />
          </span>
    </a>
    <a class="button is-primary is-linkedIn" href="https://www.linkedin.com/in/jeremythulliez/" target="_blank">
          <span class="icon">
            <font-awesome-icon :icon="['fab', 'linkedin']" />
          </span>
    </a>
    <a class="button is-primary is-github" href="https://github.com/grzi" target="_blank">
          <span class="icon">
            <font-awesome-icon :icon="['fab', 'github']" />
          </span>
    </a>
  </div>
</template>

<script>
export default {
  name: 'SocialNetworkLink',
  props: ['isFloating']
}
</script>

<style scoped>
  .displaynone{
    display:none;
  }

  .is-Twitter{
    background:#08a0e9 !important;
  }

  .is-Twitter:hover{
    background:#0790d9 !important;
  }

  .is-linkedIn{
    background:#0876a8 !important;
    margin-left:10px;
  }

  .is-linkedIn:hover{
    background:#076698 !important;
    margin-left:10px;
  }

  .is-github{
    background:#333 !important;
    margin-left:10px;
  }

  .is-github:hover{
    background:#222 !important;
    margin-left:10px;
  }

  .floating{
    position:absolute;
    width:100%;
    bottom:10px;
  }
</style>
