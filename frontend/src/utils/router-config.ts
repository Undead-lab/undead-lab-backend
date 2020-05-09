import Vue from 'vue'
import VueRouter from 'vue-router'
import HomePageView from '../views/HomePageView.vue'
import BlogSummaryView from '../views/BlogSummaryView.vue'
import BlogPostView from '../views/BlogPostView.vue'
import NotFound from '../views/NotFound.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/404', component: NotFound },
  { path: '*', redirect: '/404', name: 'notfound' },
  {
    path: '/',
    name: 'home',
    component: HomePageView
  },
  {
    path: '/blog',
    name: 'blog',
    component: BlogSummaryView
  },
  {
    path: '/blog/:path',
    name: 'blogPost',
    component: BlogPostView
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
