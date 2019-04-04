1.activity和service的通讯问题   使用Binder
2.IntentService与Service的区别（intentservice的优点）
IntentService是Service的子类，是一个异步的，会自动停止的服务，很好解决了传统的Service中处理完耗时操作忘记停止并销毁Service的问题
会创建独立的worker线程来处理所有的Intent请求；
会创建独立的worker线程来处理onHandleIntent()方法实现的代码，无需处理多线程问题；
所有请求处理完成后，IntentService会自动停止，无需调用stopSelf()方法停止Service；
为Service的onBind()提供默认实现，返回null；
为Service的onStartCommand提供默认实现，将请求Intent添加到队列中；
IntentService不会阻塞UI线程，而普通Serveice会导致ANR异常
Intentservice若未执行完成上一次的任务，将不会新开一个线程，是等待之前的任务完成后，再执行新的任务，等任务完成后再次调用stopSelf()
3.Service的生命周期
非绑定模式:当第一次调用 startService 的时候执行的方法依次为 onCreate()、onStartCommand(),当 Service 关闭的时候调用 onDestory 方 法。
绑定模式:第一次 bindService()的时候,执行的方法为 onCreate()、 onBind()解除绑定的时候会执行 onUnbind()、onDestory()。
上面的两种生命周期是在相对单纯的模式下的情形。我们在开发的过程中还 必须注意 Service 实例只会有一个,也就是说如果当前要启动的 Service 已经存 在了那么就不会再次创建该 Service 当然也不会调用 onCreate()方法。
4.如何提高service的优先级？
（1）在AndroidManifest.xml文件中对于intent-filter可以通过android:priority = “1000”这个属性设置最高优先级，1000是最高值，如果数字越小则优先级越低，同时实用于广播。
（2）在onStartCommand里面调用 startForeground()方法把Service提升为前台进程级别，然后再onDestroy里面要记得调用stopForeground ()方法。
（3）onStartCommand方法，手动返回START_STICKY。
（4）在onDestroy方法里发广播重启service。
service +broadcast 方式，就是当service走ondestory的时候，发送一个自定义的广播，当收到广播的时候，重新启动service。（第三方应用或是在setting里-应用-强制停止时，APP进程就直接被干掉了，onDestroy方法都进不来，所以无法保证会执行）
（5）监听系统广播判断Service状态。
通过系统的一些广播，比如：手机重启、界面唤醒、应用状态改变等等监听并捕获到，然后判断我们的Service是否还存活。
（6）Application加上Persistent属性。

Jetpack是一个类库(libraries)、工具(tools)、帮助快易开发构建令人满意的Android App的指导(architectural guidance)集合，它提供了通用的基础代码(code)，这样你可以专注于让你app与众不同的工作。

快速开发
组件可单独使用，也可以同时工作，当使用kotlin语言特性时，可以让你更有效率
消除样板代码
Android Jetpack管理乏味的活动，例如后台任务、导航和生命周期管理，你可以专注于让你的app更棒的东西。
构建高质量、健壮的app
基于现代设计实践，Android Jetpack组件可以减少崩溃和内存泄漏，且向后兼容。

Foundation Components
包含核心系统能力、Kotlin扩展、混合dex(multidex)和测试自动化支持的组件
4大模块：AppCompat,Android KTX,Multidex,Test
Architecture Components
一个类库的集合，可以帮助你设计健壮、可测、可维护的app。主要为管理UI Components生命周期和处理数据持久化。
8大模块：Data Binding,Lifecycles,LiveData,Navigation,Paging,Room,ViewModel,WorkManager
Behavior Components
一个类库的集合，用于帮助你设计健壮、可测、可维护的app。主要为管理UI Components生命周期和处理数据持久化。
6大模块:DownloadManager,Media&Palyback,Notifications,Permissions,Sharing,Slices
UI Components
不仅仅是更容易，更乐于使用的构建app的类库
8大模块：Animations and Transitions,Auto(汽车),Emoji,Fragment,Layout,Palette,TV,WearOS
