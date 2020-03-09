import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Blog from '../components/Blog.vue'
import BlogPost from '../components/BlogPost.vue'
import NotFound from '../components/NotFound.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/404', component: NotFound },
  { path: '*', redirect: '/404', name: 'notfound' },
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
