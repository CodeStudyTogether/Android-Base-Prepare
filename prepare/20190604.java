1、Java 相关

容器（HashMap、HashSet、LinkedList、ArrayList、数组等）
HashMap可以接受null键值和值，而Hashtable则不能；HashMap是非synchronized;HashMap很快；以及HashMap储存的是键值对等等。
HashMap基于hashing原理，我们通过put()和get()方法储存和获取对象。当我们将键值对传递给put()方法时，它调用键对象的hashCode()方法来计算hashcode，让后找到bucket位置来储存值对象。当获取对象时，通过键对象的equals()方法找到正确的键值对，然后返回值对象。HashMap使用链表来解决碰撞问题，当发生碰撞了，对象将会储存在链表的下一个节点中。 HashMap在每个链表节点中储存键值对对象。
当两个不同的键对象的hashcode相同时会发生什么？ 它们会储存在同一个bucket位置的链表中。键对象的equals()方法用来找到键值对。
HashSet中不允许有重复元素，这是因为HashSet是基于HashMap实现的，
HashSet中的元素，只是存放在了底层HashMap的key上， 而value使用一个static final的Object对象标识。
HashSet底层由HashMap实现
HashSet的值存放于HashMap的key上
HashMap的value统一为PRESENT
1. ArrayList是实现了基于动态数组的数据结构，而LinkedList是基于链表的数据结构；
2. 对于随机访问get和set，ArrayList要优于LinkedList，因为LinkedList要移动指针；
3. 对于添加和删除操作add和remove，一般大家都会说LinkedList要比ArrayList快，因为ArrayList要移动数据。

内存模型
Java内存模型即Java Memory Model，简称JMM。JMM定义了Java 虚拟机(JVM)在计算机内存(RAM)中的工作方式。JVM是整个计算机虚拟模型，所以JMM是隶属于JVM的。
https://blog.csdn.net/suifeng3051/article/details/52611310
JMM决定一个线程对共享变量的写入何时对另一个线程可见。从抽象的角度来看，JMM定义了线程和主内存之间的抽象关系：线程之间的共享变量存储在主内存（main memory）中，每个线程都有一个私有的本地内存（local memory），本地内存中存储了该线程以读/写共享变量的副本。
1. 首先，线程A把本地内存A中更新过的共享变量刷新到主内存中去。
2. 然后，线程B到主内存中去读取线程A之前已更新过的共享变量。 
在JVM内部，Java内存模型把内存分成了两部分：线程栈区和堆区

垃圾回收算法（JVM）
Java语言规范没有明确地说明JVM使用哪种垃圾回收算法，但是任何一种垃圾回收算法一般要做2件基本的事情：（1）发现无用信息对象；（2）回收被无用对象占用的内存空间，使该空间可被程序再次使用。　　
引用计数法
无法检测出循环引用。如父对象有一个对子对象的引用，子对象反过来引用父对象。这样，他们的引用计数永远不可能为0.
tracing算法(Tracing Collector) 或 标记-清除算法(mark and sweep)
根搜索算法是从离散数学中的图论引入的，程序把所有的引用关系看作一张图，从一个节点GC ROOT开始，寻找对应的引用节点，找到这个节点以后，继续寻找这个节点的引用节点，当所有的引用节点寻找完毕之后，剩余的节点则被认为是没有被引用到的节点，即无用的节点。
https://www.cnblogs.com/sunniest/p/4575144.html

类加载过程（需要多看看，重在理解，对于热修复和插件化比较重要）
当我们的Java代码编译完成后，会生成对应的 class 文件。接着我们运行java Demo命令的时候，我们其实是启动了JVM 虚拟机执行 class 字节码文件的内容。而 JVM 虚拟机执行 class 字节码的过程可以分为七个阶段：加载、验证、准备、解析、初始化、使用、卸载。
其实加载阶段用一句话来说就是：把代码数据加载到内存中。
当代码数据被加载到内存中后，虚拟机就会对代码数据进行校验，看看这份代码是不是真的按照JVM规范去写的。
当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
从上面几个例子可以看出，分析一个类的执行顺序大概可以按照如下步骤：
确定类变量的初始值。在类加载的准备阶段，JVM 会为类变量初始化零值，这时候类变量会有一个初始的零值。如果是被 final 修饰的类变量，则直接会被初始成用户想要的值。
初始化入口方法。当进入类加载的初始化阶段后，JVM 会寻找整个 main 方法入口，从而初始化 main 方法所在的整个类。当需要对一个类进行初始化时，会首先初始化类构造器（），之后初始化对象构造器（）。
初始化类构造器。JVM 会按顺序收集类变量的赋值语句、静态代码块，最终组成类构造器由 JVM 执行。
初始化对象构造器。JVM 会按照收集成员变量的赋值语句、普通代码块，最后收集构造方法，将它们组成对象构造器，最终由 JVM 执行。
如果在初始化 main 方法所在类的时候遇到了其他类的初始化，那么就先加载对应的类，加载完成之后返回。如此反复循环，最终返回 main 方法所在类。

