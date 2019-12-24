import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/', component: () => import('../components/HelloWorld.vue'),props:{msg:'HelloWorld'}
        },
        {
            path: '/index', component: ()=> import('../components/Index.vue')
        },
        {
            path: '/login', component: ()=> import('../components/Login.vue') 
        }
    ]
})
