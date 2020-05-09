<template>
  <div v-if="!loading">
    <div v-if="authenticated === 'true' || authenticated === true">
      <Logout/>
      <article class="media">
        <div class="media-content">
          <div class="field">
            <div class="control">
              <textarea class="textarea" placeholder="Add a comment..." id="comment_text" v-model="value"></textarea>
              <div class="commentDraft-rules">(10 char min) Stay <b>polite</b>, don't advertise and speak in <b>english.</b></div>
            </div>
          </div>
          <nav class="level">
            <div class="level-left">
              <div class="level-item">
              </div>
            </div>
            <div class="level-right">
              <div class="level-item">
                <button class="button is-success" v-on:click="putComment" :disabled="disablePut">Comment</button>
              </div>
            </div>
          </nav>
        </div>
      </article>
    </div>
    <article v-else class="media has-text-centered">
      <Login :message="'Login via Github to comment'" :anchor="'comments'"/>
    </article>
  </div>
  <Loader v-else/>
</template>

<script>
import Login from '@/components/common/Login'
import Logout from '@/components/common/Logout'
import Loader from '@/components/common/Loader'
import axios from 'axios'

export default {

  name: 'CommentForm',
  components: { Loader, Logout, Login },
  computed: {
    authenticated () {
      return this.$store.getters.authenticated
    },
    loading () {
      return this.$store.getters.showLoginLoader
    },
    disablePut () {
      return this.value.length < 10
    }
  },
  data: function () {
    return {
      'value': ''
    }
  },
  methods: {
    putComment () {
      axios({
        method: 'put',
        url: process.env.VUE_APP_BACKEND_URL + '/articles/' + this.$route.params.path + '/comments',
        data: { value: this.value },
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
          this.$store.dispatch('resetUser')
          console.error(error)
        })
    }
  },
  watch: {
    authenticated () { },
    loading () { }
  }
}
</script>

<style scoped>
  .media{
    padding-bottom: 15px;
  }
  .textarea{
    z-index: 1;
  }
  .commentDraft-rules{
    text-align: right;
    font-size: 12px;
  }
</style>
