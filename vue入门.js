v-text 渲染数据
v-if 控制显示
v-on 绑定事件
v-for 循环渲染

Vue 是一个用于构建 Web 用户界面的 JavaScript 框架。

如果你是 Vue 开发新手，应该专注于 Vue.js 生态系统的核心，包括 Vue 核心库、Vue Router 和 Vuex。

Vue 团队维护了一个叫作 Vue CLI 的工具，让你可以在几分钟内启动一个强大的 Vue 开发环境。

Vue 应用程序可以使用 ES5 开发，ES5 是几乎所有浏览器都支持的 JavaScript 标准。

要获得增强的 Vue 开发体验，并利用新的浏览器功能，你可以使用最新的 JavaScript 标准 ES2015 和 ES2016 或更高版本提供的功能来构建 Vue 应用程序。

Webpack 是模块捆绑器，如果你的代码跨越了不同模块（例如不同的 JavaScript 文件），Webpack 可以将这些零散的代码“构建”到浏览器可读的单个文件中。

Webpack 还可以作为构建管道，你可以在构建代码之前对代码进行转换，例如使用 Babel、Sass 或 TypeScript，还可以使用一系列插件来优化你的应用程序。

TypeScript 是 JavaScript 语言的超集，为我们提供了类型（String、Boolean、Number 等），这样我们就可以编写健壮的代码，并尽早发现错误。

Vue.js 3 将于 2019 年推出，将完全使用 TypeScript 编写。但这并不意味着你一定要在你的 Vue 项目中使用它，但如果你想要为 Vue 贡献代码，或者想要理解它的内部工作原理，就需要了解 TypeScript。

构建在 Vue 之上的框架让你无需从头开始实现服务器端渲染，还可以创建自己的组件库以及完成很多其他常见任务。

如果你需要使用动画，请了解一下 Vue 的过渡系统，它也是 Vue 核心的一部分。你可以在向 DOM 添加元素或从 DOM 中删除元素时应用动画。

MVVM 是Model-View-ViewModel 的缩写，它是一种基于前端开发的架构模式，其核心是提供对View 和 ViewModel 的双向数据绑定，这使得ViewModel 的状态改变可以自动传递给 View，即所谓的数据双向绑定。
其中 M 层 是vue中的data, V层是el绑定的HTML元素, VM是new实例的vue
我们在页面中通过script标签引入我们需要的vue
var VM = new Vue({
  el: '#app', // 表示当我们new的这个Vue实例, 要控制页面上的那个区域
  data: { // data属性中，存放的是el中要用到的数据,这里的data就是MVVM中的M专门用来保存每个页面的数据
    message: 'Hello Vue!'
  },
  methods : {}, // 这个methods属性中定义了当前Vue实例所有可用的方法,主要写业务逻辑
  computed: {}, // 在computed中,可以定一些属性, 这些属性叫做计算属性,计算属性的本质就是一个方法,只不过我们在使用这些计算属性的时候是吧它们的名称直接当做属性来使用的,并不会把计算属性当做方法去调用
  filters : {}, // 这个filters属性中定义了当前Vue实例中所有可用的过滤的方法 
  watch: {}, // 使用这个属性,可以监听data中数据的变化,然后触发这个watch中对应的function处理函数
  router, // 挂载路由对象
  directives：{}, // 这个directives属性定义了当前Vue实例中所有可用的自定义指令
  beforeCreate () {}, // 生命周期函数: 表示实例完全被创建之前,会执行这个函数
  created () {}, // 生命周期函数: 表示实例被创建之后
  beforeMounted () {}, // 生命周期函数: 表示模板已经编译完成,但是还没有把模板渲染到页面中
  mounted () {}, // 生命周期函数:表示模板已经编译完成,内存中的模板已经真实的渲染到了页面中去,已经可以看到渲染好的页面了
  beforeUpdate () {}, // 生命周期函数: 表示当前界面还没有被更新,数据肯定被更新了
  update () {}, // 生命周期函数: 表示当前页面和数据保持同步了,都是最新的
  beforeDestroy () {}, // 生命周期函数: 表示Vue实例已经从运行阶段进入到销毁阶段
  destroyed () {} // 生命周期函数: 表示组件已经完全被销毁了
})

vue可以自定义全局和局部指令 

v-model指令
Vue中唯一一个实现双向数据绑定的指令, 注意 : 只能运用到表单元素中

https://juejin.im/post/5c9d682d5188251c550be56a 教程

个人推荐在使用Vue的时候如果动画效果简单自己写就行，复杂的话在引用第三方动画库。而且在给元素添加动画的时候，要考虑清楚是加全程动画还是半程动画就够类。
组件是Vue可以复用的Vue实例，且带有一个名字，在Vue中我们可以定义多个组件，在多个不同的页面的中引用多个多不同的组件，减少开发的工作量。因为组件是可复用的Vue实例，所以它们与new Vue接收相同的选项
组件通信中，子组件是无法访问到父组件中的数据和方法的。
父组件可以在引用子组件的时候，通过属性绑定(v-bind)的形式，把数据传递给子组件使用。
父组件通过自定义属性传过来的数据，需要子组件在props属性上接收才能使用。

vetur 插件
  data: { // data属性中，存放的是el中要用到的数据,这里的data就是MVVM中的M专门用来保存每个页面的数据

VS Code 本来是前端人员专用，但由于它实在是太好用了，于是，各种开发方向的码农也正在用 VS Code 作为他们的主力编程工具。甚至是一些写作的同学，也把 VS Code 作为 markdown 写作工具。

VS Code 的全称是 Visual Studio Code，是一款开源的、免费的、高性能的、跨平台的、轻量级的代码编辑器。它在性能、语言支持、开源社区方面，都做的很不错。

IDE和编辑器是有区别的：

IDE ：对代码会有较好的智能提示，同时侧重于工程项目，对项目的开发、调试工作有较好的图像化界面的支持，因此比较笨重。比如 Eclipse 的定位就是 IDE。

编辑器：要相对轻量许多，侧重于文本的编辑。比如 Sublime Text 的定位就是编辑器。再比如 Windows 系统自带的「记事本」就是最简单的编辑器。

需要注意的是，VS Code 的定位是编辑器，而非IDE。

https://github.com/qianguyihao/Web/blob/master/00-%E5%89%8D%E7%AB%AF%E5%B7%A5%E5%85%B7/06-chrome%E6%B5%8F%E8%A7%88%E5%99%A8.md

排版标签：<p>     <div>     <span>``<br>     <hr>     <center>     <pre>
字体标记：<h1>    <font>    <b>    <u>    <sup>    <sub>
  
结构：html。表现：css。行为：JavaScript。
