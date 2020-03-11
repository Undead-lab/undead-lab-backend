import Vue from 'vue'
import App from './App.vue'
import router from './utils/router-config'
import store from './utils/index'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faLinkedin, faTwitter, faGithub } from '@fortawesome/free-brands-svg-icons'
import { faClock, faUser, faImage, faTag, faSearch } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon, FontAwesomeLayers, FontAwesomeLayersText } from '@fortawesome/vue-fontawesome'
import VueMeta from 'vue-meta'

Vue.config.productionTip = false

Vue.use(VueMeta, {
  refreshOnceOnNavigation: true
})

require('./scss/main.scss')

library.add(faTwitter, faLinkedin, faClock, faUser, faImage, faTag, faGithub, faSearch

)
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.component('font-awesome-layers', FontAwesomeLayers)
Vue.component('font-awesome-layers-text', FontAwesomeLayersText)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
