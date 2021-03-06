- EventBus
EventBus 是一款在 Android 开发中使用的发布/订阅事件总线框架，基于观察者模式，将事件的接收者和发送者分开，简化了组件之间的通信，使用简单、效率高、体积小
public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EventBus();
                }
            }
        }
        return defaultInstance;
    }
运用了单例模式

- jsoup
Jsoup抓取页面的流程：先模拟成浏览器去连接需要被访问的页面，用get/post来获取整个页面的html代码，得到的值为Document类型。最终原理其实就是通过HttpURLConnection去创建一个连接，然后得到返回的值。

- Monkey，顾名思义，也叫猴子测试。一般指无目的地随机测试，就像一个猴子在那乱按乱点。它是Android SDK中自带的一个黑盒自动化测试工具，通过随机触发界面事件来发现应用的问题，一般多用于App的稳定性测试和异常发现。
adb shell monkey [options] <event_count>

- Tinker
tinker将old.apk和new.apk做了diff，拿到patch.dex，然后将patch.dex与本机中apk的classes.dex做了合并，生成新的classes.dex，运行时通过反射将合并后的dex文件放置在加载的dexElements数组的前面。

- RxJava
响应式编程
create
from
timer
range
repeat

- Glide
Glide有生命周期的概念（主要是对请求进行pause，resume，clear），而且其生命周期与Activity/Fragment的生命周期绑定
生成一个无UI的SupportRequestManagerFragment
在RequestManager构造时，会将RequestManager作为上述Fragment生命周期的监听者，从而使得RequsetManager中的Request生命周期始终与Fragment保持一致：

- Socket
Java Socket(套接字)通常也称作"套接字"，用于描述IP地址和端口，是一个通信链的句柄。
 Socket的特点：
1.Socket基于TCP链接，数据传输有保障

2.Socket适用于建立长时间链接

3.Socket编程通常应用于即时通讯

- RecyclerView
RecyclerView是一个比ListView更灵活的一个控件，以后可以直接抛弃ListView了，也可以替代Gridview。 
RecyclerView改善了ListView的编程接口，他其实是一个ViewGroup ，能配合任何基于adapter的view实现多种布局

更好的实现局部刷新 ，调用notifyItemChanged(position)即可

https://blog.csdn.net/fyfcauc/article/details/54140777

- mvvm
Model ：负责数据实现和逻辑处理，类似MVP。View ： 对应于Activity和XML，负责View的绘制以及与用户交互，类似MVP。ViewModel ： 创建关联，将model和view绑定起来。如此之后，我们model的更改，通过viewmodel反馈给view。（view的xml布局文件，经过特定的编写，编译工具处理后，生成的代码会接收viewmodel的数据通知消息，自动刷新界面）。

- Android-Universal-Image-Loader
① UI：请求数据，使用唯一的Key值索引Memory Cache中的Bitmap。

② 内存缓存：缓存搜索，如果能找到Key值对应的Bitmap，则返回数据。否则执行第三步。

③ 硬盘存储：使用唯一Key值对应的文件名，检索SDCard上的文件。

④ 如果有对应文件，使用BitmapFactory.decode*方法，解码Bitmap并返回数据，同时将数据写入缓存。如果没有对应文件，执行第五步。

⑤ 下载图片：启动异步线程，从数据源下载数据(Web)。

⑥ 若下载成功，将数据同时写入硬盘和缓存，并将Bitmap显示在UI中。

- CardView
CardView 继承自FrameLayout类，并且可以设置圆角和阴影，使得控件具有立体性，也可以包含其他的布局容器和控件。

- 事件消费机制
https://www.jianshu.com/p/4e19af8a59cd

通过一次流程分析我们得知, 整个 Glide 图片加载主要有如下几步

请求管理器的构建

一个 Context 对应一个 RequestManager


请求的构建

请求的宽高、采样的方式、transform 变化...


通过请求获取资源

Engine 从内存缓存中查找

从 ActiveResources 缓存中查找
从 LruResourceCache 缓存中查找


内存缓存不存在, 则构建任务执行

构建一个 EngineJob 描述一个请求任务, 任务类型为 DecodeJob

DecodeJob 从 diskCache 中查找
diskCache 不存在, 则通过网络请求, 获取数据源
通过 Downsampler 解析源数据并进行采样压缩获取 Bitmap
对 Bitmap 进行 transform 处理

构建磁盘缓存的 key


将 transform  之后的 Bitmap 转为 Resource 回传给上层

DecodeJob 进行磁盘缓存






Engine 对资源进行内存缓存


传递给 View 进行展示

Glide:https://juejin.im/post/5ca5c7f7e51d45430235ba03

构建线程池

根据不同的任务特性, 构建了不同的线程池


构建内存缓存策略

内存计算器
LRU 算法


构建对象复用池
构建工厂类

创建了一个 RequestManagerRetriever 对象


构建 Glide 执行引擎

用于组织线程池和缓存


创建 Glide 对象

将 GlideBuilder 中的数据导入
构建一个 registry, 注册了众多的编解码器
构建了一个 GlideContext 对象, 描述其数据资源的上下文



从 Glide 构造的流程中, 可以看到它主要有五个核心部分, 线程池, 内存缓存策略, 对象复用策略和图片音视频的编解码
