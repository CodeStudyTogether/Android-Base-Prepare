Android一般的进程优先级划分： 1.前台进程 (Foreground process) 2.可见进程 (Visible process) 3.服务进程 (Service process) 4.后台进程 (Background process) 5.空进程

上面的异步任务和Runnable都是一个匿名内部类，因此它们对当前Activity都有一个隐式引用。如果Activity在销毁之前，任务还未完成；
那么将导致Activity的内存资源无法回收，造成内存泄漏。正确的做法还是使用静态内部类的方式

对于使用了BraodcastReceiver，ContentObserver，File，Cursor，Stream，Bitmap等资源的使用，应该在Activity销毁时及时关闭或者注销，否则这些资源将不会被回收，造成内存泄漏。

首先实现同一应用内跨进程通信，然后在实现APP间通信。因为AIDL是c/s模式，所以我们先创建一个服务端应用。

AIDL是不支持传递普通的Java对象的，不过支持Parcelable对象，所以我们的消息对象要实现Parcelable。