反射
Java 反射机制在程序运行时，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性。这种 动态的获取信息 以及 动态调用对象的方法 的功能称为 java 的反射机制。
反射机制很重要的一点就是“运行时”，其使得我们可以在程序运行时加载、探索以及使用编译期间完全未知的 .class 文件。换句话说，Java 程序可以加载一个运行时才得知名称的 .class 文件，然后获悉其完整构造，并生成其对象实体、或对其 fields（变量）设值、或调用其 methods（方法）。

多线程和线程池
线程：进程中负责程序执行的执行单元。一个进程中至少有一个线程。
如何在Java中实现线程？
创建线程有两种方式：
一、继承 Thread 类，扩展线程。
二、实现 Runnable 接口。
Runnable 和 Callable 都代表那些要在不同的线程中执行的任务。Runnable 从 JDK1.0 开始就有了，Callable 是在 JDK1.5 增加的。它们的主要区别是 Callable 的 call() 方法可以返回值和抛出异常，而 Runnable 的 run() 方法没有这些功能。Callable 可以返回装载有计算结果的 Future 对象。
所有加上 synchronized 的方法和块语句，在多线程访问的时候，同一时刻只能有一个线程能够访问。
ThreadLocal 是Java里一种特殊的变量。每个线程都有一个 ThreadLocal 就是每个线程都拥有了自己独立的一个变量
1）避免线程的创建和销毁带来的性能开销。
2）避免大量的线程间因互相抢占系统资源导致的阻塞现象。
3｝能够对线程进行简单的管理并提供定时执行、间隔执行等功能。
1）newCachedThreadPool 是一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。调用 execute() 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。因此，长时间保持空闲的线程池不会使用任何资源。注意，可以使用 ThreadPoolExecutor 构造方法创建具有类似属性但细节不同（例如超时参数）的线程池。
2）newSingleThreadExecutor 创建是一个单线程池，也就是该线程池只有一个线程在工作，所有的任务是串行执行的，如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它，此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
3）newFixedThreadPool 创建固定大小的线程池，每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小，线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
4）newScheduledThreadPool 创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求。
  
