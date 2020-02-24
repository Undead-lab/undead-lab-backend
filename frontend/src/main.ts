import Vue from 'vue'
import App from './App.vue'
import router from './utils'
import store from './store'

Vue.config.productionTip = false
require('./scss/main.scss')

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
