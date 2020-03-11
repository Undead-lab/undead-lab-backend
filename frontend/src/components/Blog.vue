<template>
  <div>
    <Loader v-if="loading || !allImagesLoaded" :text="''"/>
    <div :class="{'displayNone': !allImagesLoaded }" class="blog-container">
      <div class="columns list-articles">
        <div class="column is-two-thirds">
          <div>
            <div class="section-title">
              <div>
                <b>Latest {{ this.currentTag && this.currentTag !== '' ? "with tag " + this.currentTag : ''}}</b>
              </div>
            </div>
          </div>
          <div class="columns is-multiline min-height-post" v-if="!loading">
            <article-vignette v-images-loaded:on.progress="loaded" class="column is-half"
                              v-for="article in searchResult.articles"
                              :article="article"
                              :key="article.path"/>
          </div>
          <nav class="pagination" role="navigation" aria-label="pagination">
            <button class="pagination-previous" :disabled="disablePreviousPage()" @click="previousPage()">Previous
            </button>
            <button class="pagination-next" :disabled="disableNextPage()" @click="nextPage()">Next page</button>
          </nav>
        </div>
        <div class="column is-one-third">
          <SocialNetworkLink :is-floating="false"/>
          <nav class="panel section-title">
            <p class="panel-heading">
              All tags
            </p>
            <div class="panel-block">
              <p class="control has-icons-left">
                <input class="input" type="text" placeholder="Filter tags" v-model="tagListSearch">
                <span class="icon is-left">
                 <font-awesome-icon icon="search"/>
                </span>
              </p>
            </div>
            <div v-for="tag in tagList" :key="tag.tag">
              <router-link :to="'/blog?t=' + encodeURI(tag.tag).toString()" tabindex="1" class="panel-block is-active" v-if="shouldBeDisplayed(tag.tag)">
                <span class="panel-icon">
                  <font-awesome-icon icon="tag"/>
                </span>
                {{tag.tag}} ({{tag.size}})
              </router-link>
            </div>
          </nav>
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
      'searchResult': {
        'totalPages': 0,
        'articles': []
      },
      'tagListSearch': '',
      'tagList': [],
      'currentPage': 1,
      'currentTag': null,
      'loading': true,
      'allImagesLoaded': false,
      'imagesLoadedCount': 0
    }
  },
  methods: {
    shouldBeDisplayed (tag) {
      console.log()
      return this.tagListSearch === '' || tag.includes(this.tagListSearch)
    },
    disableNextPage () {
      return this.currentPage >= this.searchResult.totalPages
    },
    disablePreviousPage () {
      return this.currentPage <= 1
    },
    loaded (instance, image) {
      this.imagesLoadedCount++
      if (this.imagesLoadedCount === this.searchResult.articles.length) {
        setTimeout(() => {
          this.allImagesLoaded = true
        }, 100)
      }
    },
    searchTags () {
      axios
        .get(process.env.VUE_APP_BACKEND_URL + '/tags')
        .then(response => {
          this.tagList = response.data
        }).catch(error => console.error(error))
    },
    searchArticles () {
      this.loading = true
      this.$store.state.toggleOffNavbar = true
      let requestUri = process.env.VUE_APP_BACKEND_URL + '/articles?page=' + this.currentPage

      if (this.currentTag && this.currentTag !== '') {
        requestUri += '&tag=' + this.currentTag
      }

      axios
        .get(requestUri)
        .then(response => {
          this.$store.state.toggleOffNavbar = false
          this.$nextTick(function () {
            this.searchResult = response.data
            if (!this.searchResult.articles || this.searchResult.articles.length === 0) {
              window.location.href = '/404'
            }
            this.loading = false
            this.$store.state.toggleOffNavbar = false
          }
          )
        }
        )
    },
    nextPage () {
      if (!this.disableNextPage()) {
        let query = {
          p: '' + (Number(this.currentPage) + 1),
          t: (this.$route.query && this.$route.query.t) ? this.$route.query.t : ''
        }
        this.$router.push({ path: 'blog', query })
      }
    },
    previousPage () {
      if (!this.disablePreviousPage()) {
        let query = {
          p: '' + (Number(this.currentPage) - 1),
          t: (this.$route.query && this.$route.query.t) ? this.$route.query.t : ''
        }
        this.$router.push({ path: 'blog', query: query })
      }
    }
  },
  mounted () {
    this.currentPage = (this.$route.query && this.$route.query.p) ? this.$route.query.p : 1
    this.currentTag = (this.$route.query && this.$route.query.t) ? this.$route.query.t : null
    this.searchTags()
    this.searchArticles()
  },
  metaInfo () {
    return {
      title: 'Blog posts - Wootlab.io',
      meta: [
        {
          vmid: 'description',
          name: 'description',
          content: 'Blog section of Wootlab.io. Java, Rustlang, Kafka, VueJS, ELK, GCP and more...'
        },
        {
          vmid: 'og:description',
          name: 'og:description',
          content: 'Blog section of Wootlab.io. Java, Rustlang, Kafka, VueJS, ELK, GCP and more...'
        },
        {
          vmid: 'twitter:description',
          name: 'twitter:description',
          content: 'Blog section of Wootlab.io. Java, Rustlang, Kafka, VueJS, ELK, GCP and more...'
        }
      ]
    }
  },
  computed: {
    currentParam () {
      return this.$route.query
    }
  },
  watch: {
    currentParam () {
      this.currentPage = (this.$route.query && this.$route.query.p) ? this.$route.query.p : 1
      this.currentTag = (this.$route.query && this.$route.query.t) ? this.$route.query.t : null
      this.searchArticles()
    }
  }
}
</script>

<style scoped>
  .hide {
    display: none;
  }

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

  .panel-heading{
    background:none;
  }

  .list-articles {
    margin-top: 30px;
  }

  .section-title {
    text-align: left !important;
  }

  .displayNone {
    height: 0px;
    overflow: hidden;
  }

  .section-title {
    margin-bottom: 15px;
    background: white;
    box-shadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.12);
    padding: 15px 15px 15px 10px;
  }

  .panel-block{
    padding: 15px 0 15px 0;
  }

  .panel-heading{
    padding:0;
  }

  .input{
    padding-left:20px;
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
