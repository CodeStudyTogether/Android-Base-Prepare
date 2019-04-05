通常情况下可以使用 Service 进行网络请求、播放音乐、文件 I/O 等操作。

通过在 <service> 标签里将 android:exported 设置为 false。可以防止其他的程序来启动你的 Service。

当组件通过调用 startService() 启动 Service 后，Service 就可以在后台无限期的运行，即使启动 Service 的组件被销毁也不受影响。
一般情况下 startService() 是执行单一操作，并且不会将执行结果返回给调用者。例如，它可能是下载文件或者上传文件，通常操作完成后会自动停止。
该方式允许多个组件同时对相同的 Service 进行 startService() 操作，但是如果只要有其中有一个组件调用了 stopSelf() 或 stopService()， 该 Service 就会被销毁。

只要有一个组件对该 Service 进行了绑定，那该 Service 就不会销毁。如果多个组件可以同时对一个 Service 进行绑定，只有所有绑定的该 Service 的组件都解绑后，该 Service 才会销毁。

虽然 Service 是在后台运行的，但其实还是在主线程中进行所有的操作。Service 启动时除非单独进行了定义，否则没有单独开启线程或者进程都是运行在主线程中。
所以任何能阻塞主线程的操作（例如：播放音乐或者网络请求），都应该在 Service 中单独开启新的线程来进行操作，否则很容易出现 ANR。

onStartCommand()
当另一个组件（如：Activity）通过调用 startService() 来启动 Service 时，系统会调用该方法。一旦执行该方法，Service 就会启动并在后台无限期执行。
如果实现该方法，在 Service 执行完后，需要调用 stopSelf() 或 stopService() 来停结束Service。
如果只是会通过绑定的方式（bind）的方式来启动 Service 则不需要重写该方法。

系统会调用这个函数当某个组件（例如：activity，fragment）通过调用 bindService() 绑定的方式来启动 Service 的时候。在实现这个函数的时候，必须要返回一个 IBinder 的继承类，来与 Service 进行通信。
这个函数是默认必须要重写的，但是如果不想通过绑定的方式来启动 Service，则可以直接返回 null。

onCreate()
系统会调用此方法在第一次启动 Service 的时候，用于初始化一些一次性的变量。如果 Service 已经启动了，则此方法就不会再别调用。

startService()
onCreate() -> onStartCommand() -> onDestroy()
  
bindService()
onCreate() -> onBind() -> onUnbind() -> onDestroy()
  
当系统内存不足的时候，系统会强制回收一些 Activity 和 Service 来获取更多的资源给那些用户正在交互的程序或页面。当资源充足的时候可以通过  onStartCommand()  的返回值，来实现 Service 自动重启。
public int onStartCommand(Intent intent, int flags, int startId) {
  return START_NOT_STICKY | START_STICKY | START_REDELIVER_INTENT;
}

为了满足后台运行异步线程的需求，Android 的框架提供了 IntentService。

IntentService 是 Service 的子类，并且所有的请求操作都是在异步线程里。如果不需要 Service 来同时处理多个请求的话，IntentService 将会是最佳的选择。
使用该服务只需要继承并重写 IntentService 中的 onHandleIntent() 方法，就可以对接受到的 Intent 做后台的异步线程操作了。

前台服务必须给状态栏提供一个通知，它被放到正在运行（Ongoing）标题之下 —— 这就意味着通知只有在这个服务被终止或从前台主动移除通知后才能被解除。

前台 Service 的系统优先级更高、不易被回收；
前台 Service 会一直有一个正在运行的图标在系统的状态栏显示，下拉状态栏后可以看到更加详细的信息，非常类似于通知的效果。

提升 Service 的优先级
为防止 Service 被系统回收，可以尝试通过提高服务的优先级解决。优先级数值最高为 1000，数字越小，优先级越低。

在 Manifest.xml 文件中设置 persistent 属性为 true，则可使该服务免受 out-of-memory killer 的影响。但是这种做法一定要谨慎，系统服务太多将严重影响系统的整体运行效率。
