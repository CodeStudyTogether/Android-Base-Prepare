webview加载h5的优化
通过介绍才发现这个 SDK 是可以共享微信和手机 QQ 的 X5 内核。这就很方便了，作为国内市场最不可或缺的两个 App，我们能只需要集成一个很小的 SDK 就可以共享使用 X5 内核了，不得不说腾讯还是很有想法的。
使用 WebView 的时候，不在 XML 里面声明，而是在代码中直接 new 出来，传入 application context 来防止 activity 引用被滥用。

https://mp.weixin.qq.com/s/vxkAIfQrFkjrStG59RuRbg
https://juejin.im/post/5d0110a6f265da1b80203eb2

Object的方法有哪些
https://fangjian0423.github.io/2016/03/12/java-Object-method/
该方法返回对象的哈希码，主要使用在哈希表中，比如JDK中的HashMap。
在java程序执行过程中，在一个对象没有被改变的前提下，无论这个对象被调用多少次，hashCode方法都会返回相同的整数值。对象的哈希码没有必要在不同的程序中保持相同的值。
如果2个对象使用equals方法进行比较并且相同的话，那么这2个对象的hashCode方法的值也必须相等。
如果根据equals方法，得到两个对象不相等，那么这2个对象的hashCode值不需要必须不相同。但是，不相等的对象的hashCode值不同的话可以提高哈希表的性能。
类别	synchronized	Lock
存在层次	Java的关键字，在jvm层面上	是一个类
锁的释放	1、以获取锁的线程执行完同步代码，释放锁 2、线程执行发生异常，jvm会让线程释放锁	在finally中必须释放锁，不然容易造成线程死锁
锁的获取	假设A线程获得锁，B线程等待。如果A线程阻塞，B线程会一直等待	分情况而定，Lock有多个锁获取的方式，具体下面会说道，大致就是可以尝试获得锁，线程可以不用一直等待
锁状态	无法判断	可以判断
锁类型	可重入 不可中断 非公平	可重入 可判断 可公平（两者皆可）
性能	少量同步	大量同步

原来app端在接收到PMS发送的广播后，会finish掉top的一个activity，而activity在finish的过程中，ActivityStack.java会防止系统进入休眠态从而会申请wake lock锁，而wake lock锁需要PMS分配，于是频按power key就出现了PMS要依靠AMS发送广播给app，而app端在finish activity的时候又需要PMS的wake lock锁分配，这样，两者就处于互相等待的状态了，由于我司关于PMS的改动逻辑不可废弃，临时又没有其他的办法

Binder机制的实现思想
Binder是基于C/S架构的，简单解释下C/S架构，是指客户端(Client)和服务端(Server)组成的架构，Client端有什么需求，直接发送给Server端去完成，架构清晰明朗，Server端与Client端相对独立，稳定性较好；

最左面或者是最右面的那个元素被选为枢轴

网络层的控制功能是最复杂的，主要负责差错控制、拥塞控制等，任何控制都是建立在信息的基础之上的，在基于IP数据报的网络体系中，网关必须自己处理数据报的传输工作，而IP协议自身没有内在机制来获取差错信息并处理。为了处理这些错误，TCP/IP设计了ICMP协议，当某个网关发现传输错误时，立即向信源主机发送ICMP报文，报告出错信息，让信源主机采取相应处理措施，它是一种差错和控制报文协议，不仅用于传输差错报文，还传输控制报文。
传输层，主要功能是实现两台主机的应用程序的端到端的通信，提供应用程序间的通信。其功能包括：一、格式化信息流；二、提供可靠传输。为实现后者，传输层协议规定接收端必须发回确认，并且假如分组丢失，必须重新发送。
 
Binder是Android系统进程间通信（IPC）方式之一。Linux已经拥有的进程间通信IPC手段包括(Internet Process Connection)： 管道（Pipe）、信号（Signal）和跟踪（Trace）、插口（Socket）、报文队列（Message）、共享内存（Share Memory）和信号量（Semaphore）。
Binder基于Client-Server通信模式，传输过程只需一次拷贝，为发送发添加UID/PID身份，既支持实名Binder也支持匿名Binder，安全性高。
Binder使用Client-Server通信方式，安全性好，简单高效，再加上其面向对象的设计思想，独特的接收缓存管理和线程池管理方式，成为Android进程间通信的中流砥柱。
