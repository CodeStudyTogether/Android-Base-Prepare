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

如果Activity中包含自己管理的Fragment的引用，可以通过引用直接访问所有的Fragment的public方法 
如果Activity中未保存任何Fragment的引用，可以通过每个Fragment都有一个唯一的TAG或者ID使用getFragmentManager.findFragmentByTag()或者findFragmentById()获得任何Fragment实例，然后进行操作。 
在Fragment中可以通过getActivity得到当前绑定的Activity的实例，然后进行操作。
当屏幕旋转或者内存重启（Fragment以及容器activity被系统回收后再打开时重新初始化）会导致Fragment重叠问题，是因为activity本身重启的时候会恢复Fragment，然后创建Fragment的代码又会新建一个Fragment的原因。
解决方法：在onCreate方法中判断参数Bundle savedInstanceState，为空时初始化Fragment实例，然后在Fragment中通过onSaveInstanceState的方法恢复数据

进程保活
Service的运行线程（生命周期方法全部在主线程）
Service启动方式以及如何停止
ServiceConnection里面的回调方法运行在哪个线程？

黑色保活：不同的app进程，用广播相互唤醒（包括利用系统提供的广播进行唤醒）
白色保活：启动前台Service
灰色保活：利用系统的漏洞启动前台Service
https://www.jianshu.com/p/63aafe3c12af
START_STICKY
如果系统在onStartCommand返回后被销毁，系统将会重新创建服务并依次调用onCreate和onStartCommand
startService开启服务以后，与activity就没有关联，不受影响，独立运行。
bindService开启服务以后，与activity存在关联，退出activity时必须调用unbindService方法，否则会报ServiceConnection泄漏的错误。
同一个服务可以用两种方式一同开启，没有先后顺序的要求，MyService的onCreate只会执行一次。
关闭服务需要stopService和unbindService都被调用，也没有先后顺序的影响，MyService的onDestroy也只执行一次。但是如果只用一种方式关闭服务，不论是哪种关闭方式，onDestroy都不会被执行，服务也不会被关闭。这一点需要注意。
Service和Activity的连接可以用ServiceConnection来实现。你需要实现一个新的ServiceConnection，重写onServiceConnected和onServiceDisconnected方法，一旦连接建立，你就能得到Service实例的引用。
ServiceConnection的方法都是进程的主线程中调用的。

什么情况下使用 ViewStub、include、merge？
他们的原理是什么？

因为merge标签并不是View,所以在通过LayoutInflate.inflate()方法渲染的时候,第二个参数必须指定一个父容器,且第三个参数必须为true,也就是必须为merge下的视图指定一个父亲节点.
因为merge不是View,所以对merge标签设置的所有属性都是无效的.
注意如果include的layout用了merge,调用include的根布局也使用了merge标签,那么就失去布局的属性了
merge标签必须使用在根布局
ViewStub标签中的layout布局不能使用merge标签
https://blog.csdn.net/bboyfeiyu/article/details/45869393
如果本打算用FrameLayout作为界面的根布局时，要用<merge>标签作为根节点，因为View树的ContentView本身就是个FrameLayout

注册方式，优先级
广播类型，区别
广播的使用场景，原理

我们可以在代码中注册（动态注册），也可以AndroidManifest.xml配置文件中注册（静态注册）。
Normalbroadcasts：默认广播
orderedbroadcasts：有序广播
广播接收器注册一共有两种形式：静态注册和动态注册．
两者及其接收广播的区别：
（1）动态注册广播不是常驻型广播，也就是说广播跟随Activity的生命周期。注意在Activity结束前，移除广播接收器。
静态注册是常驻型，也就是说当应用程序关闭后，如果有信息广播来，程序也会被系统调用自动运行。
（2）当广播为有序广播时：优先级高的先接收（不分静态和动态）。同优先级的广播接收器，动态优先于静态
（3）同优先级的同类广播接收器，静态：先扫描的优先于后扫描的，动态：先注册的优先于后注册的。
（4）当广播为默认广播时：无视优先级，动态广播接收器优先于静态广播接收器。同优先级的同类广播接收器，静态：先扫描的优先于后扫描的，动态：先注册的优先于后册的。

