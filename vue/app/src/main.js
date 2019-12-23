import Vue from 'vue'
import router from './router'
import axios from 'axios'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

Vue.use(ElementUI)

// 默认调用地址
axios.defaults.baseURL = 'http://localhost:8080'
Vue.prototype.$http = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
