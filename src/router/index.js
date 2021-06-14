import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import Aside from "../components/Aside";
import hw1 from "../views/hw1";
import hw2 from "../views/hw2";
import hw3 from "../views/hw3";
import hw4 from "../views/hw4";
import hw5 from "../views/hw5";
import hw6 from "../views/hw6";
import hw7 from "../views/hw7";
import hw8 from "../views/hw8";
import Main from "../components/Main";

Vue.use(Router)

export default new Router({
  routes: [

    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/Main',
      name: 'Main',
      component: Main,
      redirect: '/hw1',
      children: [{
        path: '/hw1',
        name: 'hw1',
        component: hw1
      },
        {
          path: '/hw2',
          name: 'hw2',
          component: hw2
        },
        {
          path: '/hw3',
          name: 'hw3',
          component: hw3
        },
        {
          path: '/hw4',
          name: 'hw4',
          component: hw4
        },
        {
          path: '/hw5',
          name: 'hw5',
          component: hw5
        },
        {
          path: '/hw6',
          name: 'hw6',
          component: hw6
        },
        {
          path: '/hw7',
          name: 'hw7',
          component: hw7
        },
        {
          path: '/hw8',
          name: 'hw8',
          component: hw8
        },
      ]
    }
  ]
})
