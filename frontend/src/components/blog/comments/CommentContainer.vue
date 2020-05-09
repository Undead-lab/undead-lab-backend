<template>
  <div class="content" id="comments">
    <CommentForm v-on:reloadComments="reloadComments"/>
    <h3>Comments : ({{totalComments()}})</h3>
    <SingleComment v-for="comment in comments" :key="comment.publishDate" :comment="comment" v-on:reloadComments="reloadComments"/>
  </div>
</template>

<script>
import CommentForm from '@/components/blog/comments/CommentForm'
import SingleComment from '@/components/blog/comments/SingleComment'
export default {
  name: 'CommentContainer',
  components: { SingleComment, CommentForm },
  props: [ 'url', 'comments' ],
  methods: {
    reloadComments () {
      this.$emit('reloadComments')
    },
    totalComments () {
      return this.comments ? this.comments.length : 0
    }
  }
}
</script>

<style scoped>

</style>
