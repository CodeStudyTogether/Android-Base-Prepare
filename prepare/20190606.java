https://juejin.im/post/5cf71e12e51d45778f076cec

栈和堆的区别
在函数中定义的一些基本类型的变量和对象的引用变量都在函数的栈内存中分配。
堆内存用来存放由new创建的对象和数组。 

接口和抽象类的本质区别
默认的方法实现	它可以有默认的方法实现	接口完全是抽象的。它根本不存在方法的实现
子类使用extends关键字来继承抽象类。如果子类不是抽象类的话，它需要提供抽象类中所有声明的方法的实现。	子类使用关键字implements来实现接口。它需要提供接口中所有声明的方法的实现
抽象类可以有构造器	接口不能有构造器
除了你不能实例化抽象类之外，它和普通Java类没有任何区别	接口是完全不同的类型
抽象方法可以有public、protected和default这些修饰符	接口方法默认修饰符是public。你不可以使用其它修饰符。
抽象方法可以继承一个类和实现多个接口	接口只可以继承一个或多个其它接口
由于Java不支持多继承，子类不能够继承多个类，但可以实现多个接口。

String是字符串常量，而StringBuffer和StringBuilder是字符串变量。由String创建的字符内容是不可改变的，而由StringBuffer和StringBuidler创建的字符内容是可以改变的。
StringBuffer是线程安全的，而StringBuilder是非线程安全的。
字符串常量池(String pool, String intern pool, String保留池) 是Java堆内存中一个特殊的存储区域, 当创建一个String对象时,假如此字符串值已经存在于常量池中,则不会创建一个新的对象,而是引用已经存在的对象。

注解、反射、泛型
泛型”一词中的泛字可以理解为泛化的意思，即由具体的、个别的扩大为一般的。
<? extends T> 上界通配符
<? super T> 下界通配符
<?> 无界通配符
反射是Java语言本身具备的一个重要的动态机制。用一句话来解释反射的定义：自控制，自描述。即通过反射可以动态的获取类、属性、方法的信息，也能构造对象并控制对象的属性和行为。
Annotation 中文译过来就是注解、标释的意思
@Override和@Deprecated
注解通过反射获取。首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解
JUnit
ButterKnife
Retrofit
注解的提取需要借助于 Java 的反射技术，反射比较慢，所以注解使用时也需要谨慎计较时间成本。

如果你听说生产者-消费者（《操作系统》）模型，这个Handler-Looper也许可以套用一下。调用Handler的线程就是生产者，生产要执行的任务；Looper绑定的线程就是消费者，负责消化（执行）任务。这些任务通过一个队列从生产者传给消费者。这就形成了N个生产者，1个消费者的模型。当队列中没有任务的时候，消费者就等着，直到有生产者向队列中添加了任务。然后就需要按照这个模型分析咯。
生产者：其他线程，通过调用Handler中的post系列方法向队列中放任务。放任务的时候，如果Looper线程睡着了就顺便上一巴掌叫醒他去工作。
消费者：Looper线程，执行Looper.prepare()的线程就是Looper线程啦。不停地调用MessageQueue.next()去拿任务，有可能阻塞。其实就一个死循环嘛。
队列：MessageQueue，可以阻塞和唤醒Looper线程。在调用next()的时候，如果有任务则执行；没有则阻塞。
looper()执行死循环。

View、ViewGroup的事件传递机制，如何解决滑动冲突？ 回答如何滑动冲突最好是举出实际的场景和怎么解决的
public boolean dispatchTouchEvent(MotionEvent ev){
    boolean consume = false;//是否消费事件
    if(onInterceptTouchEvent(ev)){//是否拦截事件
        consume = onTouchEvent(ev);//拦截了，交给自己的View处理
    }else{
        consume = child.dispatchTouchEvent(ev);//不拦截，就交给子View处理
    }

    return consume;//true：消费事件，终止。false:交给父onTouchEvent处理。并不再往下传递当前事件。
}
https://blog.csdn.net/qq_33463102/article/details/67640554
1：外部滑动方向与内部方向不一致。
2：外部方向与内部方向一致。
第一种：第一种的冲突主要是一个横向一个竖向的，所以我们只要判断滑动方向是竖向还是横向的，再让对应的View滑动即可。判断的方法有很多，比如竖直距离与横向距离的大小比较；滑动路径与水平形成的夹角等等。
第二种：对于这种情况，比较特殊，我们没有通用的规则，得根据业务逻辑来得出相应的处理规则。举个最常见的例子，ListView下拉刷新，需要ListView自身滑动，但是当滑动到头部时需要ListView和Header一起滑动，也就是整个父容器的滑动。如果不处理好滑动冲突，就会出现各种意想不到情况。

View就是用户交互的组件（控件）
View是矩形的
View的职责是绘制和事件处理
View是android所有控件的父类
ViewGroup是View的一个子类
ViewGroup能够包含其他的view（孩子）
ViewGroup是布局的基类
ViewGroup的测量
相同点:measure -> onMeasure
不同点：作为一个父容器，需要去测量孩子，拿到孩子申请的宽高，打包成对孩子的期望，去测量孩子（child.measure）

ViewGroup的布局
相同点:layout(l, t, r, b)
不同点:ViewGroup要去覆写onLayout,去布局孩子，调用孩子layout方法，指定孩子上下左右的位置