AsyncTask是串行还是并行执行？
AsyncTask随着安卓版本的变迁

1. Params
在执行AsyncTask时需要传入的参数，可用于在后台任务中使用。
2. Progress
后台任务执行时，如果需要在界面上显示当前的进度，则使用这里指定的泛型作为进度单位。
3. Result
当任务执行完毕后，如果需要对结果进行返回，则使用这里指定的泛型作为返回值类型。
AsyncTask也是使用的异步消息处理机制，只是做了非常好的封装而已。
因此在3.0版本中AsyncTask的改动还是挺大的，在3.0之前的AsyncTask可以同时有5个任务在执行，而3.0之后的AsyncTask同时只能有1个任务在执行。为什么升级之后可以同时执行的任务数反而变少了呢？这是因为更新后的AsyncTask已变得更加灵活，如果不想使用默认的线程池，还可以自由地进行配置。
AsyncTask内部封装了Thread和Handler，可以让我们在后台进行计算并且把计算的结果及时更新到UI上，而这些正是Thread+Handler所做的事情，没错，AsyncTask的作用就是简化Thread+Handler，让我们能够通过更少的代码来完成一样的功能，这里，我要说明的是：AsyncTask只是简化Thread+Handler而不是替代，实际上它也替代不了。

onTouch和onTouchEvent区别，调用顺序
dispatchTouchEvent， onTouchEvent， onInterceptTouchEvent 方法顺序以及使用场景
滑动冲突，如何解决

onTouch是优先于onClick执行的
onTouch方法是有返回值的，这里我们返回的是false，如果我们尝试把onTouch方法里的返回值改成true,onClick方法不再执行了
首先你需要知道一点，只要你触摸到了任何一个控件，就一定会调用该控件的dispatchTouchEvent方法。
mOnTouchListener.onTouch(this, event)，其实也就是去回调控件注册touch事件时的onTouch方法。也就是说如果我们在onTouch方法里返回true，就会让这三个条件全部成立，从而整个方法直接返回true。如果我们在onTouch方法里返回false，就会再去执行onTouchEvent(event)方法。
这两个方法都是在View的dispatchTouchEvent中调用的，onTouch优先于onTouchEvent执行。如果在onTouch方法中通过返回true将事件消费掉，onTouchEvent将不会再执行。
MyLinearLayout的dispatchTouchEvent -> MyLinearLayout的onInterceptTouchEvent -> MyButton的dispatchTouchEvent ->Mybutton的onTouchEvent 
默认是不拦截的，即返回false；如果你需要拦截，只要return true就行了，这要该事件就不会往子View传递了，并且如果你在DOWN retrun true ，则DOWN,MOVE,UP子View都不会捕获事件；如果你在MOVE return true , 则子View在MOVE和UP都不会捕获事件。
原因很简单，当onInterceptTouchEvent(ev) return true的时候，会把mMotionTarget 置为null ; 
1、如果ViewGroup找到了能够处理该事件的View，则直接交给子View处理，自己的onTouchEvent不会被触发；
2、可以通过复写onInterceptTouchEvent(ev)方法，拦截子View的事件（即return true），把事件交给自己处理，则会执行自己对应的onTouchEvent方法
3、子View可以通过调用getParent().requestDisallowInterceptTouchEvent(true);  阻止ViewGroup对其MOVE或者UP事件进行拦截；
好了，那么实际应用中能解决哪些问题呢？
比如你需要写一个类似slidingmenu的左侧隐藏menu，主Activity上有个Button、ListView或者任何可以响应点击的View，你在当前View上死命的滑动，菜单栏也出不来；因为MOVE事件被子View处理了~ 你需要这么做：在ViewGroup的dispatchTouchEvent中判断用户是不是想显示菜单，如果是，则在onInterceptTouchEvent(ev)拦截子View的事件；自己进行处理，这样自己的onTouchEvent就可以顺利展现出菜单栏了~~
https://www.jianshu.com/p/d3758eef1f72
讲讲 Android 的事件分发机制？
基本会遵从 Activity => ViewGroup => View 的顺序进行事件分发，然后通过调用 onTouchEvent() 方法进行事件的处理。我们在项目中一般会对  MotionEvent.ACTION_DOWN，MotionEvent.ACTION_UP，MotionEvent.ACTION_MOVE，MotionEvent.ACTION_CANCEL 分情况进行操作。
有去查看源码中的事件拦截方法吗？或者说在进行事件分发的时候如何让正常的分发方式进行拦截？
我知道有个拦截事件的方法叫...叫，onInterceptEvent()？应该是，不过由于平时项目较多，确实没时间去关注太多源码。
厄，那你觉得在一个列表中，同时对父 View 和子 View 设置点击方法，优先响应哪个？为什么会这样？
肯定是优先响应子 View 的，至于为什么这样，平时知道这个结论，所以没去太深入研究，但我相信我简单看一下源码是肯定知道的。
dispatchTouchEvent()
onTouchEvent()
onInterceptTouchEvent()
1、Android 事件分发总是遵循 Activity => ViewGroup => View 的传递顺序；
2、onTouch() 执行总优先于 onClick()

