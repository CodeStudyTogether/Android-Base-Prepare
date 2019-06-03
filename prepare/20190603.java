https://mp.weixin.qq.com/s?__biz=MzI2OTQxMTM4OQ==&amp;mid=2247489077&amp;idx=1&amp;sn=c9a1348a8ac83d2d0e25cfb58f46eeb6&amp;chksm=eae1e367dd966a71140b131452956c41c1410b4fab9ae9c8b8032050ca3ab950f4a34f455d58&amp;token=1903328570&amp;lang=zh_CN#rd&comefrom=https://blogread.cn/news/

在字节跳动的两年时间中见证了抖音从百万日活到2.5亿、团队从10人到100多人的过程，技术上不同时期的选型以及迭代、沉淀和更替。项目上经历了一个工程到模块化再到组件化最后插件化，深刻理解项目不同阶段和不同体量的时候技术框架的选型。流程上不同阶段不同的方案，一直在探索最大的效率的协同开发。产品上从不断试错到稳步发展的过程，也就是数据驱动业务的过程。

按照这个原则这次面试我就大胆的面试架构师或者能够带人的职位，所以很多问题都是架构的考虑和知识的广度以及自己的思考，这些回答很大程度上是开放题，相信大家都有自己的想法和见解，我就不班门弄斧了

mcv适用于较小，功能较少，业务逻辑较少的项目。
ViewModle易于单元测试。
适用于界面展示的数据较多的项目。

设计模式六大原则
单一职责原则
里氏替换原则
依赖倒置原则
接口隔离原则
迪米特法则
开放封闭原则
单一职责原则告诉我们实现类要职责单一；里氏替换原则告诉我们不要破坏继承体系；依赖倒置原则告诉我们要面向接口编程；接口隔离原则告诉我们在设计接口的时候要精简单一；迪米特法则告诉我们要降低耦合。而开闭原则是总纲，他告诉我们要对扩展开放，对修改关闭。

访问者模式
https://img-blog.csdn.net/20161206165956259?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMTUxODEyMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
软件系统中拥有一个由许多对象构成的，比较稳定的对象结构。这些对象都拥有一个accept方法来接受访问者的访问。

日志系统
https://blog.csdn.net/feiyangxiaomi/article/details/45560313
PrintStream
存到本地数据库

日志上传
wifi的时候上传

顶点着色器是在 GPU 上运行的小程序。从名称可以看出，可通过处理它们来处理顶点。顶点着色器是处理顶点的微型程序。
像顶点着色器一样，片段着色器也是在 GPU 上运行的小程序。
最后，您在屏幕上看到效果取决于片段着色器。所以片段着色器是管理实际呈现的内容的代码。

VBO是OpenGL提供的一种特性，主要是用于在非立即模式下（使用glBegin/glEnd这种方式）用来保存顶点数据（包括位置、纹理、颜色等），同时提供了更新这些数据的方法。 VBO相比较立即模式的渲染来说效率更高，这主要是因为VBO的数据一般会放在显存中而不是内存中。通俗点说VBO就好像是显卡中开辟的一块存储区域，用来把以前放在内存中的数据放在了显存中，便于更加方便的传输处理。  VBO特性是在OpenGL1.5版本引入的。
着色器(Shader)是运行在GPU上的小程序。这些小程序为图形渲染管线的某个特定部分而运行。从基本意义上来说，着色器只是一种把输入转化为输出的程序。着色器也是一种非常独立的程序，因为它们之间不能相互通信；它们之间唯一的沟通只有通过输入和输出。

