<template>
  <div>
    <Loader v-if="loading || !mainImageLoaded" :text="''"/>
    <div class="blog-container" :class="{'displayNone': !mainImageLoaded }">
      <div v-images-loaded:on.progress="loaded">
        <img :src="article.images.highResolutionUrl" style="width:100%;"/>
        <div class="post-title-desktop">
          {{article.title}}
        </div>
      </div>
      <div class="blog-container-content">
        <div class="post-title-mobile">
          {{article.title}}
        </div>
        <div class="post-informations">
          <div class="infosArticles">
            <div class="minititle"> <font-awesome-icon icon="clock"/><span class="val">{{article.date}}</span></div>
            <div class="minititle"> <font-awesome-icon icon="user"/><span class="val">{{article.author}}</span></div>
            <div class="minititle"> <font-awesome-icon icon="tag"/><span class="val">{{article.tag}}</span></div>
            <div class="minititle"> <font-awesome-icon icon="image"/><span class="val">{{article.images.credits}}</span></div>
            <div class="clear"> </div>
          </div>
        </div>
        <div class="post-content content is-medium" v-html="article.content">
        </div>
        <div class="share-content">
          <div><b>Share this post on the socials:</b></div>
          <br/>
          <a class="button is-primary is-Twitter">
            <span class="icon">
              <font-awesome-icon :icon="['fab', 'twitter']" />
            </span>
            <span>Twitter</span>
          </a>
        </div>
      </div>
      <div class="footer-container">
        <div class="footer-content">
          <SocialNetworkLink/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import SocialNetworkLink from '@/components/common/SocialNetworkLink'
import Loader from '@/components/common/Loader'
import imagesLoaded from 'vue-images-loaded'

export default {
  name: 'BlogPost',
  components: { Loader, SocialNetworkLink },
  data () {
    return {
      'article': {
        'image': {}
      },
      'loading': true,
      'mainImageLoaded': false
    }
  },
  directives: {
    imagesLoaded
  },
  methods: {
    loaded (instance, image) {
      setTimeout(() => { this.mainImageLoaded = true; this.$store.state.toggleOffNavbar = false }, 50)
    }
  },
  mounted () {
    this.$store.state.toggleOffNavbar = true
    axios
      .get('https://wootlab-io-development.appspot.com/articles/' + this.$route.params.path)
      .then(response => {
        this.article = response.data
        this.loading = false
      }
      )
  }
}
</script>

<style scoped>

  .post-title-mobile{
    display:none;
  }

  .comment-content{
    padding:40px;
  }

  .footer-content{
    width:1024px;
    padding-left: 40px;
    color:white;
    margin:auto;
  }

  .blog-container-content{
    width:1024px;
    margin: -10px auto auto;
    background:white;
    padding-bottom:40px;
    padding-top:15px;
  }

  .post-video{
    margin-top:20px;
    margin-bottom:20px;
    width:100%;
    height:500px;
  }

  @media (min-width: 1024px) {
    .minititle{
      float: left;
    }
  }

  @media (max-width: 1024px) {
    .blog-container-content{
      width:100%;
    }

    .footer-content{
      width:100%;
      padding-left: 20px;
      text-align:center;
    }

    .post-video{
      margin-top:20px;
      margin-bottom:20px;
      width:100%;
      max-height:500px;
      min-height:300px;
      height:auto;
    }

    .post-title-desktop{
      display:none;
    }

    .post-title-mobile{
      display:block;
      width:100%;
      padding:20px 40px 20px 40px;
      text-align: center;
      font-family: 'Arvo', sans-serif;
      font-size:3em;
      font-weight:bold;
    }

    .displayNone {
      height:0px;
      overflow: hidden;
    }
  }

  @media (max-width: 535px) {
    .post-title-mobile{
      font-size:2em;
    }
  }

  .blog-container{
    text-align:left;
  }

  .post-title-desktop{
    line-height:1.1;
    position:absolute;
    margin-top:-350px;
    width:100%;
    padding:40px;
    text-align: center;
    color:white;
    font-family: 'Arvo', sans-serif;
    font-size:5em;
    font-weight:bold;
    -webkit-text-stroke: 1px darkgray;
    -webkit-text-fill-color: white;
  }

  .minititle{
    margin-right:0.8em; color:#666666;
    white-space: nowrap;
  }

  .minititle .val{
    margin-left:5px;
  }

  .post-image-credits{
    font-style: italic;
    text-align: right;
    padding-right:10px;
    padding-top:5px;
    font-size: 0.8em;
  }

  .blog-container img {
    box-shadow: 0px 2px 6px 0px rgba(0, 0, 0, 0.12);
  }

  .post-title{
    padding-left: 20px;
    padding-right: 20px;
    font-size:2.8em;
    text-align: center;
    font-weight: bold;
  }

  .post-informations{
    font-size:14px;
    color:lightgray;
    padding-left:40px;
  }

  .post-content {
    margin-top: 40px;
    padding-left: 40px;
    padding-right: 40px;
    text-align: justify;
  }

  .share-content{
    padding-left:40px;
    padding-right:40px;
  }

  .footer-container{
    background-color:#444;
    padding-top:20px;
    padding-bottom:20px;
  }

  .is-Twitter{
    background:#08a0e9 !important;
  }

  .is-Twitter:hover{
    background:#0790d9 !important;
  }
</style>
