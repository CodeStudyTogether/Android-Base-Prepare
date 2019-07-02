getdefault采用单例模式和建造者模式构建EventBus的实例,在构建实例的时候初始化了线程池

post的作用就是将事件添加到PostingThreadState的事件队列中去，然后遍历这个List,调用postSingleEvent,
既然要发送单个事件，就要知道订阅这个事件的所有方法，通过subscriptionsByEventType拿到Subscriptions的COW,接着遍历这个线程安全的类，拿到SUbscription，然后调用postToSubscrition,在这个方法里进行了线程调度，
最终都会调用invokeSubscriber，在这里通过反射调用方法

HttpDNS,IP直连
Http 2.0多路复用
HTTP持久连接（HTTP persistent connection，也称作HTTP keep-alive或HTTP connection reuse）是使用同一个TCP连接来发送和接收多个HTTP请求/应答，而不是为每一个新的请求/应答打开新的连接的方法。
https://www.nihaoshijie.com.cn/index.php/archives/698/
服务器要配置
HTTP2的请求的TCP的connection一旦建立，后续请求以stream的方式发送。
2）每个stream的基本组成单位是frame（二进制帧），每种frame又分为很多种类型例如HEADERS Frame（头部帧），DATA Frame（内容帧）等等。

3）请求头HEADERS Frame组成了resquest，返回头HEADERS Frame和DATA Frame组成了response，request和response组成了一个stream。

HTTP2采用多路复用是指，在同一个域名下，开启一个TCP的connection，每个请求以stream的方式传输，每个stream有唯一标识，connection一旦建立，后续的请求都可以复用这个connection并且可以同时发送，server端可以根据stream的唯一标识来相应对应的请求。

oncreate onstart onresume onpause onstop ondestroy

onattach oncreate oncreateview onActivityCreated onStart onResume onpuase onstop onDestroyView onDestroy onDetach

activity从不可见状态到可见状态，onRestart才会被调用

1.前台进程 (Foreground process)
2.可见进程 (Visible process)
3.服务进程 (Service process)
4.后台进程 (Background process)
5.空进程 (Empty process)
  
配好START_STICKY后，通过android studio 释放进程的工具测试下，可以发现:remote进程被kill之后马上重启了
https://juejin.im/post/5baedde6f265da0a8d369eb2
使用”1像素“的Activity覆盖在getWindow()的view上、循环播放无声音频
推送互相唤醒复活：极光、友盟、以及各大厂商的推送
https://tocreate.app/2019/02/20/AOSProcessPrio/index.html

JVM屏蔽了与具体操作系统平台相关的信息，使得Java程序只需生成在Java虚拟机上运行的目标代码（字节码），就可以在多种平台上不加修改地运行。

java命令首先启动虚拟机进程，虚拟机进程成功启动后，读取参数“HelloWorld”，把他作为初始类加载到内存，对这个类进行初始化和动态链接（关于类的初始化和动态链接会在后面的博客中介绍），然后从这个类的main方法开始执行。

引用计数法

程序计数器、 虚拟机栈、 本地方法栈3个区域随线程而生，随线程而灭

最简单的方法就是通过目前是否有引用指向这个对象，如果没有就说明这个对象不会再被使用了，如果有就说明这个对象可能还会继续被使用，这种通过引用是否存在的方法就叫做引用计数法

这个算法的基本思路就是通过一系列的称为“GC Roots”的对象作为起始点，从这些节点开始向下搜索，搜索所走过的路径称为引用链（Reference Chain），当一个对象到GC Roots没有任何引用链相连（用图论的话来说，就是从GC Roots到这个对象不可达）时，则证明此对象是不可用的。

新生代，老年代和永久代

所有新new出来的对象都会最先出现在新生代中，当新生代这部分内存满了之后，就会发起一次垃圾收集事件，这种发生在新生代的垃圾收集称为Minor collections。这种收集通常比较快，因为新生代的大部分对象都是需要回收的，那些暂时无法回收的就会被移动到老年代。

