// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// 导入ElementUI，主要是一些前端组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 导入发送HTTP请求的模块
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.config.productionTip = false
Vue.use(ElementUI);


axios.defaults.baseURL = "/api"
axios.defaults.withCredentials = true
Vue.use(VueAxios,axios);




/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
