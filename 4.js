vue生命周期：

四个阶段：
create 准备工作 （数据的初始化。。。）
mount  挂载前后针对元素进行操作
update 数据发生变化，
destroy 清理工作 (关闭定时器、集合清空..)

beforeCreate/created
beforeMount/mounted
beforeUpdate/updated
beforeDestroy/destroyed

SPA：single page application 单一页面应用程序，只有一个完整的页面；
它在加载页面时，不会加载整个页面，而是只更新某个指定的容器中内容。
比如Gmail、移动的webApp

