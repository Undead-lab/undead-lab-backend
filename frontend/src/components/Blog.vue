<template>
  <div class="blog-container">
    <div class="blog-header">
      <div class="blog-title">Latest posts</div>
      <div class="columns">
        <div class="column">
          <div class="bgblue article 1">article 1</div>
        </div>
        <div class="column">
          <div class="bgblue">article 2</div>
        </div>
        <div class="column">
          <div class="bgblue">article 3</div>
        </div>
      </div>
    </div>
    <div>
      <div>
        LEFT PART
        <div>
          TITLE MENU FILTERS
        </div>
        <div>
          <div>
            <div>
              <img alt="articleimg"/>
              <div>
                <div>tag1</div>
                <div>tag2</div>
              </div>
              <div>title</div>
              <div>description</div>
            </div>
          </div>
          <div>
            ARTICLE 2
          </div>
        </div>
      </div>
      <div>
        RIGHT PART
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Blog'
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
    font-size:30px;
    font-weight:bold;
  }

  .column{
    padding: .75rem;
  }

  .bgblue{
    background:blue;
  }

</style>
