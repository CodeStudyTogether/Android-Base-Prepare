tcp/ip:https://github.com/crossoverJie/JCSprout/blob/master/MD/TCP-IP.md

HashSet和HashMap的区别
*HashMap*	*HashSet*
HashMap实现了Map接口	HashSet实现了Set接口
HashMap储存键值对	HashSet仅仅存储对象
使用put()方法将元素放入map中	使用add()方法将元素放入set中
HashMap中使用键对象来计算hashcode值	HashSet使用成员对象来计算hashcode值，对于两个对象来说hashcode可能相同，所以equals()方法用来判断对象的相等性，如果两个对象不同的话，那么返回false
HashMap比较快，因为是使用唯一的键来获取对象	HashSet较HashMap来说比较慢

Set的集合里不允许对象有重复的值，List允许有重复，它对集合中的对象进行索引，Queue的工作原理是FCFS算法(First Come, First Serve)。


众所周知 HashMap 是一个无序的 Map，因为每次根据 key 的 hashcode 映射到 Entry 数组上，所以遍历出来的顺序并不是写入的顺序。
因此 JDK 推出一个基于 HashMap 但具有顺序的 LinkedHashMap 来解决有排序需求的场景。
它的底层是继承于 HashMap 实现的，由一个双向链表所构成。


众所周知 synchronized 关键字是解决并发问题常用解决方案，有以下三种使用方式:
同步普通方法，锁的是当前对象。
同步静态方法，锁的是当前 Class 对象。
同步块，锁的是 () 中的对象。

当一个synchronized关键字修饰的方法同时又被static修饰，之前说过，非静态的同步方法会将对象上锁，但是静态方法不属于对象，而是属于类，它会将这个方法所在的类的Class对象上锁。
一个类不管生成多少个对象，它们所对应的是同一个Class对象。

支持线程安全的并发容器 ConcurrentHashMap 。

类别	synchronized	Lock
存在层次	Java的关键字，在jvm层面上	是一个类
锁的释放	1、以获取锁的线程执行完同步代码，释放锁 2、线程执行发生异常，jvm会让线程释放锁	在finally中必须释放锁，不然容易造成线程死锁
锁的获取	假设A线程获得锁，B线程等待。如果A线程阻塞，B线程会一直等待	分情况而定，Lock有多个锁获取的方式，具体下面会说道，大致就是可以尝试获得锁，线程可以不用一直等待
锁状态	无法判断	可以判断
锁类型	可重入 不可中断 非公平	可重入 可判断 可公平（两者皆可）
性能	少量同步	大量同步

混淆代码后崩溃日志中不显示行号的问题
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

对于存在透明通道的图片, 使用 ARGB_8888 保证图片不会丢失透明通道
对于无透明通道图片, 使用 RGB_565 保证图片内存占用量最低
