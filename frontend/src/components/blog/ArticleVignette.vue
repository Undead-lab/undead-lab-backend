<template>
  <router-link :to="'/blog/' + article.url" class="link-card">
    <div class="card article-miniature">
      <div class="card-image">
        <figure class="image is-3by3">
          <img :src="article.images.miniatureUrl" alt="Placeholder image">
        </figure>
      </div>
      <div class="card-content">
        <div class="media">
          <div class="media-content">
            <p class="title is-4">{{article.title}}</p>
            <p class="subtitle is-6">{{article.author}}</p>
          </div>
        </div>

        <div class="content">
          {{article.description}}
        </div>
      </div>
       <footer class="card-footer">
         <time datetime="2016-1-1">{{article.date}}</time>
       </footer>
    </div>
  </router-link>
</template>

<script>
export default {
  name: 'ArticleVignette',
  props: ['article']
}
</script>

<style scoped>

.card-footer{
  margin-top: auto;
  padding:1.5em;
  border-top:0px;
}

  .article-miniature:hover{
    cursor:pointer;
    background:#EDEDED;
  }

  .link-card:focus .article-miniature{
    background: #EDEDED;
  }

  .article-miniature:hover .title{
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

  .card{
    height:100%;
    display: flex;
    flex-direction: column;
  }
</style>
