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