简述 View 绘制流程
onMeasure， onlayout， ondraw方法中需要注意的点
如何进行自定义 View
view 重绘机制

LayoutInflater其实就是使用Android提供的pull解析方式来解析布局文件的。
在setContentView()方法中，Android会自动在布局文件的最外层再嵌套一个FrameLayout，所以layout_width和layout_height属性才会有效果。
onMeasure()、onLayout()和onDraw()
EXACTLY，AT_MOST和UNSPECIFIED
约束:AT_MOST(至多)
布局参数:wrap-content
约束:EXACTLY(完全)
布局参数:match_parent/具体宽高值
View中的onLayout()方法就是一个空方法
自绘控件
组合控件
继承控件

Android Window、Activity、DecorView以及ViewRoot

Activity并不负责视图控制，它只是控制生命周期和处理事件。真正控制视图的是Window。一个Activity包含了一个Window，Window才是真正代表一个窗口。Activity就像一个控制器，统筹视图的添加与显示，以及通过其他回调方法，来与Window、以及View进行交互。
Window是视图的承载器，内部持有一个 DecorView，而这个DecorView才是 view 的根布局。Window是一个抽象类，实际在Activity中持有的是其子类PhoneWindow。PhoneWindow中有个内部类DecorView，通过创建DecorView来加载Activity中设置的布局R.layout.activity_main。Window 通过WindowManager将DecorView加载其中，并将DecorView交给ViewRoot，进行视图绘制以及其他交互。
DecorView是FrameLayout的子类，它可以被认为是Android视图树的根节点视图。DecorView作为顶级View，一般情况下它内部包含一个竖直方向的LinearLayout，在这个LinearLayout里面有上下三个部分，上面是个ViewStub,延迟加载的视图（应该是设置ActionBar,根据Theme设置），中间的是标题栏(根据Theme设置，有的布局没有)，下面的是内容栏。
Activity就像个控制器，不负责视图部分。Window像个承载器，装着内部视图。DecorView就是个顶层视图，是所有View的最外层布局。ViewRoot像个连接器，负责沟通，通过硬件的感知来通知视图，进行用户之间的交互。

常见的 IPC 机制以及使用场景
为什么安卓要用 binder 进行跨进程传输
多进程带来的问题