基本会遵从 Activity => ViewGroup => View 的顺序进行事件分发，然后通过调用 onTouchEvent() 方法进行事件的处理。我们在项目中一般会对  MotionEvent.ACTION_DOWN，MotionEvent.ACTION_UP，MotionEvent.ACTION_MOVE，MotionEvent.ACTION_CANCEL 分情况进行操作。
肯定是优先响应子 View 的
dispatchTouchEvent()
onTouchEvent()
onInterceptTouchEvent()
onTouch() 执行总优先于 onClick()
最先由Activity接收，然后再一层层的向下层传递，直到找到合适的处理控件。
但是如果事件传递到最后的View还是没有找到合适的View消费事件，那么事件就会向相反的方向传递，最终传递给Activity，如果最后 Activity 也没有处理，本次事件才会被抛弃
public boolean dispatchTouchEvent(MotionEvent ev) {
    boolean result = false;             // 默认状态为没有消费过

    if (!onInterceptTouchEvent(ev)) {   // 如果没有拦截交给子View
        result = child.dispatchTouchEvent(ev);
    }

    if (!result) {                      // 如果事件没有被消费,询问自身onTouchEvent
        result = onTouchEvent(ev);
    }

    return result;
}

可以通过开启ProGuard来实现代码压缩，可以在build.gradle文件相应的构建类型中添加minifyEnabled true。
减少ENUM的使用（详情可以参考：Remove Enumerations），每减少一个ENUM可以减少大约1.0到1.4 KB的大小；
资源使用webp格式

Dalvik是Google公司自己设计用于Android平台的虚拟机。
2014年6月25日，Android L 正式亮相于召开的谷歌I/O大会，Android L 改动幅度较大，谷歌将直接删除Dalvik，代替它的是传闻已久的ART。
即Android Runtime
ART 的机制与 Dalvik 不同。在Dalvik下，应用每次运行的时候，字节码都需要通过即时编译器（just in time ，JIT）转换为机器码，这会拖慢应用的运行效率，而在ART 环境中，应用在第一次安装的时候，字节码就会预先编译成机器码，使其成为真正的本地应用。这个过程叫做预编译（AOT,Ahead-Of-Time）。这样的话，应用的启动(首次)和执行都会变得更加快速。

模块指的是独立的业务模块，比如刚才提到的 [首页模块]、[直播间模块] 等。
组件指的是单一的功能组件，如 [视频组件]、[支付组件] 等，每个组件都可以以一个单独的 module 开发，并且可以单独抽出来作为 SDK 对外发布使用。
基础层： 基础层很容易理解，其中包含的是一些基础库以及对基础库的封装，比如常用的图片加载，网络请求，数据存储操作等等，其他模块或者组件都可以引用同一套基础库，这样不但只需要开发一套代码，还解耦了基础功能和业务功能的耦合，在基础库变更时更加容易操作。

https://blog.csdn.net/weixin_33716154/article/details/87121484
获取view层级  递归思想

千万不要在ListView中添加包含RecyclerView的HeaderView，否则会泄漏整个Activity，当然ListView的adpter中最好也不要使用RecyclerView，原因文末给出。如果要用最好是在RecyclerView中嵌套RecyclerView
作为Android开发者，一定要注意RecyclerView的使用，千万不要跟ListView一起使用，慎用！自定义View的时候设计到RecyclerView也要注意是否调用RecyclerView的onDetachedFromWindow方法

LruCache算法就是Least Recently Used，也就是最近最少使用算法。
他的算法就是当缓存空间满了的时候，将最近最少使用的数据从缓存空间中删除以增加可用的缓存空间来缓存新内容。
这个算分的内部有一个缓存列表。每当一个缓存数据被访问的时候，这个数据就会被提到列表头部，每次都这样的话，列表的尾部数据就是最近最不常使用的了，当缓存空间不足时，就会删除列表尾部的缓存数据。
LinkedHashMap
我们期待一个有序的Map.这就是我们的LinkedHashMap

字节码注入
AOP
在onClick中一般都要做防抖动操作，这样是为了避免多次打开页面的问题。一般实现的话是在每个onClick实现第二次点击的时候加个时间判断。而插桩的话业务端可以不写任何代码通过插桩的方法把这个时间判断插入的字节码里面。
我们的gradle插件采用 Android gradle 插件提供的最新的Transform API，在Apk编译环节中、class打包成dex之前，插入了中间环节，调用 ASM API对class文件的字节码进行扫描，当扫描到目标事件响应函数时，在函数头部或尾部插入SDK数据搜集代码。

