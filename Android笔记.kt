https://www.jianshu.com/p/0f82b0650909

App中唤醒其他进程的实现方式
进程保活的方式
如何保证一个后台服务不被杀死？

开启一个像素的Activity
前台服务
相互唤醒的意思就是，假如你手机里装了支付宝、淘宝、天猫、UC等阿里系的app，那么你打开任意一个阿里系的app后，有可能就顺便把其他阿里系的app给唤醒了。这个完全有可能的。此外，开机，网络切换、拍照、拍视频时候，利用系统产生的广播也能唤醒app
这个是系统自带的，onStartCommand方法必须具有一个整形的返回值，这个整形的返回值用来告诉系统在服务启动完毕后，如果被Kill，系统将如何操作，这种方案虽然可以，但是在某些情况or某些定制ROM上可能失效，我认为可以多做一种保保守方案。

Android为每个应用程序分配的内存大小是多少
我们在应用中可以通过ActivityManager的MemoryInfo内部类获取内存信息

App启动流程，从点击桌面开始
我们平时在手机桌面上点击一个app 图标， 就能启动一个app应用。从用户角度来看，这个过程看起来很简单，但是它的背后又隐藏着什么玄机 

每个Android App都在一个独立空间里, 意味着其运行在一个单独的进程中, 拥有自己的VM, 被系统分配一个唯一的user ID。
Android进程与Linux进程一样. 默认情况下, 每个apk运行在自己的Linux进程中. 另外, 默认一个进程里面只有一个线程---主线程. 这个主线程中有一个Looper实例, 通过调用Looper.loop()从Message队列里面取出Message来做相应的处理.
Click事件会调用startActivity(Intent), 会通过Binder IPC机制, 最终调用到ActivityManagerService.
ActivityManagerService会检查并在新的task中启动目标activity.
现在, 是时候检查这个进程的ProcessRecord是否存在了.
如果ProcessRecord是null, ActivityManagerService会创建新的进程来实例化目标activity.
ActivityManagerService调用startProcessLocked()方法来创建新的进程, 该方法会通过前面讲到的socket通道传递参数给Zygote进程. Zygote孵化自身, 并调用ZygoteInit.main()方法来实例化ActivityThread对象并最终返回新进程的pid.
ActivityThread随后依次调用Looper.prepareLoop()和Looper.loop()来开启消息循环.

系统启动流程是什么？（提示：Zygote进程 –> SystemServer进程 –> 各种系统服务 –> 应用进程）

简述Activity启动全部过程
Android中，一个应用程序的开始可以说就是从ActivityThread.java中的main()方法开始的。都是学过Java的人，想必也都知道Java的程序入口就是main()方法。Android其实也就是一个Java程序而已。
初始化主线程的Looper、主Handler。并使主线程进入等待接收Message消息的无限循环状态。
ActivityManagerService调度发送初始化消息
https://juejin.im/entry/58f5b68e61ff4b005807ab47
