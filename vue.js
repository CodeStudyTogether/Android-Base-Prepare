https://juejin.im/post/5ba9d5cce51d450e805b59b0
https://cloud.tencent.com/developer/article/1020338?fromSource=waitui
https://cloud.tencent.com/developer/article/1020416?fromSource=waitui

Vue所需要的环境开始，node和npm的环境不用说是必须的

webpack参数是指myProject这个项目将会在开发和完成阶段帮你自动打包代码，比如将js文件统一合成一个文件，将CSS文件统一合并压缩等。

npm install 是安装项目所需要的依赖，简单理解就是安装一些必要的插件

开发完成后执行npm run build会编译我们的源代码生成最终的发布代码，在dist目录下

package.json保存一些依赖信息，config保存一些项目初始化配置，build里面保存一些webpack的初始化配置，index.html是我们的首页，除了这些，最关键的代码都在src目录中，index在很多服务器语言中都是预设为首页，像index.htm，index.php等；打开build目录中的webpack.base.conf.js
说明我们的入口js文件在src目录中的main.js

Vue的核心架构，按照官方解释和个人理解，主要在于组件和路由两大模块

App.vue这个文件，这是一个视图（或者说组件和页面），想象一下我们的index.html中什么也没有，只有一个视图，这个视图相当于一个容器，然后我们往这个容器中放各种各样的积木（其他组件或者其他页面）

<router-view></router-view>
这句代码在页面中放入一个路由视图容器，当我们访问http://localhost:8080/#/about/的时候会将about的内容放进去，访问http://localhost:8080/#/recruit的时候会将recruit的内容放进去

前面先引入了路由插件vue-router，然后显式声明要用路由 Vue.use(Router) 。注意到Hello，About等都是页面（也可以是组件），接着注册路由器，然后开始配置路由。

给路由加多一个子路由配置

<template>
    <div>公用部分</div>
    <router-view></router-view>
</template>

组件库是做UI和前端日常需求中经常用到的，把一个按钮，导航，列表之类的元素封装起来，方便日常使用，调用方法只需直接写上<qui-button></qui-button>或者<qui-nav></qui-nav>这样的代码就可以

简单分析一下入口页的代码，h1标签是一个公用元素，也就是说到时候每个子页面都会带着这个h1，他的作用就是方便我们快速回到首页，子页面的内容会注入到router-view

首页的代码也是非常简单，和我们平时写html差不多，就是几个跳转链接跳到对应的子页面，程序运行的时候，会将<template>标签里面的内容都注入到App.vue页面中的router-view标签中，从而实现无刷新的路由跳转。

过渡其实就是CSS3动画，transition这些，只是写CSS3变成好像在写JS一样，有点类似于greenSock的一些思想。

渲染这个方法是我觉得应该用心去学习的，它可以方便我们写出更好的面向对象的组件，而学习它的成本在于这个接口更接近于原生JS代码的使用。
