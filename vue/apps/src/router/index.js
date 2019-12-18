import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const Foo = {template: '<div>foo</div>'}
const Bar = {template: '<div>bar</div>'}

export default new Router({
    mode: 'history',
    routes: [
        {path: '/foo', component: Foo},
        {path: '/bar', component: Bar}
    ]
})
