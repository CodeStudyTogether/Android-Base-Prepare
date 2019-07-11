在构造器中利用建造者模式来构建 OkHttpClient 的对象。

在 getResponseWithInterceptorChain() 方法中有一堆的拦截器！！！

拦截器是 OkHttp 的精髓。

最后在聚合了这些拦截器后，利用 RealInterceptorChain 来链式调用这些拦截器，利用的就是责任链模式。

多线程是为了使得多个线程并行的工作以完成多项任务，以提高系统的效率。线程是在同一时间需要完成多项任务的时候被实现的。

最佳方案：使用线程安全的对象是实现线程安全的。 java.util.concurrent包下的类。

比如 闭锁 CountDownLatch、ConcurrentHashMap、HashTable 、ThreadPoolExecutor 

Android中的广播使用了设计模式中的观察者模式：基于消息的发布 / 订阅事件模型

动态广播最好在Activity 的 onResume()注册、onPause()注销。

很多时候我们仅仅只是知道HashMap他是允许键值对都是Null，并且是非线程安全的，如果在多线程的环境下使用

我们都知道HashMap是数组+链表组成的，bucket数组是HashMap的主体，而链表是为了解决哈希冲突而存在的，但是很多人不知道其实HashMap是包含树结构的，但是得有一点 注意事项，什么时候会出现红黑树这种红树结构的呢？我们就得看源码了，源码解释说默认链表长度大于8的时候会转换为树。

之前看1.7的源码的时候，是没有这个红黑树的，而是在1.8 之后做了相应的优化。

我认为 IT 行业可以分为 互联网 和 传统软件 两个行业，虽然在外行人看来都是搞 IT 的，但业内人士都知道，这其中的差别可谓是天差地远。
在传统软件行业，对技术的要求其实很低，高性能基本不会涉及到，因为用户数量就那么点，TPS 都不用考虑。高可用大多数情况也不会涉及到，服务器停个 2 小时没啥关系，即便是有些场景，要求高可用，一般也就是双机热备就完事了。可扩展性，理论上是有要求的，实际上还不是前人挖坑后人填？这些公司面对的最大的技术问题恐怕还是业务的复杂性以及客户的认知，很多客户认为软件就是啥都能实现的，所以需求他们想怎么提就怎么提。
Code Review？大多数公司是没有的，老板也不关心代码的质量如何，验收能过就行。开发人员每天焦头烂额的都是满足客户各种无理的需求，以及无休止的需求变动。从上到下，谁也不会去关心你的代码是怎么写的。就算你变量定义成 fuck1、fuck2... 也无所谓。

6月18日下午，Facebook发布加密货币白皮书，正式推出加密货币项目Libra。
白皮书中讲到Libra的使命是建立一套简单的、无国界的货币和为数十亿人服务的金融基础设施。这一点与比特币类似，但是不同的是Libra看到了比特币等加密货币虽然名为加密货币但更像是一种投资资产，已经失去了货币的属性，所以Libra区块链中并没有挖矿的概念，而是采用储备。Libra的目标是成为一种稳定的数字加密货币，将全部使用真实资产储备（称为“Libra 储备”）作为担保，并由买卖Libra并存在竞争关系的交易平台网络提供支持。

androidx 库很多版本已经推出了正式稳定版
这个的前提是你得更新你的 Android Studio 版本和 gradle 的版本。请注意，这两个的版本都要更新。Android Studio 最低要求是 3.2 的版本，现在正式稳定版本是 3.4.1
，gradle 支持 androidx 的最低版本是 3.2.1 ，请注意，一定要升级对应的 gradle 版本。

Window：Window是一个窗口，它是View的容器。Android中的视图以View树的形式组织在一起，而View树必须依附在Window上才能工作。一个Window对应着一个View树。启动Activity时会创建一个Window，显示Dialog时也会创建一Window。因此Activity内部可以有多个Window。由于View的测量、布局、绘制只是在View树内进行的，因此一个Window内View的改动不会影响到另一个Window。Window是一个抽象类，它只有一个实现类PhoneWindow。

DecorView是View树的顶级View，它是FrameLayout的子类。

首先在 Activity 中我们可以重写 onAttachedToWindow() 和 onDetachedFromWindow() 这一对方法。

细心的小伙伴会发现，在 RecyclerView.Adapter 中也会有这么一个 onViewAttachedToWindow() 和 onViewDetachedToWindow()。
这两个方法在列表布局的时候，用作曝光埋点非常好用，当 Adapter 创建的 View 被窗口分离（即滑动离开了当前窗口界面的）的时候，onViewAttachedToWindow() 会被直接回调，反之，在列表项 View 在被滑动进屏幕的时候，onViewDetachedToWindow() 会立马被调用。

还没看到RxAndroid出3.0
  
在HashMap中有两个很重要的参数，容量(Capacity)和负载因子(Load factor)
  
对key的hashCode()做hash，然后再计算index;
如果没碰撞直接放到bucket里；
如果碰撞了，以链表的形式存在buckets后；
如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树；
如果节点已经存在就替换old value(保证key的唯一性)
如果bucket满了(超过load factor*current capacity)，就要resize。

当put时，如果发现目前的bucket占用程度已经超过了Load Factor所希望的比例，那么就会发生resize。在resize的过程，简单的说就是把bucket扩充为2倍，之后重新计算index，把节点再放到新的bucket中。

介绍多线程编程另外一个比较重要的概念：先行发生原则（happens-before）。
例如操作A先行于操作B发生，那么操作B可以观察到操作A所产生的所有影响，
程序次序规则：在同一个线程中，按照程序代码顺序，写在前面的操作先行发生与写在后面操作(控制流顺序：分支、循环等)。
