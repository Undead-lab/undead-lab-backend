import Vue from 'vue'
import App from './App.vue'
import router from './utils/router-config'
import store from './store'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faLinkedin, faTwitter } from '@fortawesome/free-brands-svg-icons'
import { faClock, faUser, faImage } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon, FontAwesomeLayers, FontAwesomeLayersText } from '@fortawesome/vue-fontawesome'

Vue.config.productionTip = false
require('./scss/main.scss')

library.add(faTwitter, faLinkedin, faClock, faUser, faImage)
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.component('font-awesome-layers', FontAwesomeLayers)
Vue.component('font-awesome-layers-text', FontAwesomeLayersText)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
