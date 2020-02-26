import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Blog from '../components/blog/Blog.vue'
import BlogPost from '../components/blog/BlogPost.vue'

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
  },
  {
    path: '/blog/:path',
    name: 'blogPost',
    component: BlogPost
  }
]

const router = new VueRouter(
  {
    mode: 'history',
    routes: routes,
    scrollBehavior (to, from, savedPosition) {
      return { x: 0, y: 0 }
    }
  })

router.beforeEach((to, from, next) => {
  document.getElementsByTagName('html').item(0)!.focus()
  next()
})

export default router