老年代用来存储那些存活时间较长的对象。一般来说，我们会给新生代的对象限定一个存活的时间，当达到这个时间还没有被收集的时候就会被移动到老年代中。老年代区域的垃圾收集叫做major garbage collection

1) Collection
一组"对立"的元素，通常这些元素都服从某种规则
 　　1.1) List必须保持元素特定的顺序
 　　1.2) Set不能有重复元素
 　　1.3) Queue保持一个队列(先进先出)的顺序
2) Map
一组成对的"键值对"对象

ArrayList在内存不够时默认是扩展50% + 1个，Vector是默认扩展1倍。
Vector提供indexOf(obj, start)接口，ArrayList没有。
Vector属于线程安全级别的，但是大多数情况下不使用Vector，因为线程安全需要更大的系统开销。

Map的key不允
许重复，即同一个Map对象的任何两个key通过equals方法比较结果总是返回false。

HashMap和Hashtable的效率大致相同，因为它们的实现机制几乎完全一样。但HashMap通常比Hashtable要快一点，因为Hashtable需要额外的线程同步控制
TreeMap通常比HashMap、Hashtable要慢(尤其是在插入、删除key-value对时更慢)，因为TreeMap底层采用红黑树来管理key-value对
使用TreeMap的一个好处就是： TreeMap中的key-value对总是处于有序状态，无须专门进行排序操作

设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性。
六大原则
单一职责原则
开闭原则
里氏替换原则
依赖倒置原则
接口隔离原则
迪米特原则

如果某个类，创建时需要消耗很多资源，即new出这个类的代价很大；或者是这个类占用很多内存，如果创建太多这个类实例会导致内存占用太多。上述情况下就应该使用单例模式

建造者模式
各类自定义Dialog

工厂模式
建立一个工厂（一个函数或一个类方法）来制造新的对象。
在getSystemService方法中就是用到了简单工厂模式，根据传入的参数决定创建哪个对象，由于这些对象以单例模式提前创建好了，所以此处不用new了，直接把单例返回就好。

策略模式
有一系列的算法，将每个算法封装起来（每个算法可以封装到不同的类中），各个算法之间可以替换，策略模式让算法独立于使用它的客户而独立变化。
https://juejin.im/entry/5b4b35fe6fb9a04fb401546d

应用层 传输层 网络层 链路层

TCP/IP 中有两个具有代表性的传输层协议，分别是 TCP 和 UDP。

TCP 是面向连接的、可靠的流协议。

UDP 是不具有可靠性的数据报协议。

TCP 和 UDP 的优缺点无法简单地、绝对地去做比较：TCP 用于在传输层有必要实现可靠传输的情况；而在一方面，UDP 主要用于那些对高速传输和实时性有较高要求的通信或广播通信。TCP 和 UDP 应该根据应用的目的按需使用。

传输途中出现丢包，UDP 也不负责重发。

UDP 常用于一下几个方面：1.包总量较少的通信（DNS、SNMP等）；2.视频、音频等多媒体通信（即时通信）；3.限定于 LAN 等特定网络中的应用通信；4.广播通信（广播、多播）。

所谓三次握手是指建立一个 TCP 连接时需要客户端和服务器端总共发送三个包以确认连接的建立。在socket编程中，这一过程由客户端执行connect来触发。

RTMP采用TCP协议作为其在传输层的协议

第一次握手：客户端将标志位SYN置为1，随机产生一个值seq=J，并将该数据包发送给服务器端，客户端进入SYN_SENT状态，等待服务器端确认。
第二次握手：服务器端收到数据包后由标志位SYN=1知道客户端请求建立连接，服务器端将标志位SYN和ACK都置为1，ack=J+1，随机产生一个值seq=K，并将该数据包发送给客户端以确认连接请求，服务器端进入SYN_RCVD状态。
第三次握手：客户端收到确认后，检查ack是否为J+1，ACK是否为1，如果正确则将标志位ACK置为1，ack=K+1，并将该数据包发送给服务器端，服务器端检查ack是否为K+1，ACK是否为1，如果正确则连接建立成功，客户端和服务器端进入ESTABLISHED状态，完成三次握手，随后客户端与服务器端之间可以开始传输数据了。

