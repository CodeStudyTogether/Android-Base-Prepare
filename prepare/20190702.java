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
