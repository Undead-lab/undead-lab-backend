<template>
  <div class="about-author-container">
    <div class="about-author">
      <div class="about-author-flexbox">
        <div>
          <img class="img-author"
               src="https://avatars1.githubusercontent.com/u/43185161?s=400&u=0f077352dbc68985059720a9bd2f36f936b847af&v=4">
        </div>
        <div class="title-container">
          <div class="title-principal">
            <div class="writtenby">Written by </div>
          </div>
          <div class="author-name">Jérémy THULLIEZ</div>
          <div class="author-description">I'm a pasionate developer for <a href="https://www.zenika.com">Zenika</a>.
          </div>
          <div class="btns-list-container">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AboutTheAuthor'
}
</script>

<style scoped>
  .about-author-container {
    padding-left: 40px;
    padding-right: 40px;
    margin-top:30px;
  }

  .about-author {
    padding-top: 20px;
    padding-bottom: 20px;
    border-top: 1px solid rgba(0, 0, 0, 0.1);
    border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  }

  .img-author{
    border-radius: 50%;
    height: 90px;
    border:3px solid white;
    margin-right:50px;
  }

  .about-author-flexbox {
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.3;
    display: flex;
  }

  .writtenby{
    color: rgba(0, 0, 0, 0.54);
    text-transform: uppercase;
  }

  .author-name {
    color:black;
    font-weight: bold;
    font-size: 1.5rem;
  }

  .author-description{
    margin-top: 15px;
  }
</style>
