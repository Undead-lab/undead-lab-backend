<template>
  <div class="loader-page" :class="{'full-page': fullPage}">
    <div class="has-text-centered">
      <div class="loader-spinner">
        <div class="loader-spinner-animated">
          <div style='left:5px;top:5px;animation-delay:0s'></div>
          <div style='left:36px;top:5px;animation-delay:0.2s'></div>
          <div style='left:67px;top:5px;animation-delay:0.4s'></div>
          <div style='left:5px;top:36px;animation-delay:1.4s'></div>
          <div style='left:67px;top:36px;animation-delay:0.6s'></div>
          <div style='left:5px;top:67px;animation-delay:1.2s'></div>
          <div style='left:36px;top:67px;animation-delay:1.0s'></div>
          <div style='left:67px;top:67px;animation-delay:0.8s'></div>
        </div>
      </div>
    </div>
    <div class="title">{{text}}</div>
  </div>
</template>

<script>
export default {
  name: 'Loader',
  props: ['text', 'fullPage']
}
</script>

<style scoped>
  @keyframes spinner {
    0% { background: #303030 }
    12.5% { background: #303030 }
    12.625% { background: #a70055 }
    100% { background: #a70055 }
  }

  .loader-page {
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
    font-family: "Arvo", sans-serif;
  }

  .full-page {
    min-height: 100vh;
  }

  .loader-spinner-animated div {
    position: absolute;
    width: 28px;
    height: 28px;
    background: #a70055;
    animation: spinner 1.6s linear infinite;
  }
  .loader-spinner {
    width: 68px;
    height: 68px;
    display: inline-block;
    overflow: hidden;
    background: none;
  }
  .loader-spinner-animated {
    width: 100%;
    height: 100%;
    position: relative;
    transform: translateZ(0) scale(0.68);
    backface-visibility: hidden;
    transform-origin: 0 0; /* see note above */
  }
  .loader-spinner-animated div { box-sizing: content-box; }
  .title{font-family: "Arvo", sans-serif }
</style>
