import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Menu from '@/components/menu/Menu'
import ListProduct from '@/components/product/ListProduct'
import EditProduct from '@/components/product/EditProduct'
import DeleteProduct from '@/components/product/DeleteProduct'
import CreateProduct from '@/components/product/CreateProduct'
import ListPolicy from '@/components/policy/ListPolicy'
import CreatePolicy from '@/components/policy/CreatePolicy'
import EditPolicy from '@/components/policy/EditPolicy'
import DeletePolicy from '@/components/policy/DeletePolicy'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/menu',
      name: 'Menu',
      component: Menu
    },
    //Product Routes
    {
      path: '/products',
      name: 'ListProduct',
      component: ListProduct
    },
    {
      path: '/products/:productId/edit',
      name: 'EditProduct',
      component: EditProduct
    },
    {
      path: '/products/:productId/delete',
      name: 'DeleteProduct',
      component: DeleteProduct
    },
    {
      path: '/products/create',
      name: 'CreateProduct',
      component: CreateProduct
    },

    //Policy Routes
    {
      path: '/policys',
      name: 'ListPolicy',
      component: ListPolicy
    },
    {
      path: '/policys/create',
      name: 'CreatePolicy',
      component: CreatePolicy
    },
    {
      path: '/policys/:policyId/edit',
      name: 'EditPolicy',
      component: EditPolicy
    },
    {
      path: '/policys/:policyId/delete',
      name: 'DeletePolicy',
      component: DeletePolicy
    },
  ],
  mode: 'history'
})
