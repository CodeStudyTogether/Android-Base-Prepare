对okhttp的封装，代理模式

Handler Looper Message 关系是什么？
Messagequeue 的数据结构是什么？为什么要用这个数据结构？
如何在子线程中创建 Handler?
Handler post 方法原理？

提起Android消息机制，其中包含三个部分：Handler，MessageQueue以及Looper，三者共同协作，完成消息机制的运行。
Message：需要传递的消息，可以传递数据；
MessageQueue：消息队列，但是它的内部实现并不是用的队列，实际上是通过一个单链表的数据结构来维护消息列表，因为单链表在插入和删除上比较有优势。主要功能向消息池投递消息(MessageQueue.enqueueMessage)和取走消息池的消息(MessageQueue.next)；
Handler：消息辅助类，主要功能向消息池发送各种消息事件(Handler.sendMessage)和处理相应消息事件(Handler.handleMessage)；
Looper：不断循环执行(Looper.loop)，从MessageQueue中读取消息，按分发机制将消息分发给目标处理者。
消息机制的运行流程：在子线程执行完耗时操作，当Handler发送消息时，将会调用MessageQueue.enqueueMessage，向消息队列中添加消息。当通过Looper.loop开启循环后，会不断地从线程池中读取消息，即调用MessageQueue.next，然后调用目标Handler（即发送该消息的Handler）的dispatchMessage方法传递消息，然后返回到Handler所在线程，目标Handler收到消息，调用handleMessage方法，接收消息，处理消息。
MessageQueue，Handler和Looper三者之间的关系：每个线程中只能存在一个Looper，Looper是保存在ThreadLocal中的。主线程（UI线程）已经创建了一个Looper，所以在主线程中不需要再创建Looper，但是在其他线程中需要创建Looper。每个线程中可以有多个Handler，即一个Looper可以处理来自多个Handler的消息。 Looper中维护一个MessageQueue，来维护消息队列，消息队列中的Message可以来自不同的Handler。
创建Looper,并保存在ThreadLocal。其中ThreadLocal是线程本地存储区（Thread Local Storage，简称为TLS），每个线程都有自己的私有的本地存储区域，不同线程之间彼此不能访问对方的TLS区域。
在创建 Handler 之前一定需要先创建 Looper 。
由于 Handler 的特性，它在 Android 里的应用非常广泛，比如： AsyncTask、HandlerThread、Messenger、IdleHandler 和 IntentService 等等。
将 Handler 定义成静态的内部类，在内部持有 Activity 的弱引用，并及时移除所有消息。
主线程不允许退出，退出就意味 APP 要挂。
ThreadLocal并不是一个Thread，而是Thread的局部变量。当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
从线程的角度看，目标变量就象是线程的本地变量，这也是类名中“Local”所要表达的意思。

启动模式以及使用场景?
onNewIntent()和onConfigurationChanged()
onSaveInstanceState()和onRestoreInstanceState()
Activity 到底是如何启动的

standard：标准模式：如果在mainfest中不设置就默认standard；standard就是新建一个Activity就在栈中新建一个activity实例；
singleTop：栈顶复用模式：与standard相比栈顶复用可以有效减少activity重复创建对资源的消耗，但是这要根据具体情况而定，不能一概而论；
singleTask：栈内单例模式，栈内只有一个activity实例，栈内已存activity实例，在其他activity中start这个activity，Android直接把这个实例上面其他activity实例踢出栈GC掉；
singleInstance :堆内单例：整个手机操作系统里面只有一个实例存在就是内存单例；
在singleTop、singleTask、singleInstance 中如果在应用内存在Activity实例，并且再次发生startActivity(Intent intent)回到Activity后,由于并不是重新创建Activity而是复用栈中的实例，因此Activity再获取焦点后并没调用onCreate、onStart，而是直接调用了onNewIntent(Intent intent)函数；
FLAG_ACTIVITY_CLEAR_TOP : 等同于mainfest中配置的singleTask，没啥好讲的；
FLAG_ACTIVITY_SINGLE_TOP: 同样等同于mainfest中配置的singleTop;
FLAG_ACTIVITY_NEW_TASK
ActivityManagerServices，简称AMS，服务端对象，负责系统中所有Activity的生命周期
ActivityThread，App的真正入口。当开启App之后，会调用main()开始运行，开启消息循环队列，这就是传说中的UI线程或者叫主线程。与ActivityManagerServices配合，一起完成Activity的管理工作
ApplicationThread，用来实现ActivityManagerService与ActivityThread之间的交互。在ActivityManagerService需要管理相关Application中的Activity的生命周期时，通过ApplicationThread的代理对象与ActivityThread通讯。
ApplicationThreadProxy，是ApplicationThread在服务器端的代理，负责和客户端的ApplicationThread通讯。AMS就是通过该代理与ActivityThread进行通信的。
Instrumentation，每一个应用程序只有一个Instrumentation对象，每个Activity内都有一个对该对象的引用。Instrumentation可以理解为应用进程的管家，ActivityThread要创建或暂停某个Activity时，都需要通过Instrumentation来进行具体的操作。
ActivityStack，Activity在AMS的栈管理，用来记录已经启动的Activity的先后关系，状态信息等。通过ActivityStack决定是否需要启动新的进程。
ActivityRecord，ActivityStack的管理对象，每个Activity在AMS对应一个ActivityRecord，来记录Activity的状态以及其他的管理信息。其实就是服务器端的Activity对象的映像。
TaskRecord，AMS抽象出来的一个“任务”的概念，是记录ActivityRecord的栈，一个“Task”包含若干个ActivityRecord。AMS用TaskRecord确保Activity启动和退出的顺序。如果你清楚Activity的4种launchMode，那么对这个概念应该不陌生。
在Android系统里面，zygote是一个进程的名字。Android是基于Linux System的，当你的手机开机的时候，Linux的内核加载完成之后就会启动一个叫“init“的进程。在Linux System里面，所有的进程都是由init进程fork出来的，我们的zygote进程也不例外。
其实服务器客户端的概念不仅仅存在于Web开发中，在Android的框架设计中，使用的也是这一种模式。服务器端指的就是所有App共用的系统服务，比如我们这里提到的ActivityManagerService，和前面提到的PackageManagerService、WindowManagerService等等，这些基础的系统服务是被所有的App公用的，当某个App想实现某个操作的时候，要告诉这些系统服务，比如你想打开一个App，那么我们知道了包名和MainActivity类名之后就可以打开
我们的App和AMS(SystemServer进程)还有zygote进程分属于三个独立的进程，他们之间如何通信呢？
App与AMS通过Binder进行IPC通信，AMS(SystemServer进程)与zygote通过Socket进行IPC通信。
如果是用户自动按下返回键，或程序调用finish()退出程序，是不会触发onSaveInstanceState()和onRestoreInstanceState()的。

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
