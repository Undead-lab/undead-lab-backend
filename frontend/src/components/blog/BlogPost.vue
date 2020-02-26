<template>
  <div class="blog-container">
    <div>
      <img src="../../assets/fox1.jpg" style="width:100%;"/>
      <div class="post-title-desktop">
        Lorem ipsum data jacta es sorimen
      </div>
    </div>
    <div class="blog-container-content">
      <div class="post-title-mobile">
        Lorem ipsum data jacta es sorimen
      </div>
      <div class="post-informations">
        <div class="infosArticles">
          <div class="minititle"> <font-awesome-icon icon="clock"/><span class="val">2020-02-10</span></div>
          <div class="minititle"> <font-awesome-icon icon="user"/><span class="val">zThulj (Jérémy THULLIEZ)</span></div>
          <div class="minititle"> <font-awesome-icon icon="tag"/><span class="val">Game development</span></div>
          <div class="minititle"> <font-awesome-icon icon="image"/><span class="val">Picture by someone bla bla</span></div>
          <div class="clear"> </div>
        </div>
      </div>
      <div class="post-content content is-medium">
        <h1>Title 1</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <h1>Title 1</h1>

        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <img src="../../assets/lion1.jpg"/>
        <h2>Title 2</h2>
        <ul>
          <li>
            test
          </li>
          <li>
            test2
          </li>
        </ul>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

        <h3>Title 3</h3>

        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        <h4>Title 4</h4>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        <div>
          <iframe class="post-video" src="https://www.youtube.com/embed/_VcWDetcX3U" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
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
export default {
  name: 'BlogPost'
}
</script>

<style scoped>

  .post-title-mobile{
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

  .is-github{
    background:#333 !important;
    margin-left:10px;
  }

  .is-github:hover{
    background:#222 !important;
    margin-left:10px;
  }

</style>
