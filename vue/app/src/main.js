import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

// 默认调用地址
axios.defaults.baseURL = 'http://localhost:8080'
Vue.prototype.$http = axios

Vue.use(ElementUI)

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
