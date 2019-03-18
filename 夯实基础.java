对okhttp的封装，代理模式

Handler Looper Message 关系是什么？
Messagequeue 的数据结构是什么？为什么要用这个数据结构？
如何在子线程中创建 Handler?
Handler post 方法原理？

启动模式以及使用场景?
onNewIntent()和onConfigurationChanged()
onSaveInstanceState()和onRestoreInstanceState()
Activity 到底是如何启动的

Fragment 生命周期和 Activity 对比
Fragment 之间如何进行通信
Fragment的startActivityForResult
Fragment重叠问题

进程保活
Service的运行线程（生命周期方法全部在主线程）
Service启动方式以及如何停止
ServiceConnection里面的回调方法运行在哪个线程？

什么情况下使用 ViewStub、include、merge？
他们的原理是什么？

注册方式，优先级
广播类型，区别
广播的使用场景，原理

AsyncTask是串行还是并行执行？
AsyncTask随着安卓版本的变迁

onTouch和onTouchEvent区别，调用顺序
dispatchTouchEvent， onTouchEvent， onInterceptTouchEvent 方法顺序以及使用场景
滑动冲突，如何解决

简述 View 绘制流程
onMeasure， onlayout， ondraw方法中需要注意的点
如何进行自定义 View
view 重绘机制

Android Window、Activity、DecorView以及ViewRoot

常见的 IPC 机制以及使用场景
为什么安卓要用 binder 进行跨进程传输
多进程带来的问题

Android 高级必备 ：AMS,WMS,PMS

为什么会发生 ANR？
如何定位 ANR？
如何避免 ANR？

注意：内存泄漏和内存溢出是 2 个概念
什么情况下会内存泄漏？
如何防止内存泄漏？

屏幕适配相关名词解析
现在流行的屏幕适配方式

LruCache使用极其原理

如何进行 内存 cpu 耗电 的定位以及优化
性能优化经常使用的方法
如何避免 UI 卡顿

Android MVC、MVP、MVVM

Android Gradle 知识

RxJava
使用过程，特点，原理解析

OKHTTP 和 Retrofit

最流行图片加载库： Glide

Android 组件化与插件化
业务大了代码多了会用到。
为什么要用组件化？
组件之间如何通信？
组件之间如何跳转？

除了上面整理的安卓高级技术问题，还有一些面试官喜欢问的点，大家针对准备回答：

你在项目中遇到最难得点是什么？如何解决的？
平时遇到问题了是如何解决的？比较好的回答： 官方文档一定要看，通过源码解决问题，然后才是搜索引擎以及和同事讨论
你最近做的 APP 是如何架构的？为什么要这样架构？
平时怎么进行技术进阶，如何学习？
你觉得自己处于什么技术水平？
你的技术优势是什么？

历时一周多终于整理完了，之所以准备这么久是因为以上每一篇文章我都认真看过，并且还有一些文章没有贴上来，因为质量上或者不易于理解，其中 安卓技术问题 我觉得基本逃不过上面我整理的，当然我会持续更新，其次更重要的是有的时候面试官问你问题如果你不会也很正常，不可能所有的问题我们都懂，但是我们必须有必要的思考过程，解决问题的过程与方式在职场中才是最重要的，而不是结果！这也是面试官最喜欢考察的。另外，我没有整理算法以及 java 基础问题，因为我是面向 Android 高级开发工程师准备的面试题，所以算法和 java 基础相信大家可以自行搜索复习。

https://juejin.im/post/5c8b1bd56fb9a049e12b1692