ViewGroup的绘制
相同点:draw -> onDraw
不同点：ViewGroup一般不会去画自己，ViewGroup默认实现了dispatchDraw去绘制孩子（child.draw）

首先，OkHttpClient 通过Builder构建 Request(url\method\header\body) 转换为 newCall;

然后，在 RealCall 中执行异步或同步任务；

最后，配合一些拦截器 interceptor 发送请求得到返回 response(code\message\headers\body)。

传输层默认就使用OkHttp；
支持NIO；
默认使用Gson

Retrofit就像一个适配器（Adapter）的角色，将一个Java接口转换成一个Http请求并返回一个Call对象，简单的调用接口方法就可以发送API请求，如此精简！非常的神奇！相比Volley，Retrofit完全隐藏了Request 的请求体，并使用okhttp执行请求。
构造者模式创建Retrifit对象初始化okHttpClient,ConverterFactory,CallAdapterFactory
调用retrofit.create()方法,使用代理模式拦截service调用的每个方法
获取service中Method上所有相关的注解参数保存在ServiceMethod对象中
再通过ServiceMethod对象创建OkhttpCall对象,内部调用Okhttp.call实现请求.
最后通过适配器模式,用初始化时保存到ServiceMethod中的CallAdapter对象中的adapt(OkhttpCall)方法,返回我们声明的接口的service中方法返回值.
  
对于Android应用的开发中本身可视为一种MVC架构。
View: 对于View层也是视图层，在View层中只负责对数据的展示，提供友好的界面与用户进行交互。在Android开发中通常将Activity或者Fragment作为View层。
Model: 对于Model层也是数据层。它区别于MVC架构中的Model，在这里不仅仅只是数据模型。在MVP架构中Model它负责对数据的存取操作，例如对数据库的读写，网络的数据的请求等。
Presenter:对于Presenter层他是连接View层与Model层的桥梁并对业务逻辑进行处理。在MVP架构中Model与View无法直接进行交互。所以在Presenter层它会从Model层获得所需要的数据，进行一些适当的处理后交由View层进行显示。这样通过Presenter将View与Model进行隔离，使得View和Model之间不存在耦合，同时也将业务逻辑从View中抽离。
https://blog.csdn.net/ljd2038/article/details/51477475

https://www.cnblogs.com/zhuqil/archive/2012/07/23/2604572.html
我们都知道HTTPS能够加密信息，以免敏感信息被第三方获取。所以很多银行网站或电子邮箱等等安全级别较高的服务都会采用HTTPS协议。
HTTPS其实是有两部分组成：HTTP + SSL / TLS，也就是在HTTP上又加了一层处理加密信息的模块。服务端和客户端的信息传输都会通过TLS进行加密，所以传输的数据都是加密后的数据。具体是如何进行加密，解密，验证的，且看下图。
这个没什么好说的，就是用户在浏览器里输入一个https网址，然后连接到server的443端口。
采用HTTPS协议的服务器必须要有一套数字证书，可以自己制作，也可以向组织申请。区别就是自己颁发的证书需要客户端验证通过，才可以继续访问，而使用受信任的公司申请的证书则不会弹出提示页面(startssl就是个不错的选择，有1年的免费服务)。这套证书其实就是一对公钥和私钥。如果对公钥和私钥不太理解，可以想象成一把钥匙和一个锁头，只是全世界只有你一个人有这把钥匙，你可以把锁头给别人，别人可以用这个锁把重要的东西锁起来，然后发给你，因为只有你一个人有这把钥匙，所以只有你才能看到被这把锁锁起来的东西。

RecyclerView的缓存机制
Recycler首先去一级缓存（Cache）里面查找是否命中，如果命中直接返回。如果一级缓存没有找到，则去三级缓存查找，如果三级缓存找到了则调用Adapter.bindViewHolder来绑定内容，然后返回。如果三级缓存没有找到，那么就通过Adapter.createViewHolder创建一个ViewHolder，然后调用Adapter.bindViewHolder绑定其内容，然后返回为Recycler。
每次创建ViewHolder的时候，会按照优先级依次查询缓存创建ViewHolder。每次讲ViewHolder缓存到Recycler缓存的时候，也会按照优先级依次缓存进去。
三级缓存
一级缓存：返回布局和内容都都有效的ViewHolder
二级缓存：返回View
三级缓存：返回布局有效，内容无效的ViewHolder
RecyclerView缓存基本上是通过三个内部类管理的，Recycler、RecycledViewPool和ViewCacheExtension。
Recyclerview的四级缓存
https://zhooker.github.io/2017/08/14/%E5%85%B3%E4%BA%8ERecyclerview%E7%9A%84%E7%BC%93%E5%AD%98%E6%9C%BA%E5%88%B6%E7%9A%84%E7%90%86%E8%A7%A3/

When表达式
可以使用该表达式来替换switch语句
等式：
===：比较两个变量的地址
==：根据类型的equals方法返回相应的结果
val：只读变量，可以之后初始化，不过如果未初始化之前该变量无法使用，编译器会报错，编译成字节码的时候编译器应该会做优化，不建议之后初始化，什么时候用到什么时候定义。
Var：可变（略）
访问修饰符（默认public）
Kotlin 空安全(null-safety)
默认声明的变量是不能为 null 的，如果要使变量能为 null， 需要添加 ?