put函数大致的思路为：

对key的hashCode()做hash，然后再计算index;
如果没碰撞直接放到bucket里；
如果碰撞了，以链表的形式存在buckets后；
如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树；
如果节点已经存在就替换old value(保证key的唯一性)
如果bucket满了(超过load factor*current capacity)，就要resize。

通过hash的方法，通过put和get存储和获取对象。存储对象时，我们将K/V传给put方法时，它调用hashCode计算hash从而得到bucket位置，进一步存储，HashMap会根据当前bucket的占用情况自动调整容量(超过Load Facotr则resize为原来的2倍)。获取对象时，我们将K传给get，它调用hashCode计算hash从而得到bucket位置，并进一步调用equals()方法确定键值对。如果发生碰撞的时候，Hashmap通过链表将产生碰撞冲突的元素组织起来，在Java 8中，如果一个bucket中碰撞冲突的元素超过某个限制(默认是8)，则使用红黑树来替换链表，从而提高速度。、

view的优化，减少层级

播放视频的基本流程是：解协议 → 解封装 → 解码 → 视音频同步。

启动方式分为两种：冷启动和热启动。
1、冷启动：当启动应用时，后台没有该应用的进程，这时系统会重新创建一个新的进程分配给该应用，这个启动方式就是冷启动
2、热启动：当启动应用时，后台已有该应用的进程（例：按back键、home键，应用虽然会退出，但是该应用的进程是依然会保留在后台，可进入任务列表查看），所以在已有进程的情况下，这种启动会从已有的进程中来启动应用，这个方式叫热启动。
利用Google官方文档推荐的方式，我们将启动页界面的主题设置为SplashTheme。此界面是冷启动后首先加载的界面
onCreate中尽量避免做过多的初始化动作，如果必须，那么考虑IntentService

点击桌面应用图标，Launcher进程将启动Activity（MainActivity）的请求以Binder的方式发送给了AMS。
AMS接收到启动请求后，交付ActivityStarter处理Intent和Flag等信息，然后再交给ActivityStackSupervisior/ActivityStack处理Activity进栈相关流程。同时以Socket方式请求Zygote进程fork新进程。
Zygote接收到新进程创建请求后fork出新进程。
在新进程里创建ActivityThread对象，新创建的进程就是应用的主线程，在主线程里开启Looper消息循环，开始处理创建Activity。ActivityThread利用ClassLoader去加载Activity、创建Activity实例，并回调Activity的onCreate()方法。这样便完成了Activity的启动。

Binder 是一种进程间通信机制
这些进程间的通信就依赖于 Binder IPC 机制。不仅如此，Android 系统对应用层提供的各种服务如：ActivityManagerService、PackageManagerService 等都是基于 Binder IPC 机制来实现的
Binder使用Client-Server通信方式，安全性好，简单高效，再加上其面向对象的设计思想，独特的接收缓存管理和线程池管理方式，成为Android进程间通信的中流砥柱。

volatile 意思是说这个变量，不必用本地副本优化，保证所有线程直接操作主存中的变量，是真正共享的。
volatile讲的是可见性，跟原子操作、线程安全无关。

总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁（共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程）。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。Java中synchronized和ReentrantLock等独占锁就是悲观锁思想的实现。
总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号机制和CAS算法实现。乐观锁适用于多读的应用类型，这样可以提高吞吐量，像数据库提供的类似于write_condition机制，其实都是提供的乐观锁。在Java中java.util.concurrent.atomic包下面的原子变量类就是使用了乐观锁的一种实现方式CAS实现的。
像乐观锁适用于写比较少的情况下（多读场景），即冲突真的很少发生的时候，这样可以省去了锁的开销，加大了系统的整个吞吐量。但如果是多写的情况，一般会经常产生冲突，这就会导致上层应用会不断的进行retry，这样反倒是降低了性能，所以一般多写的场景下用悲观锁就比较合适。
https://juejin.im/post/5b4977ae5188251b146b2fc8

 1 package com.paddx.test.concurrent;
 2 
 3 public class Singleton {
 4     public static volatile Singleton singleton;
 5 
 6     /**
 7      * 构造函数私有，禁止外部实例化
 8      */
 9     private Singleton() {};
10 
11     public static Singleton getInstance() {
12         if (singleton == null) {
13             synchronized (singleton) {
14                 if (singleton == null) {
15                     singleton = new Singleton();
16                 }
17             }
18         }
19         return singleton;
20     }
21 }

