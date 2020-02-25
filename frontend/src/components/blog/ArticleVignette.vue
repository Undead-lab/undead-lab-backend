<template>
  <div class="column">
    <router-link to="/blog/something">
      <div class="card article-miniature">
        <div class="card-image">
          <figure class="image is-3by3">
            <img src="../../assets/fox1.jpg" alt="Placeholder image">
          </figure>
        </div>
        <div class="card-content">
          <div class="media">
            <div class="media-content">
              <p class="title is-4">The title of my awesome blog post</p>
              <p class="subtitle is-6">@zthulj (Jeremy THULLIEZ)</p>
            </div>
          </div>

          <div class="content">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Phasellus nec iaculis mauris. <a>@bulmaio</a>.
            <a href="#">#css</a> <a href="#">#responsive</a>
            <br><br>
            <time datetime="2016-1-1">1 Jan 2016</time>
          </div>
        </div>
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

  .article-miniature:hover{
    cursor:pointer;
    background:#EDEDED;
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
</style>
