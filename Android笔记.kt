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

对Dalvik、ART虚拟机有什么了解？
我们写的所有的 Java 代码最终都会被编译器编译为以 .class 结尾的字节码文件，然后最终被 Java 虚拟机执行，从而得到我们想要的结果。
首先 Java 虚拟机是一个规范，由 Sun 公司制定，任何实现该规范的虚拟机都可以用来执行 Java 代码。
由于 Androd 运行在移动设备上，内存以及电量等诸多方面跟一般的 PC 设备都有本质的区别 ，一般的 JVM 没法满足移动设备的要求，所以在开发 Android 过程中，Android 团队一开始就必须打造一个符合移动设备的可以执行 Java 代码的虚拟机。
这就是我们说的 Dalvik 虚拟机 。
Dalvik 是一个更符合移动设备的用于执行 Java 代码的虚拟机，但又不是一个严格按照 JVM 规范的虚拟机实现
JVM 可以执行的文件是 .class 结尾的字节码文件，而 Dalvik 执行的是 dex 文件。
为什么 Dalvik 执行 dex 文件而不是 .class 文件，其实这里是 Android 专为 Dalvik 虚拟机做的一个优化。
Dalvik 基于寄存器，而 JVM 基于栈，很明显，基于寄存器的 Dalvik 在速度方面优势会更明显。
从 Android L 开始，Android 开始启用了新设计的虚拟机 ART。与 Dalvik 不同，在Dalvik下，应用每次运行的时候，字节码都需要通过即时编译器（Just In Time ，JIT）转换为本地机器码，这会拖慢应用的运行效率。
而在ART 环境中，应用在第一次安装的时候，会使用设备上的dex2oat工具进行字节码转码，把字节码预先编译成本地机器码，使其成为真正的本地应用。这个过程叫做预编译（Ahead-Of-Time，AOT）。
采用 AOT 策略后的好处显而易见，应用的启动速度会因此快很多，但是与此同时，应用的安装时间就会因为执行 AOT 操作而变长，但是相比之下还是非常值得。
另外，ART的另一个缺点就是对存储空间占用变大。一般的字节码在编译转码后占用的空间大小比之前要增大10%-20%。

java语言的重要特点是与平台无关性

java虚拟机在执行字节码时，把字节码解释成具体平台的机器指令执行。

JVM初始运行的时候都会分配好Method Area（方法区）和Heap（堆），而JVM 每遇到一个线程，就为其分配一个Program Counter Register（程序计数器）, VM Stack（虚拟机栈）和Native Method Stack （本地方法栈），当线程终止时，三者（虚拟机栈，本地方法栈和程序计数器）所占用的内存空间也会被释放掉。
