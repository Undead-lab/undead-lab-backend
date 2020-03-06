<template>
  <div>
    <Loader v-if="loading || !allImagesLoaded" :text="''"/>
    <div :class="{'displayNone': !allImagesLoaded }" class="blog-container">
      <div class="columns list-articles">
        <div class="column is-three-quarters">
          <div>
            <div class="section-title">
              <div>
                <b>Latest</b>
              </div>
            </div>
          </div>
          <div class="columns is-multiline min-height-post" v-if="!loading">
            <article-vignette v-images-loaded:on.progress="loaded" class="column is-half" v-for="article in articles"
                              :article="article"
                              :key="article.path"/>
          </div>
        </div>
        <div class="column is-one-quarter">
          <SocialNetworkLink/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import ArticleVignette from '@/components/blog/ArticleVignette'
import SocialNetworkLink from '@/components/common/SocialNetworkLink'
import axios from 'axios'
import Loader from '@/components/common/Loader'
import imagesLoaded from 'vue-images-loaded'

export default {
  name: 'Blog',
  components: { Loader, ArticleVignette, SocialNetworkLink },
  directives: {
    imagesLoaded
  },
  data () {
    return {
      'articles': [],
      'loading': true,
      'allImagesLoaded': false,
      'imagesLoadedCount': 0
    }
  },
  methods: {
    loaded (instance, image) {
      this.imagesLoadedCount++
      if (this.imagesLoadedCount === this.articles.length) {
        setTimeout(() => { this.allImagesLoaded = true }, 100)
      }
    }
  },
  mounted () {
    this.$store.state.toggleOffNavbar = true
    axios
      .get('https://wootlab-io-development.appspot.com/articles')
      .then(response => {
        this.$store.state.toggleOffNavbar = false
        this.$nextTick(function () {
          this.articles = response.data
          this.loading = false
          this.$store.state.toggleOffNavbar = false
        }
        )
      }
      )
  }
}
</script>

<style scoped>
  .blog-container {
    padding-top: 100px;
    width: 1024px;
    margin: auto;
    text-align: left;
  }

  .blog-title {
    font-size: 24px;
    font-weight: bold;
  }

  .column {
    padding: .75rem;
  }

  .list-articles {
    margin-top: 30px;
  }

  .section-title {
    text-align: left !important;
  }

  .displayNone {
    height:0px;
    overflow: hidden;
  }

  .section-title {
    margin-bottom: 15px;
    background: white;
    box-shadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.12);
    padding-top: 15px;
    padding-bottom: 15px;
    padding-left: 10px;
  }

  @media (max-width: 1024px) {
    .blog-container {
      width: 100%;
      padding-left: 1.75em;
      padding-right: 1.75em;
    }
  }

  .is-Twitter {
    background: #08a0e9 !important;
  }

  .is-Twitter:hover {
    background: #0790d9 !important;
  }

  .is-linkedIn {
    background: #0876a8 !important;
    margin-left: 10px;
  }

  .is-linkedIn:hover {
    background: #076698 !important;
    margin-left: 10px;
  }

  .is-github {
    background: #333 !important;
    margin-left: 10px;
  }

  .is-github:hover {
    background: #222 !important;
    margin-left: 10px;
  }

</style>