HTTP、HTTPS、TCP/IP、Socket通信、三次握手四次挥手过程
HTTPS协议相比HTTP更安全多了SSL（Security Sockets Layer，安全套接层） 为网络通信提供安全及数据完整性的一种安全协议 是操作系统对外的API, SSL3.0后更名为TLS 采用身份验证和数据加密保证网络通信的安全和数据的完整性两者区别：1、HTTPS需要到CA申请证书，HTTP不需要2、HTTPS密文传输，HTTP明文传输3、连接方式不同，HTTPS默认使用443端口，HTTP使用80端口4、HTTPS=HTTP+加密+认证+完整性保护，比HTTP安全
因为互联网协议包含了上百种协议标准，但是最重要的两个协议是TCP和IP协议，所以，大家把互联网的协议简称TCP/IP协议。
IP协议负责把数据从一台计算机通过网络发送到另一台计算机。
TCP协议则是建立在IP协议之上的。TCP协议负责在两台计算机之间建立可靠连接，保证数据包按顺序到达。TCP协议会通过握手建立连接，然后，对每个IP包编号，确保对方按顺序收到，如果包丢掉了，就自动重发。
许多常用的更高级的协议都是建立在TCP协议基础上的，比如用于浏览器的HTTP协议、发送邮件的SMTP协议等。
Socket是一个网络通信的套接字(接口)
https://zhuanlan.zhihu.com/p/29814861
一个套接字都有自己的IP地址和端口号,两两套接字直接通过IP地址和端口号对应，这就保证了信息在两台主机的程序之间的准确传输。 
在TCP/IP协议中,TCP协议提供可靠的连接服务,采用三次握手建立一个连接.
第一次握手：建立连接时,客户端发送syn包(syn=j)到服务器,并进入SYN_SEND状态,等待服务器确认； 
SYN：同步序列编号(Synchronize Sequence Numbers)
第二次握手：服务器收到syn包,必须确认客户的SYN（ack=j+1）,同时自己也发送一个SYN包（syn=k）,即SYN+ACK包,此时服务器进入SYN_RECV状态； 
第三次握手：客户端收到服务器的SYN＋ACK包,向服务器发送确认包ACK(ack=k+1),此包发送完毕,客户端和服务器进入ESTABLISHED状态,完成三次握手.
完成三次握手,客户端与服务器开始传送数据
所谓三次握手（Three-Way Handshake）即建立TCP连接，就是指建立一个TCP连接时，需要客户端和服务端总共发送3个包以确认连接的建立。在socket编程中，这一过程由客户端执行connect来触发，整个流程如下图所示：
三次握手耳熟能详，四次挥手估计就，所谓四次挥手（Four-Way Wavehand）即终止TCP连接，就是指断开一个TCP连接时，需要客户端和服务端总共发送4个包以确认连接的断开。在socket编程中，这一过程由客户端或服务端任一方执行close来触发
https://blog.csdn.net/younglao/article/details/79453777
这是因为服务端在LISTEN状态下，收到建立连接请求的SYN报文后，把ACK和SYN放在一个报文里发送给客户端。而关闭连接时，当收到对方的FIN报文时，仅仅表示对方不再发送数据了但是还能接收数据，己方也未必全部数据都发送给对方了，所以己方可以立即close，也可以发送一些数据给对方后，再发送FIN报文给对方来表示同意现在关闭连接，因此，己方ACK和FIN一般都会分开发送。

设计模式（六大基本原则、项目中常用的设计模式、手写单例等）
单一职责原则告诉我们实现类要职责单一；里氏替换原则告诉我们不要破坏继承体系；依赖倒置原则告诉我们要面向接口编程；接口隔离原则告诉我们在设计接口的时候要精简单一；迪米特法则告诉我们要降低耦合。而开闭原则是总纲，他告诉我们要对扩展开放，对修改关闭。

断点续传
断点续传和断点下载都是用的RandomAccessFile, 它具有移动指定的文件大小的位置的功能seek 。
断点续传是由服务器给客户端一个已经上传的位置标记position，然后客户端再将文件指针移动到相应的position，通过输入流将文件剩余部分读出来传输给服务器
断点下载 是由客户端告诉服务器已经下载的大小，然后服务器会将指针移动到相应的position，继续读出，把文件返回给客户端。 当然为了下载的更快一下，也可以多线程下载，那么基本实现就是给每个线程分配固定的字节的文件，分别去读

2、Android 基础

自定义 View（参考链接：自定义View，有这一篇就够了 - 简书、Android 自定义 View）
自定义View我们大部分时候只需重写两个函数：onMeasure()、onDraw()。
EXACTLY	当前的尺寸就是当前View应该取的尺寸
AT_MOST	当前尺寸是当前View能取的最大尺寸
构造方法、onFinishInflate、onMeasure、onSizeChanged、onLayout、onDraw、dispatchDraw。后两个是为 ViewGroup 绘制背景以及绘制子 View 的方法

