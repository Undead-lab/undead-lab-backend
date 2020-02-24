<template>
  <div class="blog-container">
    <div class="blog-header">
      <div>
        <div class="section-title">
          <div>
            <b>Most visited posts</b>
          </div>
        </div>
      </div>
      <div class="columns">
        <article-vignette/>
        <article-vignette/>
        <article-vignette/>
      </div>
    </div>
    <div class="columns list-articles">
      <div class="column is-three-quarters">
        <div>
          <div class="section-title">
            <div>
                <b>Latest</b>
            </div>
          </div>
        </div>
        <div class="columns">
          <article-vignette/>
          <article-vignette/>
        </div>
        <div class="columns">
          <article-vignette/>
          <article-vignette/>
        </div>
        <div class="columns">
          <article-vignette/>
          <article-vignette/>
        </div>
        <div class="columns">
          <article-vignette/>
          <article-vignette/>
        </div>
      </div>
      <div class="column is-one-quarter">
        <div class="section-title">
          <div>
            <b>Connect with me online</b>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import ArticleVignette from '@/components/blog/ArticleVignette'

export default {
  name: 'Blog',
  components: { ArticleVignette }
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

</style>