Binder能干什么？Binder可以提供系统中任何程序都可以访问的全局服务。这个功能当然是任何系统都应该提供的，下面我们简单看一下Android的Binder的框架
Android Binder框架分为服务器接口、Binder驱动、以及客户端接口；简单想一下，需要提供一个全局服务，那么全局服务那端即是服务器接口，任何程序即客户端接口，它们之间通过一个Binder驱动访问。
服务器端接口：实际上是Binder类的对象，该对象一旦创建，内部则会启动一个隐藏线程，会接收Binder驱动发送的消息，收到消息后，会执行Binder对象中的onTransact()函数，并按照该函数的参数执行不同的服务器端代码。
Binder驱动：该对象也为Binder类的实例，客户端通过该对象访问远程服务。
客户端接口：获得Binder驱动，调用其transact()发送消息至服务器
这些进程间的通信就依赖于 Binder IPC 机制。不仅如此，Android 系统对应用层提供的各种服务如：ActivityManagerService、PackageManagerService 等都是基于 Binder IPC 机制来实现的。Binder 机制在 Android 中的位置非常重要
Android 系统是基于 Linux 内核的，Linux 已经提供了管道、消息队列、共享内存和 Socket 等 IPC 机制。那为什么 Android 还要提供 Binder 来实现 IPC 呢？主要是基于性能、稳定性和安全性几方面的原因。
Binder 基于 C/S 架构
我们都知道，系统为 APP 每个进程分配的内存是有限的，如果想获取更多内存分配，可以使用多进程，将一些看不见的服务、比较独立而又相当占用内存的功能运行在另外一个进程当中。\
AndroidManifest.xml 清单文件中注册 Activity、Service 等四大组件时，指定 android:process 属性即可开启多进程
以小写字母开头的，属于全局进程，其他应用可以通过 ShareUID 进行数据共享；
Application 多次创建
我们都会在工程中自定义一个 Application 类，做一些全局性的初始化工作，因为我们要区分出来，让其在主进程进行初始化
静态成员和单例模式失效
进程间通信
既然内存不能共享，是不是可以找个共同地方，是的，可以把要共享的数据保存 SD 卡，实现共享。首先将 SingletonUtil 实现 Serializable 序列化，将对象存入 SD 卡，然后需要用的地方，反序列化，从 SD 卡取出对象
AIDL，Android 接口定义语言，定义客户端与服务端进程间通信，服务端有处理多线程时，才有必要使用 AIDL，不然可以使用 Messenger
IPC 即 Inter-Process Communication (进程间通信)。
Android 基于 Linux，而 Linux 出于安全考虑，不同进程间不能之间操作对方的数据，这叫做“进程隔离”。
只有允许不同应用的客户端用 IPC 方式调用远程方法，并且想要在服务中处理多线程时，才有必要使用 AIDL
如果需要调用远程方法，但不需要处理并发 IPC，就应该通过实现一个 Binder 创建接口
如果您想执行 IPC，但只是传递数据，不涉及方法调用，也不需要高并发，就使用 Messenger 来实现接口
如果需要处理一对多的进程间数据共享（主要是数据的 CRUD），就使用 ContentProvider
如果要实现一对多的并发实时通信，就使用 Socket

Android 高级必备 ：AMS,WMS,PMS

Android的PackageManagerService，后面简称PMS。PMS用来管理所有的package信息，包括安装、卸载、更新以及解析AndroidManifest.xml以组织相应的数据结构，这些数据结构将会被PMS、ActivityMangerService等等service和application使用到。
Android的framework层主要是由WMS、AMS还有View所构成，这三个模块穿插交互在整个framework中，掌握了它们之间的关系和每一个逻辑步骤，你对framework的了解至少有百分之五十
WindowManagerService
WindowManagerService服务的实现是相当复杂的，毕竟它要管理的整个系统所有窗口的UI，而在任何一个系统中，窗口管理子系统都是极其复杂的。
ActivityManagerService
AMS的工作流程，其实就是Activity的启动和调度的过程，所有的启动方式，最终都是通过Binder机制的Client端，调用Server端的AMS的startActivityXXX()系列方法。所以可见，工作流程又包括Client端和Server端两个。

为什么会发生 ANR？
如何定位 ANR？
如何避免 ANR？

Application Not Responding
KeyDispatchTimeout –按键或触摸事件在特定时间内无响应；
BroadcastTimeout –BroadcastReceiver在特定时间内无法处理完成；
ServiceTimeout –Service在特定的时间内无法处理完成；
主线程中存在耗时的计算
应用在5秒内未响应用户的输入事件（如按键或者触摸）
BroadcastReceiver未在10秒内完成相关的处理
Android系统中，ActivityManagerService(简称AMS)和WindowManagerService(简称WMS)会检测App的响应时间，如果App在特定时间无法相应屏幕触摸或键盘输入时间，或者特定事件没有处理完毕，就会出现ANR。

注意：内存泄漏和内存溢出是 2 个概念
什么情况下会内存泄漏？
如何防止内存泄漏？

