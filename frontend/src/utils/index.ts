import Vue from 'vue'
import Vuex from 'vuex'
import firebase from 'firebase'
Vue.use(Vuex)

const configOptions = {
  apiKey: process.env.VUE_APP_API_KEY,
  authDomain: process.env.VUE_APP_DOMAIN,
  databaseURL: process.env.VUE_APP_DATABASE_URL,
  projectId: process.env.VUE_APP_PROJECT_ID,
  storageBucket: process.env.VUE_APP_STORAGE_BUCKET,
  messagingSenderId: process.env.VUE_APP_MESSAGING_SENDER_ID,
  appId: process.env.VUE_APP_APP_ID
}

firebase.initializeApp(configOptions)

export default new Vuex.Store({
  state: {
    toggleOffNavbar: false,
    showLoginLoader: true,
    authenticated: false,
    token: '',
    displayName: '',
    id: '',
    username: ''
  },
  mutations: {
    setUser (state, user) {
      localStorage.authenticated = user.authenticated
      localStorage.token = user.token
      localStorage.displayName = user.displayName
      localStorage.username = user.username
      localStorage.id = user.id
      state.authenticated = user.authenticated
      state.token = user.token
      state.displayName = user.displayName
      state.username = user.username
      state.id = user.id
    },
    init (state) {
      firebase.auth().getRedirectResult().then(function (result) {
        if (result.user) {
          result.user.getIdToken(true).then(function (idToken) {
            var accessToken = idToken
            let displayName = null

            if (result.user && result.user.displayName) {
              displayName = result.user.displayName
            }
            let username = null
            if (result.additionalUserInfo && result.additionalUserInfo.username) {
              username = result.additionalUserInfo.username
            }

            let id = null

            // @ts-ignore
            if (result.additionalUserInfo && result.additionalUserInfo.profile && result.additionalUserInfo.profile.id) {
              // @ts-ignore
              id = result.additionalUserInfo.profile.id
            }

            if (username && displayName && accessToken && id) {
              localStorage.authenticated = true
              localStorage.token = accessToken
              localStorage.displayName = displayName
              localStorage.username = username
              localStorage.id = id
              state.authenticated = true
              state.token = localStorage.token
              state.displayName = localStorage.displayName
              state.username = localStorage.username
              state.showLoginLoader = false
              state.id = localStorage.id
              let t = document.getElementById('comment_text')
              if (t) { t.focus() }
            }
          }).catch(function (error) {
            console.error(error)
          })
        } else {
          state.authenticated = localStorage.authenticated
          state.token = localStorage.token
          state.displayName = localStorage.displayName
          state.username = localStorage.username
          state.showLoginLoader = false
          state.id = localStorage.id
        }
      }).catch(function (error) {
        console.error(error)
        state.showLoginLoader = false
        // For now I don't do anything, if it's not working I don't really care about it
      })
    }
  },
  getters: {
    authenticated (state) {
      return state.authenticated
    },
    token (state) {
      return state.token
    },
    displayName (state) {
      return state.displayName
    },
    username (state) {
      return state.username
    },
    userId (state) {
      return state.id
    },
    showLoginLoader (state) {
      return state.showLoginLoader
    }
  },
  actions: {
    resetUser ({ commit }) {
      var user = {
        authenticated: false,
        token: '',
        displayName: '',
        username: null,
        id: ''
      }
      commit('setUser', user)
    },
    login ({ commit }, anchor) {
      var provider = new firebase.auth.GithubAuthProvider()
      firebase.auth().signInWithRedirect(provider)
    },
    logout ({ commit }) {
      firebase.auth().signOut().then(function () {
        var user = {
          authenticated: false,
          token: '',
          displayName: '',
          username: null,
          id: ''
        }
        commit('setUser', user)
      })
    }
  },
  modules: {
  }
})