四次挥手即终止TCP连接，就是指断开一个TCP连接时，需要客户端和服务端总共发送4个包以确认连接的断开。在socket编程中，这一过程由客户端或服务端任一方执行close来触发。
由于TCP连接是全双工的，因此，每个方向都必须要单独进行关闭，这一原则是当一方完成数据发送任务后，发送一个FIN来终止这一方向的连接，收到一个FIN只是意味着这一方向上没有数据流动了，即不会再收到数据了，但是在这个TCP连接上仍然能够发送数据，直到这一方向也发送了FIN。首先进行关闭的一方将执行主动关闭，而另一方则执行被动关闭。

中断连接端可以是客户端，也可以是服务器端。
第一次挥手：客户端发送一个FIN=M，用来关闭客户端到服务器端的数据传送，客户端进入FIN_WAIT_1状态。意思是说"我客户端没有数据要发给你了"，但是如果你服务器端还有数据没有发送完成，则不必急着关闭连接，可以继续发送数据。
第二次挥手：服务器端收到FIN后，先发送ack=M+1，告诉客户端，你的请求我收到了，但是我还没准备好，请继续你等我的消息。这个时候客户端就进入FIN_WAIT_2 状态，继续等待服务器端的FIN报文。
第三次挥手：当服务器端确定数据已发送完成，则向客户端发送FIN=N报文，告诉客户端，好了，我这边数据发完了，准备好关闭连接了。服务器端进入LAST_ACK状态。
第四次挥手：客户端收到FIN=N报文后，就知道可以关闭连接了，但是他还是不相信网络，怕服务器端不知道要关闭，所以发送ack=N+1后进入TIME_WAIT状态，如果Server端没有收到ACK则可以重传。服务器端收到ACK后，就知道可以断开连接了。客户端等待了2MSL后依然没有收到回复，则证明服务器端已正常关闭，那好，我客户端也可以关闭连接了。最终完成了四次握手。

HTTPS：是以安全为目标的HTTP通道，简单讲是HTTP的安全版，即HTTP下加入SSL层，HTTPS的安全基础是SSL，因此加密的详细内容就需要SSL。

https协议需要到ca申请证书，一般免费证书较少，因而需要一定费用。

http和https使用的是完全不同的连接方式，用的端口也不一样，前者是80，后者是443。

区别就是自己颁发的证书需要客户端验证通过，才可以继续访问

这个证书其实就是公钥，只是包含了很多信息，如证书的颁发机构，过期时间等等。

快速排序的基本思想：
通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序。

https://www.jianshu.com/p/8c915179fd02

与Windows系统一样，Android也是消息驱动型的系统。

接收消息的“消息队列” ——【MessageQueue】
阻塞式地从消息队列中接收消息并进行处理的“线程” ——【Thread+Looper】
可发送的“消息的格式” ——【Message】
“消息发送函数”——【Handler的post和sendMessage】

一个Looper类似一个消息泵。它本身是一个死循环，不断地从MessageQueue中提取Message或者Runnable。
https://hit-alibaba.github.io/interview/Android/basic/Android-handler-thread-looper.html
Android为了方便对Thread和Handler进行封装，也就是HandlerThread。
HandlerThread继承自Thread，说白了就是Thread加上一个一个Looper。
AsyncTask是谷歌对Thread和Handler的进一步封装，完全隐藏起了这两个概念，而用doInBackground(Params... params)取而代之。

在使用 git 进行版本管理的项目中，当完成一个特性的开发并将其合并到 master 分支时，我们有两种方式：git merge 和 git rebase。通常，我们对 git merge 使用的较多，而对于 git rebase 使用的较少，其实 git rebase 也是极其强大的一种方法。

