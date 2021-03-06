Kotlin 是一个基于 JVM 的新的编程语言，由 JetBrains 开发。JetBrains，作为目前广受欢迎的 Java IDE IntelliJ 的提供商，在 Apache 许可下已经开源其Kotlin 编程语言。

1.mipmap和drawable的区别
android 通过 mipmap 技术提前对按缩小层级生成图片预先存储在内存中，这样就提高了图片渲染的速度和质量。
2.jar和aar的区别
JAR 文件就是 Java Archive File，顾名思意，它的应用是与 Java 息息相关的，是 Java 的一种文档格式。只包含了class文件与清单文件 ，不包含资源文件
3.面向对象的特征有哪些方面  
抽象：
继承：继承与接口的区别
封装：
多态性：
4.String,StringBuffer,StringBuilder
在这方面运行速度快慢为：StringBuilder > StringBuffer > String
5.String 为什么要设计成不可变的？
字符串常量池(String pool, String intern pool, String保留池) 是Java堆内存中一个特殊的存储区域, 当创建一个String对象时,假如此字符串值已经存在于常量池中,则不会创建一个新的对象,而是引用已经存在的对象。
6.进程之间的优先级。 前台进程、可见进程、后台进程、不可见进程与空进程。腾讯面的时候还特意问了我进程的保活措施。
进程保活（不死进程）
7.Android屏幕切换 onConfigurationChanged
（1）不设置Activity的Android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次
（2）设置Activity的android:configChanges=”orientation”时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次
（3）设置Activity的android:configChanges=”orientation|keyboardHidden|screenSize”时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法。
8.自定义viewgroup和自定义view
9.Activity的四种launchMode
standard，singleTop，singleTask，singleInstance
10.Android启动Service的两种方式是什么? 它们的适用情况是什么
11.java的反射
12.注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意
13.Android内存泄露
如果静态变量持有某个Activity的context，则会引发对应Activity无法释放，导致内存泄漏。
内部类引用导致Activity的泄漏
Cursor
性能问题：
优化布局层次，减少内存消耗 布局优化(include、merge和viewstub标签的使用)
绘制优化(不要在onDraw方法里面创建新的对象)
stringbuilder
listview 性能优化
14.Service的onCreate回调在UI线程中吗？在的
15.AsyncTask和Handler的源码，handlerthread，intentservice
16.Android中进程间通信有哪些实现方式？原理是什么
Intent，Binder（AIDL），Messenger，BroadcastReceiver
Bundle	简单易用	只能传输Bundle支持的数据类型	四大组件间的进程间通信
文件共享	简单易用	不适合高并发场景,并且无法做到进程间的即时通	无法并发访问情形, 交换简单的数据实时性不高的场景
AIDL	功能强大	使用稍复杂,需要处理好线程同步	一对多通信且有RPC需求
ContentProvider	在数据源访问方面功能强大,支持一对多并发数据共享	可以理解为受约束的AIDL,主要提供数据源的CRUD操作	一对多的进程间的数据共享
Messenger	功能一般, 支持一对多串行通信,支持实时通信	不能很好处理高并发,不支持RPC,数据通过Message进行传输, 因此只能传输Bundle支持的数据类型	低并发的一对多即时通信,无RPC需求,或者无需要返回结果的RPC需求
Socket	功能强大,可以通过网络传输字节流,支持一对多并发实时通信	实现细节稍微有点繁琐,不支持直接的RPC	网络数据交换
17.Android中touch事件的传递机制是怎样的
对于一个根ViewGroup来说，点击事件产生后，首先会传递给它，这时它的dispatchTouchEvent就会被调用，如果这个ViewGroup的onInterceptTouchEvent方法返回true就表示它要拦截当前事件，接着事件就会交给这个ViewGroup处理，即它的onTouchEvent方法就会被调用；如果这个ViewGroup的onInterceptTouchEvent方法返回false就表示它不拦截当前事件，这时当前事件就会继续传递给它的子元素，接着子元素的dispatchTouchEvent方法就会被调用，如此反复直到事件被最终处理。
dispatchTouchEvent() 、onInterceptTouchEvent()和onTouchEvent()

当TouchEvent发生时，首先Activity将TouchEvent传递给最顶层的View。
TouchEvent最先到达最顶层 view 的 dispatchTouchEvent ，然后由  dispatchTouchEvent 方法进行分发：如果dispatchTouchEvent返回true ，则交给这个view的onTouchEvent处理；如果dispatchTouchEvent返回 false ，则交给这个 view 的 interceptTouchEvent 方法来决定是否要拦截这个事件。
如果 interceptTouchEvent 返回 true ，也就是拦截掉了，则交给它的 onTouchEvent 来处理；如果 interceptTouchEvent 返回 false ，那么就传递给子 view ，由子 view 的 dispatchTouchEvent 再来开始这个事件的分发。
如果事件传递到某一层的子 view 的 onTouchEvent 上了，这个方法返回了 false ，那么这个事件会从这个 view 往上传递，都是 onTouchEvent 来接收。而如果传递到最上面的 onTouchEvent 也返回 false 的话，这个事件就会“消失”，而且接收不到下一次事件。
18.Android多线程的实现方式有哪些?
（1） Handler+Thread
（2）AsyncTask
（3）ThreadPoolExecutor
（4）IntentService
java中创建线程的方式有几种。（三种）
19.jvm
20.Java中的四种引用以及使用的场景
21.最近在研究Volley框架的源码，发现它在HTTP请求的使用上比较有意思，在Android 2.3及以上版本，使用的是HttpURLConnection，而在Android 2.2及以下版本，使用的是HttpClient。
22.http和https，socket和websocket
TCP协议中的三次握手和四次挥手
http1与http2的区别
TCP和UDP
TCP/IP协议
23.hashmap，arraylist，linkedlist等
如果两个值完全相同，那么它们具有相同的哈希值；反之则不一定成立。然而，与之对应，如果哈希值不同，也说明这两个值肯定不同。
24.Volley与okhttp和retrofit
25.7.0，8.0，9.0
26.volatile和transient
27.Serializable是Java自带的，而Parcelable是Android加入的。 
Serializable中为什么要设置UID，设置UID与不设置UID值的区别和影响。
28.android中的动画有哪几类，它们的特点和区别是什么  
答：两种，一种是Tween动画、还有一种是Frame动画。Tween动画，这种实现方式可以使视图组件移动、放大、缩小以及产生透明度的变化;另一种Frame动画，传统的动画方法，通过顺序的播放排列好的图片来实现，类似电影。
29.对称加密和非对称加密
30.红黑树：红黑树是特殊的二叉查找树，意味着它满足二叉查找树的特征：任意一个节点所包含的键值，大于等于左孩子的键值，小于等于右孩子的键值。
31.git rebase： git rebase 的黄金法则便是，绝不要在公共的分支上使用它。