内存溢出是指当对象的内存占用已经超出分配内存的空间大小，这时未经处理的异常就会抛出。比如常见的内存溢出情况有：bitmap过大；引用没释放；资源对象没关闭 
有些对象只有有限的生命周期。当它们的任务完成之后，它们将被垃圾回收。如果在对象的生命周期本该结束的时候，这个对象还被一系列的引用，这就会导致内存泄漏。随着泄漏的累积，app将消耗完内存。 
1.资源对象没关闭
如Cursor，File等资源。他们会在finalize中关闭，但这样效率太低。容易造成内存泄漏 
SQLiteCurost,当数据量大的时候容易泄漏
2.使用Adapter时，没有使用系统缓存的converView 
3.没有即时调用recycle()释放不再使用的bitmap 
4.使用application的context来替代activity相关的context
不要让生命周期长于Activity的对象持有到Activity的引用
5.广播注册没取消造成内存泄露 
6.Handler应该申明为静态对象， 并在其内部类中保存一个对外部类的弱引用。
我们可以考虑使用ArrayMap/SparseArray而不是HashMap等传统数据结构
请避免在Android里面使用到枚举。
减小Bitmap对象的内存占用
避免在onDraw方法里面执行对象的创建
StringBuilder的使用
资源文件需要选择合适的文件夹进行存放
我们知道hdpi/xhdpi/xxhdpi等等不同dpi的文件夹下的图片在不同的设备上会经过scale的处理。例如我们只在hdpi的目录下放置了一张100100的图片，那么根据换算关系，xxhdpi的手机去引用那张图片就会被拉伸到200200。需要注意到在这种情况下，内存占用是会显著提高的。对于不希望被拉伸的图片，需要放到assets或者nodpi的目录下。
优化布局层次，减少内存消耗
http://hukai.me/android-performance-oom/
静态内部类不持有外部类的引用，打破了链式引用。

屏幕适配相关名词解析
现在流行的屏幕适配方式

屏幕尺寸指屏幕的对角线的长度，单位是英寸，1英寸=2.54厘米
比如常见的屏幕尺寸有2.4、2.8、3.5、3.7、4.2、5.0、5.5、6.0等
https://zhuanlan.zhihu.com/p/37199709
面假设设计图宽度是360dp，以宽维度来适配。
那么适配后的 density = 设备真实宽(单位px) / 360，接下来只需要把我们计算好的 density 在系统中修改下即可，代码实现如下：

LruCache使用极其原理
关于Android的三级缓存，其中主要的就是内存缓存和硬盘缓存。这两种缓存机制的实现都应用到了LruCache算法，
因此LruCache的核心思想很好理解，就是要维护一个缓存对象列表，其中对象列表的排列方式是按照访问顺序实现的，即一直没访问的对象，将放在队尾，即将被淘汰。而最近访问的对象将放在队头，最后被淘汰。
LRU(Least Recently Used)缓存算法便应运而生，LRU是近期最少使用的算法，它的核心思想是当缓存满时，会优先淘汰那些近期最少使用的缓存对象。采用LRU算法的缓存有两种：LrhCache和DisLruCache，分别用于实现内存缓存和硬盘缓存，其核心思想都是LRU缓存算法。
而LinkedHashMap是由数组+双向链表的数据结构来实现的。其中双向链表的结构可以实现访问顺序和插入顺序，使得LinkedHashMap中的<key,value>对按照一定顺序排列起来。
Glide也使用了LruCache

如何进行 内存 cpu 耗电 的定位以及优化
性能优化经常使用的方法
如何避免 UI 卡顿

代码优化，在ide中显示是灰色的可省略的
布局优化
如果父控件有颜色，也是自己需要的颜色，那么就不必在子控件加背景颜色
如果每个自控件的颜色不太一样，而且可以完全覆盖父控件，那么就不需要再父控件上加背景颜色
尽量减少不必要的嵌套
能用LinearLayout和FrameLayout，就不要用RelativeLayout，因为RelativeLayout控件相对比较复杂，测绘也想要耗时。
include、merge和ViewStub
onDraw中不要创建新的局部对象
onDraw方法中不要做耗时的任务

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
