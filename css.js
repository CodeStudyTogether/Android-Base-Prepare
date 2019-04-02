http://zh.learnlayout.com

display 是CSS中最重要的用于控制布局的属性。每个元素都有一个默认的 display 值，这与元素的类型有关。对于大多数元素它们的默认值通常是 block 或 inline 。一个 block 元素通常被叫做块级元素。一个 inline 元素通常被叫做行内元素。

div 是一个标准的块级元素。一个块级元素会新开始一行并且尽可能撑满容器。其他常用的块级元素包括 p 、 form 和HTML5中的新元素： header 、 footer 、 section 等等。

span 是一个标准的行内元素。一个行内元素可以在段落中 <span> 像这样 </span> 包裹一些文字而不会打乱段落的布局。 a 元素是最常用的行内元素，它可以被用作链接。

另一个常用的display值是 none 。一些特殊元素的默认 display 值是它，例如 script 。 display:none 通常被 JavaScript 用来在不删除元素的情况下隐藏或显示元素。
它和 visibility 属性不一样。把 display 设置成 none 元素不会占据它本来应该显示的空间，但是设置成 visibility: hidden; 还会占据空间。

每个元素都有一个默认的 display 类型。不过你可以随时随地的重写它！虽然“人为制造”一个行内元素可能看起来很难以理解，不过你可以把有特定语义的元素改成行内元素。常见的例子是：把 li 元素修改成 inline，制作成水平菜单。

另一个布局中常用的CSS属性是 float 。Float 可用于实现文字环绕图片

百分比是一种相对于包含块的计量单位。它对图片很有用：如下我们实现了图片宽度始终是容器宽度的50%。

因为对于相同方式的样式表，其选择器排序的优先级为：ID选择器 > 类选择器 > 标签选择器

浮动是css里面布局用的最多的属性。

CSS基本上是设计师的工具，不是程序员的工具。在程序员的眼里，CSS是很头痛的事情，它并不像其它程序语言，比如说PHP、Javascript等等，有自己的变量、常量、条件语句以及一些编程语法，只是一行行单纯的属性描述，写起来相当的费事，而且代码难以组织和维护。

原生JS -> Jquery之类的类库 -> 前端模板引擎 -> Angular.js / Vue.js（能够帮助我们减少不必要的DOM操作；提高渲染效率；双向数据绑定的概念【通过框架提供的指令，我们前端程序员只需要关心数据的业务逻辑，不再关心DOM是如何渲染的了】）

Vue.js 是一套构建用户界面的框架，只关注视图层。

传统的web开发，是利用 jQuery操作DOM，这是非常耗资源的。

我们可以在 JS 的内存里构建类似于DOM的对象，去拼装数据，拼装完整后，把数据整体解析，一次性插入到html里去。这就形成了虚拟 DOM。

Vue1.0没有虚拟DOM，Vue2.0改成了基于虚拟DOM。

我们在本文的第一段中，通过Vue.component形式定义的是全局组件。

移动端开发的优势简单来说就是兼容性更好了，基本上只需要针对webkit内核的浏览器做兼容就好了，而且本身这类浏览器对html5、css3的兼容性就比较高，所以PC端不太敢用的属性就大胆的用起来吧。 
移动端还可以使用很多设备接口来实现更好的交互效果，比如陀螺仪实现类似3D VR效果，多指操作实现图片缩放旋转，获取地理位置等。

在Vue中导入全局样式(在main.js文件中写入下面的代码)
import './style/common.scss'