事件拦截分发(Android事件分发机制，大表哥带你慢慢深入 - 简书 )
事件分發過程由dispatchTouchEvent() 、onInterceptTouchEvent()和onTouchEvent()三個方法協助完成
Android事件分發順序:Activity(Window) -> ViewGroup -> View
在事件分發三大類(Activity、ViewGroup、View)中,Activity和View不會去攔截事件(也就是不能重寫onInterceptTouchEvent()方法)
總結:首先,我們應該理解onTouchEvent方法的觸發滿足的條件,在正常流程下,我們提到過整個流程呈U形,U形的轉折點就是從Activity開始事件向下分發到最後一個View或者ViewGroup的onTouchEvent()方法。 
1.返回true:立即消費掉事件,事件將不會向上傳遞,事件到此終止。。
2.返回false/super:不消費掉此次事件,事件將會層層向上傳遞,直到被消費。
1.dispatchTouchEvent 和 onTouchEvent 一旦return true,事件就停止傳遞了(到達終點)(沒有誰能再收到這個事件)。看下圖中只要return true事件就沒再繼續傳下去了,對於return true我們經常說事件被消費了,消費了的意思就是事件走到這裡就是終點,不會往下傳,沒有誰能再收到這個事件了。 
2.dispatchTouchEvent 和 onTouchEvent方法在return false的時候事件都回傳給父控制元件的onTouchEvent處理。 
對於dispatchTouchEvent 返回 false 的含義應該是:事件停止往子View傳遞和分發同時開始往父控制元件回溯(父控制元件的onTouchEvent開始從下往上回傳直到某個onTouchEvent return true),事件分發機制就像遞迴,return false 的意義就是遞迴停止然後開始回溯。 
對於onTouchEvent return false 就比較簡單了,它就是不消費事件,並讓事件繼續往父控制元件的方向從下往上流動。 
3.onInterceptTouchEvent 的作用 
onInterceptTouchEvent方法中 return true就會交給自己的onTouchEvent的處理,如果不攔截就是繼續往子控制元件往下傳。預設是不會去攔截的,因為子View也需要這個事件,所以onInterceptTouchEvent攔截器return super.onInterceptTouchEvent()和return false是一樣的,是不會攔截的,事件會繼續往子View的dispatchTouchEvent傳遞。 
  
