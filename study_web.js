同源策略是浏览器的一种安全策略，所谓同源是指，域名，协议，端口完全相同。

界面上的所有JS操作不会被浏览器记住，就无法回到之前的状态。

H5 中有两种存储的方式
window.sessionStorage 会话存储：

保存在内存中。

生命周期为关闭浏览器窗口。也就是说，当窗口关闭时数据销毁。

在同一个窗口下数据可以共享。

window.localStorage 本地存储：

有可能保存在浏览器内存里，有可能在硬盘里。

永久生效，除非手动删除（比如清理垃圾的时候）。

可以多窗口共享。

（2）容量较大，sessionStorage 约5M、localStorage 约20M。

（3）只能存储字符串，可以将对象 JSON.stringify() 编码后存储。

收集几个流量大的网站(必须是vue做的)页面交互和逻辑尽可能复杂多样
对比一下各个页面的seo是如何做的
网站中出现率做多的公共组件或者公共方法是什么

vue-develop这个插件，只要你安装了这个插件，是vue的网站该插件的图标就会点亮 

高流量vue网站
1） www.bilibili.com （bilibili） 
2） m.sohu.com （手机搜狐网） 
3） juejin.im/timeline （掘金） 
4） element.eleme.io/#/en-US （element） 
5） classics.autotrader.com （New&Used Classic Car for sale） 
6） qiqu.uc.cn （奇趣百科） 
7） m.uhouzz.com/apartments （异乡好居）

构建工具的功能主要是：进行代码转换、文件压缩、代码分割、模块合并、自动刷新、代码检验、自动发布等功能。
