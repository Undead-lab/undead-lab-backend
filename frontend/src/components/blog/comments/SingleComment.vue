<template>
  <div>
    <article class="media has-background-white">
      <div class="media-content">
        <div class="content">
          <div>
            <div>
              <strong>{{ comment.authorName }}</strong> <small></small>
            </div>
            <div>
              <small><i>{{ getFormattedDate() }}</i></small>
            </div>
            <div class="comment-value">
              {{ comment.value }}
            </div>
          </div>
          <div class="comment-edition">
            <a v-if="isUserComment()" v-on:click="deleteComment()">Delete</a>
          </div>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'SingleComment',
  props: ['comment'],
  methods: {
    isUserComment () {
      return this.comment.authorId === this.$store.getters.userId
    },
    getFormattedDate () {
      let m = new Date(this.comment.publishDate)
      let format =
        m.getUTCFullYear() + '/' +
        ('0' + (m.getUTCMonth() + 1)).slice(-2) + '/' +
        ('0' + m.getUTCDate()).slice(-2) + ' at ' +
        ('0' + m.getUTCHours()).slice(-2) + ':' +
        ('0' + m.getUTCMinutes()).slice(-2)
      return format
    },
    deleteComment () {
      axios({
        method: 'delete',
        url: process.env.VUE_APP_BACKEND_URL + '/articles/comments/' + this.comment.id,
        data: {},
        headers: {
          Authorization: 'Bearer ' + this.$store.getters.token
        }
      }
      )
        .then(response => {
          if (response.status === 401) {
            this.$store.dispatch('resetUser')
          }
          this.$emit('reloadComments')
        }).catch(error => {
          console.error(error)
          this.$store.dispatch('resetUser')
        })
    }
  }
}
</script>

<style scoped>
  .media {
    background: #FAFAFA !important;
    margin-bottom: 10px;
    padding: 15px;
  }

  .comment-edition{
    font-size: 14px;
    text-align: right;
  }

  .comment-value{
    margin-top: 10px;
    padding: 5px;
  }
</style>