解决过的一些性能问题，在项目中的实际运用。
性能优化工具  (TraceView、Systrace、调试 GPU 过度绘制 & GPU 呈现模式分析、Hierarchy Viewer、MAT、Memory Monitor & Heap Viewer & Allocation Tracker 等）
性能优化
（1）网络：API 优化、流量优化、弱网优化
首次域名解析一般需要几百毫秒，可通过直接向 IP 而非域名请求，节省掉这部分时间，同时可以预防域名劫持等带来的风险。
当然为了安全和扩展考虑，这个 IP 可能是一个动态更新的 IP 列表，并在 IP 不可用情况下通过域名访问。
使用WebP格式；同样的照片，采用WebP格式可大幅节省流量，相对于JPG格式的图片，流量能节省将近 25% 到 35 %；相对于 PNG 格式的图片，流量可以节省将近80%。最重要的是使用WebP之后图片质量也没有改变。
对服务端返回数据进行缓存，设定有效时间，有效时间之内不走网络请求，减少流量消耗。对网络的缓存可以参见HttpResponseCache。
（2）内存：OOM 处理、内存泄漏、内存检测、分析、Bitmap 优化
（3）绘制
（4）电量：WeakLock 机制、JobScheduler 机制
https://blog.csdn.net/u012124438/article/details/74617649
JobSchedule的宗旨就是把一些不是特别紧急的任务放到更合适的时机批量处理。
（5）APK 瘦身
（6）内存抖动
内存抖动是由于短时间内有大量对象进出新生区导致的，它伴随着频繁的GC。 gc会大量占用ui线程和cpu资源，会导致app整体卡顿
尽量避免在循环体内创建对象，应该把对象创建移到循环体外。
注意自定义View的onDraw()方法会被频繁调用，所以在这里面不应该频繁的创建对象。
当需要大量使用Bitmap的时候，试着把它们缓存在数组中实现复用。
对于能够复用的对象，同理可以使用对象池将它们缓存起来。
（7）内存泄漏
（8）卡顿
（9）性能优化：布局优化、过度渲染处理、ANR 处理、监控、埋点、Crash 上传。
InputDispatching Timeout：5秒内无法响应屏幕触摸事件或键盘输入事件
BroadcastQueue Timeout ：在执行前台广播（BroadcastReceiver）的onReceive()函数时10秒没有处理完成，后台为60秒。
Service Timeout ：前台服务20秒内，后台服务在200秒内没有执行完毕。
尽量避免在主线程（UI线程）中作耗时操作。
我们先来说说Service，主要用于在后台处理一些耗时的逻辑，或者去执行某些需要长期运行的任务。但很多同志认为Service就可以执行耗时任务，这是一种误解，Service本身也运行于主线程，执行耗时任务同样会发生ANR。此处只分析Service Timeout的出发场景。

IntentService 原理及应用
IntentService是Service的子类,由于Service里面不能做耗时的操作,所以Google提供了IntentService,在IntentService内维护了一个工作线程来处理耗时操作，当任务执行完后，IntentService会自动停止。另外，可以启动IntentService多次，而每一个耗时操作会以工作队列的方式在IntentService的onHandleIntent回调方法中执行，并且，每次只会执行一个工作线程，执行完第一个再执行第二个，以此类推。
HandlerThread就是一个带有handler的thread,这里就是创建了一个线程,注意这个线程的名字

缓存自己如何实现（LRUCache 原理）
图形图像相关：OpenGL ES 管线流程、EGL 的认识、Shader 相关
在OpenGL中，任何事物都在3D空间中，而屏幕和窗口却是2D像素数组，这导致OpenGL的大部分工作都是关于把3D坐标转变为适应你屏幕的2D像素。

SurfaceView、TextureView、GLSurfaceView 区别及使用场景
SurfaceView和TextureView都继承自android.view.View类。它们可以从单独的线程中绘制和渲染，这是与其他视图的主要区别。
SurfaceView提供嵌入视图层次结构内部的专用绘图表面。你可以控制这个曲面的格式和大小; SurfaceView会将表面放置在屏幕上的正确位置。它的行为或多或少地类似于传统桌面系统上的屏幕窗口，例如，X11系统上的XWindow，它可以是无框的，并嵌入在另一个XWindow中。
以下是SurfaceView的两个限制：
不能动画，变换和缩放;
不能覆盖两个SurfaceView。
TextureView看起来像一个普通的View。你可以动画，变换和缩放它，就像一个TextView。 TextureView只能在硬件加速窗口中使用。然而，TextureView将消耗比SurfaceView更多的内存，也可能有1〜3帧延迟。
它可以看作是SurfaceView的一种典型使用模式。在SurfaceView的基础上，它加入了EGL的管理，并自带了渲染线程。另外它定义了用户需要实现的Render接口，提供了用Strategy pattern更改具体Render行为的灵活性。作为GLSurfaceView的Client，只需要将实现了渲染函数的Renderer的实现类设置给GLSurfaceView即可。

动画、差值器、估值器（Android中的View动画和属性动画 - 简书、Android 动画 介绍与使用）
我们都知道对于属性动画可以对某个属性做动画，而插值器（TimeInterpolator）和估值器（TypeEvaluator）在其中扮演了重要角色，下面先了解下TimeInterpolator和TypeEvaluator。

MVC、MVP、MVVM
Handler、ThreadLocal、AsyncTask
Gradle（Groovy 语法、Gradle 插件开发基础）
热修复、插件化

3、Android Framework

AMS 、PMS
PackageManagerService(PMS)主要是管理应用的安装，卸载，更新，解析以及权限。
同AMS一样，PMS也是由SystemServer启动的.
　1、通过installer与installd进行连接，进行安装卸载应用操作
 　　2、创建PacakageHandler线程，处理外部应用的安装卸载请求
 　　3、处理系统权限相关配置
 　　4、扫描安装应用，并解析APK安装包信息
   这个Socket用来等待AMS来请求Zygote来创建新的应用程序进程。要启动一个应用程序，首先要保证这个应用程序所需要的应用程序进程已经被启动。AMS在启动应用程序时会检查这个应用程序需要的应用程序进程是否存在，不存在就会请求Zygote进程将需要的应用程序进程启动。

Activity 启动流程
初始化主线程的Looper、主Handler。并使主线程进入等待接收Message消息的无限循环状态。
ActivityManagerService调度发送初始化消息

Binder 机制（IPC、AIDL 的使用）

为什么使用 Parcelable，好处是什么？
Parcelable的性能比Serializable好，在内存开销方面较小，所以在内存间数据传输时推荐使用Parcelable，如activity间传输数据，而Serializable可将数据持久化方便保存，所以在需要保存或网络传输数据时选择Serializable，因为android不同版本Parcelable可能不同，所以不推荐使用Parcelable进行数据持久化

Android 图像显示相关流程，Vsync 信号等
VSync信号通常都来自硬件控制器，在Android中也可以采用软件模拟； 
LCD的频率是60Hz，显示每一帧的间隔是16ms，所以每一个VSync信号的时间间隔是16ms

4、三方源码

Glide ：加载、缓存、LRU 算法

EventBus

LeakCanary

插件化（不同插件化机制原理与流派，优缺点。局限性）

热修复

RXJava

Retrofit


5、算法与数据结构

单链表：反转、插入、删除
双链表：插入、删除
手写常见排序、归并排序、堆排序
二叉树前序、中序、后序遍历
最大 K 问题
广度、深度优先搜索算法
可以去刷一下 LeetCode ,对自己提升也会比较大。