和 git merge 不同的是，你需要在 feature 分支上进行 git rebase master 的操作，意味着让当前分支 feature 相对于 分支 master 进行变基

git pull 是　git fetch + git merge FETCH_HEAD 的缩写。所以，默认情况下，git pull就是先fetch，然后执行merge 操作，如果加–rebase 参数，就是使用git rebase 代替git merge。

https://gist.github.com/68681395/9d2789f38fb62e60b9fa0d0c4a7d4511

而rebase 操作的话，会中断rebase,同时会提示去解决冲突。解决冲突后,将修改add后执行git rebase –continue继续操作

修改冲突部分
git add
git rebase --continue
（如果第三步无效可以执行  git rebase --skip）

https://www.cnblogs.com/xueweihan/p/5743327.html

在任务众多的情况下，系统要为每一个任务创建一个线程，而任务执行完毕后会销毁每一个线程，所以会造成线程频繁地创建与销毁。

多个线程频繁地创建会占用大量的资源，并且在资源竞争的时候就容易出现问题，同时这么多的线程缺乏一个统一的管理，容易造成界面的卡顿。

多个线程频繁地销毁，会频繁地调用GC机制，这会使性能降低，又非常耗时。

对多个线程进行统一地管理，避免资源竞争中出现的问题。

线程进行复用，线程在执行完任务后不会立刻销毁，而会等待另外的任务，这样就不会频繁地创建、销毁线程和调用GC。

JAVA提供了一套完整的ExecutorService线程池创建的api，可创建多种功能不一的线程池，使用起来很方便。

FixedThreadPool 
CachedThreadPool 
SingleThreadPool
核心线程 ：固定线程数 可闲置 不会被销毁 ThreadPoolExecutor的allowCoreThreadTimeOut属性设置为true时，keepAliveTime同样会作用于核心线程
非核心线程数：非核心线程闲置时的超时时长，超过这个时长，非核心线程就会被回收

Xposed框架的技术核心建立在Jvm原生的JNI机制之上
Xposed框架核心思想在于将java层普通函数注册成本地JNI方法，以此来变相实现hook机制
•创建新应用，获取包名等信息。
•调用XC_LoadPackage.callAll，依次执行各hook模块的代码。
•如果有包名匹配的hook模块，则注册模块中要hook的方法为本地方法。
•当该方被调用的时候，转移到本地xposedCallHandler。
•xposedCallHandler回调上层handlerHookedMethod(因为加载的hook模块代码，一些变量都存储在java层)。
•handlerHookedMethod执行加载的各hook模块。

理论上我们的插件APP可以hook到系统任意一个Java进程zygote、
在Android系统中，应用程序进程以及系统服务进程SystemServer都是由Zygote进程孵化出来的，而Zygote进程是由Init进程启动的，Zygote进程在启动时会创建一个Dalvik虚拟机实例，每当它孵化一个新的应用程序进程时，都会将这个Dalvik虚拟机实例复制到新的应用程序进程里面去，从而使得每一个应用程序进程都有一个独立的Dalvik虚拟机实例，这也是Xposed选择替换app_process的原因。

OkHttp 现在统治了Android的网络请求领域，最常用的框架是：Retrofit+okhttp。
因为在项目中所有的网络请求基本都是异步的，同步很少用到
可以看出都实现了Interceptor接口，这是okhttp最核心的部分，采用责任链的模式来使每个功能分开，每个Interceptor自行完成自己的任务，并且将不属于自己的任务交给下一个，简化了各自的责任和逻辑。
责任链这样实现的好处了，当责任链执行完毕，如果拦截器想要拿到最终的数据做其他的逻辑处理等
OkhttpClient 实现了Call.Fctory,负责为Request 创建 Call；
RealCall 为Call的具体实现，其enqueue() 异步请求接口通过Dispatcher()调度器利用ExcutorService实现，而最终进行网络请求时和同步的execute()接口一致，都是通过 getResponseWithInterceptorChain() 函数实现
getResponseWithInterceptorChain() 中利用 Interceptor 链条，责任链模式 分层实现缓存、透明压缩、网络 IO 等功能；最终将响应数据返回给用户。

