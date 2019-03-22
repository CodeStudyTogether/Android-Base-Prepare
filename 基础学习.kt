讲讲你看的Android源码
https://zhuanlan.zhihu.com/p/20564614

观察者模式又被称作发布/订阅模式，观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
EventBus 
https://blog.csdn.net/u012124438/article/details/55294914

什么是线程安全和线程不安全
https://blog.csdn.net/Mrzhoug/article/details/51197670
首先要明白线程的工作原理，jvm有一个main memory，而每个线程有自己的working memory，一个线程对一个variable进行操作时，都要在自己的working memory里面建立一个copy，操作完之后再写入main memory。多个线程同时操作同一个variable，就可能会出现不可预知的结果。
线程安全就是说多线程访问同一代码，不会产生不确定的结果。
