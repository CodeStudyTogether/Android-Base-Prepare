LinkedHashMap类是构建在HashMap的基础上的。HashMap是数组+链表+红黑树的复合数据结构。LinkedHashMap在HashMap的基础上添加了head和tail指针。这两个指针会将HashMap中的元素链接起来，组成一个链表。
上面我们或多或少已经介绍了使用LinkedHashMap来实现LRU的相关内容。
LinkedHashMap与HashMap相比，额外添加了一条链表将所有节点连接起来。这个链表是双向的循环链表。
accessOrder参数默认是false。LinkedHashMap使用插入排序机制。保持默认的插入顺序。如果将accessOrder设置为true。那么访问LinkedHashMap中的元素将导致最新访问的元素往链表尾部移动，符合LRU的访问特性。

使用 interrupt() 方式终止  不能立刻终止
循环方式去终止

Handler类，Handler类内部会持有一个MessageQueue对象和一个Looper的实例，这两个实例都是和线程相关的，在调用Handler构造函数并且没传入Looper参数的情况下，默认就是当前线程的Looper和MessageQueue
Looper类，通过Looper.prepare()和Looper.prepareMainLooper()这两个静态方法构建实例，后者是用来初始化Main线程（也就是UI线程）的Looper的，我们在应用开发中不要使用这个方法，会报错哦。
MessageQueue类。一个链表实现的消息队列，由Looper负责初始化并被当前Looper对象持有。因为Looper对象是和某个线程绑定的，所以MessageQueue也是和线程绑定的。即一个线程只能有一个Looper和MessageQueue实例，并且不同线程的Looper，MessageQueue不同。
Handler 工作流程基本包括 Handler、Looper、Message、MessageQueue 四个部分。
我们取消息采用了一个无限 for 循环，当没有消息的时候，则把标记位 nextPollTimeOutMillis 设置为 -1，在进行下一次循环的时候，通过 nativePollOnce() 直接让其处于线程阻塞状态。

对于绝大多数人来说，都是知道 MeasureSpec 是一个 32 位的 int 类型。并且取了最前面的两位代表 Mode，后 30 位代表大小 Size。
精确模式（MeasureSpec.EXACTLY）：在这种模式下，尺寸的值是多少，那么这个组件的长或宽就是多少，对应 MATCH_PARENT 和确定的值。
最大模式（MeasureSpec.AT_MOST）：这个也就是父组件，能够给出的最大的空间，当前组件的长或宽最大只能为这么大，当然也可以比这个小。对应 WRAP_CONETNT。
未指定模式（MeasureSpec.UNSPECIFIED）：这个就是说，当前组件，可以随便用空间，不受限制。

内存泄漏的根本原因是**一个长生命周期的对象持有了一个短生命周期的对象。
不要使用内部类或者匿名内部类做这样的处理就好了
各种注册操作没有对应的反注册
Bitmap 使用完没有注意 recycle()
很多人使用 Webview 都喜欢采用布局引用方式, 这其实也是作为内存泄漏的一个隐患。当 Activity 被关闭时，Webview 不会被 GC 马上回收,而是提交给事务，进行队列处理，这样就造成了内存泄漏, 导致 Webview 无法及时回收。
目前所知的比较安全的方案是：
在布局中动态添加 WebView。

dispatchTouchEvent()
onTouchEvent()
onInterceptTouchEvent()
从英文单词中已经很明显的知道，dispatchTouchEvent() 是负责事件分发的。当点击事件产生后，事件首先会传递给当前的 Activity，这会调用 Activity 的 dispatchTouchEvent() 方法
onTouch() 执行总优先于 onClick()
onInterceptTouchEvent是在ViewGroup里面定义的。Android中的layout布局类一般都是继承此类的。onInterceptTouchEvent是用于拦截手势事件的，每个手势事件都会先调用onInterceptTouchEvent。
onTouchEvent同样也是在view中定义的一个方法。处理传递到view 的手势事件。手势事件类型包括ACTION_DOWN,ACTION_MOVE,ACTION_UP,ACTION_CANCEL等事件。
View里，有两个回调函数 ：
public boolean dispatchTouchEvent(MotionEvent ev)；  
public boolean onTouchEvent(MotionEvent ev); 
ViewGroup里，有三个回调函数 ：
public boolean dispatchTouchEvent(MotionEvent ev)；  
public boolean onInterceptTouchEvent(MotionEvent ev);  
public boolean onTouchEvent(MotionEvent ev);
从用户点击屏幕开始触发一个系列的点击事件时，事件真正的传递流程是：Activity（PhoneWindow）->DecorView->ViewGroup->View,在到达ViewGroup之前还有一个DecorView，事件是从Activity传过来的，但这些东西其实和ViewGroup的原理是一样的，Activity能看做一个大的ViewGroup，当它的DecorView包含的所有子View没有人能够消耗事件的时候(这样说有漏洞，大家懂我的意思就行了)最后还是会交给Activity处理。
事件冲突解决可以按照上面的原理在几个point中进行处理。最容易想到的处理的时机是在onInterceptTouchEvent里，比如当一个竖直方向滑动的ViewGroup里嵌套一个横向滑动的ViewGroup，可以在这里的ACTION_MOVE里来判断后续事件应该传递给谁处理，当然，也可以根据上面说的标记位FLAG_DISALLOW_INTERCEPT配合子View的dispatchTouchEvent来控制事件的流向，这都是比较容易想到的，不过看过别的大神，通过分享MotionEvent的方法来控制事件的流向，即在父容器中保存MotionEvent并在适当的时机传入子View自定义的事件处理方法来分享事件，也是可行的。
任何View只要拒绝了一系列事件中的ACTION_DOWN（返回false），则后续事件都不会再传递过来了。但如果拒绝了其他的事件，后续事件还是可以传过来的，比如View某次ACTION_MOVE没处理，这个没处理的事件最后会被Activity消耗掉（而不是View的父容器），但后续的事件还是会继续传给该View。
合理的利用ACTION_CANCEL能够控制一个系列事件的生命周期，让事件处理更加灵活。
