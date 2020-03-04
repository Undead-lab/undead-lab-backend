<template>
  <div class="blog-container">
    <div class="columns list-articles">
      <div class="column is-three-quarters">
        <div>
          <div class="section-title">
            <div>
                <b>Latest</b>
            </div>
          </div>
        </div>
          <article-vignette class="columns" v-for="article in articles" :article="article" :key="article"/>
      </div>
      <div class="column is-one-quarter">
        <div class="section-title">
          <div>
            <b>Connect with me online</b>
          </div>
          <a class="button is-primary is-Twitter">
          <span class="icon">
            <font-awesome-icon :icon="['fab', 'twitter']" />
          </span>
          </a>
          <a class="button is-primary is-linkedIn">
          <span class="icon">
            <font-awesome-icon :icon="['fab', 'linkedin']" />
          </span>
          </a>
          <a class="button is-primary is-github">
          <span class="icon">
            <font-awesome-icon :icon="['fab', 'github']" />
          </span>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import ArticleVignette from '@/components/blog/ArticleVignette'
import axios from 'axios'

export default {
  name: 'Blog',
  components: { ArticleVignette },
  data () {
    return {
      'articles': []
    }
  },
  mounted () {
    axios
      .get('https://wootlab-io-development.appspot.com/articles')
      .then(response => {
        this.articles = response.data
      }
      )
  }
}
</script>

<style scoped>
  .blog-container{
    padding-top:100px;
    width:1024px;
    margin:auto;
    text-align:left;
  }

  .blog-title{
    font-size:24px;
    font-weight:bold;
  }

  .column{
    padding: .75rem;
  }

  .list-articles{
    margin-top:30px;
  }

  .section-title{
    text-align:left !important;
  }

  .section-title{
    margin-bottom:15px;
    background:white;
    box-shadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.12);
    padding-top:15px;
    padding-bottom:15px;
    padding-left:10px;
  }

  @media(max-width: 1024px){
    .blog-container{
      width:100%;
      padding-left: 1.75em;
      padding-right: 1.75em;
    }
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

</style>
