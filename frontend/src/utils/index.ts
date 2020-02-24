import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Blog from '../components/Blog.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/blog',
    name: 'blog',
    component: Blog
  }
]

const router = new VueRouter(
  {
    mode: 'history',
    routes: routes
  })

export default router
