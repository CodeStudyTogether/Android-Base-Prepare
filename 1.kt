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