支持alpha通道的视频编码格式以及容器类型汇总
1、png图像序列，mov、mkv等格式
2、qtrle编码，mov格式
3、Apple ProRes 4444: rgba 4个通道，其容器格式尚未了解
4、vp6a编码，flv、f4v等格式
5、vp8、vp9编码，webm格式

lock 必须在 finally 块中释放。否则，如果受保护的代码将抛出异常，锁就有可能永远得不到释放！ synchronized锁方案代码块结束自动释放锁

首先很明显bitmap实现了Android中的Parcelable接口
不过通过实验的方法可以测出数据应该被限制在1MB之内（1024KB），笔者采用的是传递Bitmap的方法，发现当图片大小超过1024（准确地说是1020左右）的时候，程序就会出现闪退、停止运行等异常(不同的手机反应不同)，因此可以判断Intent的传输容量在1MB之内。

65536是什么样的数？2的16次方或者说64KB
单个dex的方法或者字段数量不能超过65536
如何避免64K问题？涉及到dex分包的知识，同时也是涉及到APK瘦身优化等问题。
可以看到类型索引（16 位），由此可以知道，无论是方法数还是字段数都不能超过65536，这也就是为什么在构建流程中出现65536的报错信息。

在任何视频编解码器中都没有alpha通道 – 它只是不是为了这样设计而且会大大增加文件的大小(每个帧中的每个像素都需要以某种方式存储的透明度数据)
您可以在视频上方放置一个透明视图,甚至可以使整个视频部分透明(在某些设备上)……但您不能使视频的一部分透明.这将是全有或全无.
  
View动画是一种渐进式动画，定义动画开始和结束的两帧，并指定动画变化的时间和方式。并通过平移、缩放、旋转和透明度四种效果结合成复杂的动画效果。而在开始和结束帧之间插入的渐变值依据的是插值器。
帧动画是通过不停的切换图片实现动画效果。
属性动画是不停的改变对象的属性来实现动画效果。4.4新出的过渡动画只是对属性动画的一层封装。
View动画的那四种效果有很明显的缺点，绘制出来的效果其实并没有真正改变View的属性，即left、top、right和bottom的值，只是系统临时绘制的结果。这样View的点击位置并没有发生变化。针对这个问题，从Android3.0开始属性动画应运而生。
属性动画本质是通过改变新增的属性（如平移translationX/Y、缩放scaleX/Y、旋转rotationX/Y等）并刷新屏幕来实现动画效果，并且实现点击位置的实时改变。但是属性动画仍然不会修改原始的上下左右四个值。最后需要注意的是，属性动画不止用于View，还可以用于任何对象。

与图片本身大小748544B存在一个4倍关系，因为图片采用的ARGB-888色彩格式，每个像素点占用4个字节。
一张图片占用内存=图片长 * 图片宽 ／ （资源图片文件密度/手机屏幕密度）^2 * 每一象素占用字节数
drawable和mipmap文件夹存放图片的区别，首先图片放在drawable-xhdpi和mipmap-xhdpi下，两者占用的内存是一样的， 
Mipmaps早在Android2.2+就可以用了，但是直到4.3 google才强烈建议使用。把图片放到mipmaps可以提高系统渲染图片的速度，提高图片质量，减少GPU压力。其他并没有什么区别。

不要说前公司和前leader的坏话
对于为什么离开原公司，标准答案是目前公司不适合现有的自身发展，寻求更好的机会，（当然大部分都是因为钱 心知肚明就行，不用说出来）
展现自己积极乐观和乐于助人的一面
