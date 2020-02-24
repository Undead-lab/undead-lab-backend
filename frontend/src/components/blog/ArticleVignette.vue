<template>
  <div class="column">
    <router-link to="test">
      <div class="article-miniature">
        <img class="articleimg" src="../../assets/lion1.jpg" />
        <div class="article-title">comment changer de banque ?</div>
        <div class="article-date">2020-10-01</div>
        <div class="article-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</div>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'ArticleVignette'
}
</script>

<style scoped>
  .article-miniature{
    background:white;
    border-radius:5px;
    line-height: 1;
    color: #111;
  }

  .article-miniature:hover{
    cursor:pointer;
    background:#EDEDED;
  }

  .article-miniature:hover .article-title{
    text-decoration: underline;
  }

  .article-description{
    font-size:14px;
    padding:15px 10px 15px 10px;
    text-align: justify;
  }

  .articleimg{
    width:100%;
    border-radius:5px 5px 0 0;
  }

  .article-title{
    font-size:18px;
    font-weight: bold;
    text-transform: uppercase;
    padding:5px 10px 1px 10px;
    line-height: 1;
  }

  .article-date{
    font-size:14px;
    color: darkgray;
    padding:6px 10px 1px 10px;
  }

  .column{
    padding: .75rem;
  }
</style>
