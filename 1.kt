1.mipmap和drawable的区别
android 通过 mipmap 技术提前对按缩小层级生成图片预先存储在内存中，这样就提高了图片渲染的速度和质量。
2.jar和aar的区别
JAR 文件就是 Java Archive File，顾名思意，它的应用是与 Java 息息相关的，是 Java 的一种文档格式。只包含了class文件与清单文件 ，不包含资源文件
3.面向对象的特征有哪些方面  
抽象：
继承：继承与接口的区别
封装：
多态性：
4.String,StringBuffer,StringBuilder
在这方面运行速度快慢为：StringBuilder > StringBuffer > String
5.String 为什么要设计成不可变的？
字符串常量池(String pool, String intern pool, String保留池) 是Java堆内存中一个特殊的存储区域, 当创建一个String对象时,假如此字符串值已经存在于常量池中,则不会创建一个新的对象,而是引用已经存在的对象。
6.进程之间的优先级。 前台进程、可见进程、后台进程、不可见进程与空进程。腾讯面的时候还特意问了我进程的保活措施。
进程保活（不死进程）
7.Android屏幕切换 onConfigurationChanged
（1）不设置Activity的Android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次
（2）设置Activity的android:configChanges=”orientation”时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次
（3）设置Activity的android:configChanges=”orientation|keyboardHidden|screenSize”时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法。
8.自定义viewgroup和自定义view
9.Activity的四种launchMode
standard，singleTop，singleTask，singleInstance