过@Subscribe注解,来确定运行的线程threadMode,是否接受粘性事件sticky以及事件优先级priority,而且方法名不在需要onEvent开头,所以又简洁灵活了不少.
这里就是设计模式里我们常用的单例模式了,目的是为了保证getDefault()得到的都是同一个实例。如果不存在实例,就调用了EventBus的构造方法:
在3.0版本中,EventBus提供了一个EventBusAnnotationProcessor注解处理器来在编译期通过读取@Subscribe()注解并解析,处理其中所包含的信息,然后生成java类来保存所有订阅者关于订阅的信息,
观察者模式观察者模式是对象的行为模式，又叫发布-订阅(Publish/Subscribe)模式
Sticky Events（粘性事件）
https://juejin.im/post/5a3b8fe15188252103346d1b

Tinker做了对应的DexDiff、ResDiff、BsDiff来产出一个patch.apk,里面具体内容也是由lib、res和dex文件组成，assets中还有对应的dex、res和so信息
然后Tinker通过找到基准包data/app/packagename/base.apk通过DexPatch合成新的dex，并且合成一个tinker_classN.apk(其实就是包含了所有合成dex的zip包)接着在运行时通过反射把这个合成dex文件插入到PathClassLoader中的dexElements数组的前面，保证类加载时优先加载补丁dex中的class。
Android里面加载类主要用到了两个类加载器，一个是PathClassLoader，另一个是DexClassLoader，应用程序中的类一般都是通过PathClassLoader来加载类的，不信你在Activity里面调用getClassLoader()方法，然后看得到的ClassLoader对象的类型是不是PathClassLoader类型，答案是肯定的。我们来看下PathClassLoader类的源码
然后apk下次启动的时候就可以把修复好的dex插入dexElements数组的前面，这样应用程序通过PathClassLoader去加载类就会优先找到修复好的dex里面的Test类，这样bug就被修复了。

Retrofit 是一个 RESTful 的 HTTP 网络请求框架的封装。
原因：网络请求的工作本质上是 OkHttp 完成，而 Retrofit 仅负责 网络请求接口的封装
只是Retrofit通过使用大量的设计模式进行功能模块的解耦，使得上面的过程进行得更加简单 & 流畅
Retrofit实例是使用建造者模式通过Builder类进行创建的
Retrofit是通过外观模式 & 代理模式 使用create（）方法创建网络请求接口的实例
Retrofit对象的外观（门店） =  retrofit.create()
静态代理：代理类在程序运行前已经存在的代理方式
动态代理：代理类在程序运行前不存在、运行时由程序动态生成的代理方式
用动态代理 的方式，动态将网络请求接口的注解 解析 成HTTP请求

就目前开发角度而言，retrofit可以说是最火的网络框架。其原因我认为有两点，第一：可以和okhttp结合。第二：可以和rxjava结合。也就是说Retrofit 除了提供了传统的 Callback 形式的 API，还有 RxJava 版本的 Observable 形式 API。

简单说就是先用流来读写json字符串，
而后就是用TyperAdapter作为适配器，完成json字符串和java对象的转换。
通过自定义TyperAdapter可以解决一切转换异常。

LruCache
最近最少使用的算法
LinkedHashMap
当缓存不足时优先删除最近最少使用的元素

但是这种方式多多少少会有性能的损耗。那么有没有一种方法能解决这种性能的损耗呢？ 没错，答案肯定是有的，那就是Butterknife用的APT(Annotation Processing Tool)编译时解析技术。
动态生成绑定事件或者控件的java代码，然后在运行的时候，直接调用bind方法完成绑定。
编译的时候生成代码

原来这个json文件的内容不是手写的，而是软件生成的，设计师可以使用Adobe的 After Effects(简称 AE)工具制作这个动画，在AE中安装一个叫做Bodymovin的插件，使用这个插件可以将动画效果生成一个json文件，而这个json文件通过LottieAnimationView解析并最终生成绚丽的动画效果展示在我们面前。
LottieAnimationView 使用 LottieDrawable 来渲染动画，动画的实际执行者是 LottieDrawable。
根据里面的数据建立合适的Drawable绘制到View上面。

LeakCanary的原理非常简单。正常情况下一个Activity在执行Destroy之后就要销毁
LeakCanary做的就是在一个Activity Destroy之后将它放在一个WeakReference中，然后将这个WeakReference关联到一个ReferenceQueue，查看ReferenceQueue是否存在Activity的引用，如果不在这个队列中，执行一些GC清洗操作，再次查看。如果不存在则证明该Activity泄漏了，之后Dump出heap信息，并用haha这个开源库去分析泄漏路径。
它向 application 里注册了一个 ActivitylifecycleCallbacks 的回调函数，可以用来监听 Application 整个生命周期所有 Activity
原来它只监听了所有 Activity 的 onActivityDestroyed 事件，当 Activity 被 Destory 时，调用 ActivityRefWatcher.this.onActivityDestroyed(activity); 函数。
每个activity申明弱引用的时候都会有个ID, ID保存在retainedKeys集合中, 首先遍历移除被gc回收的对象, 如果这个时候retainedKeys集合为空, 则表示不存在内存泄漏的情况. 否则手动执行GC, 再次判断移除, 这个时候如果retainedKeys内仍存在ID, 则说明有内存泄漏的情况存在.
通过application注册ActivityLifecycleCallbacks的回调, 在每个activity销毁的时候, 将activity的弱引用包装绑定在ReferenceQueue上, 当GC的时候, 可以通过queue移除已被回收的activity对象key, 获得始终未被回收的对象, 判断为是内存泄漏, 根据haha库解析heap dumps,获取引用路径最终在DisplayLeakActivity上显示我们熟悉的内存泄漏的列表内容.
  
通过对 Volley 源码的分析，可以发现， Volley 框架的拆装性很强，框架默认使用的是 HttpUrlConnection 和 HttpClient 来实现网络请求
CacheDispatcher：一个线程，用于调度处理走缓存的请求。启动后会不断从缓存请求队列中取请求处理，队列为空则等待，请求处理结束则将结果传递给ResponseDelivery去执行后续处理。当结果未缓存过、缓存失效或缓存需要刷新的情况下，该请求都需要重新进入NetworkDispatcher去调度处理。
NetworkDispatcher：一个线程，用于调度处理走网络的请求。启动后会不断从网络请求队列中取请求处理，队列为空则等待，请求处理结束则将结果传递给ResponseDelivery去执行后续处理，并判断结果是否要进行缓存。
start 方法中，开启一个缓存调度线程CacheDispatcher和 n 个网络调度线程NetworkDispatcher

② 内存缓存：缓存搜索，如果能找到Key值对应的Bitmap，则返回数据。否则执行第三步。
③ 硬盘存储：使用唯一Key值对应的文件名，检索SDCard上的文件。
内存缓存其实就是利用Map接口的对象在内存中进行缓存，可能有不同的存储机制。磁盘缓存其实就是将文件写入磁盘。
UIL加载图片的一般流程是先判断内存中是否有对应的Bitmap，再判断磁盘（disk）中是否有，如果没有就从网络中加载。
多线程下载图片，图片可以来源于网络，文件系统，项目文件夹assets中以及drawable中等
较好的控制图片的加载过程，例如暂停图片加载，重新开始加载图片，一般使用在ListView,GridView中，滑动过程中暂停加载图片，停止滑动的时候去加载图片
