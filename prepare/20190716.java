当我们线程创建过多时，容易引发内存溢出，因此我们就有必要使用线程池的技术了。

总体来说，线程池有如下的优势：
（1）降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
（2）提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
（3）提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。

其实Executors已经为我们封装好了4种常见的功能线程池，如下：

定长线程池（FixedThreadPool）
定时线程池（ScheduledThreadPool ）
可缓存线程池（CachedThreadPool）
单线程化线程池（SingleThreadExecutor）

https://juejin.im/post/5d2d6ad2e51d457759648795

为什么16ms一帧？
16ms是1000ms/60帧得到的结果，60帧对于人眼而言已经是很流畅的体验了。而最低的限度是33ms一帧，也就是1000ms/30帧得到的结果。如果时间再长一点的话，就有可能发生人眼可见的卡顿了。 

view 和 presenter 是 一对一关系时，在我看来是过度设计。

虽然解耦，逻辑清晰等有点。。
但是。因为业务的关系。。经常一个activity带n个fragment，然后每个都带个Presenter， 有的需要网络请求，有的不需要。。。其实代码量还好，但是。。文件数量大大提升。。。总觉得还是很麻烦

MVP：Model 通知 Presenter 通知 View， Presenter 切断了 Model 和 View 的联系

架构师从来都不是看书看来的，需要长久的实践与累积。最好的方式就是在工作中累积。
首先，你得明确，你是在做产品，不是做项目。
其次，架构的前期需求分析与建模非常重要，多思考未来可能的扩展。
最后，最好有一定的代码规范甚至是洁癖。

View是Android中所有控件的基类，无论是TextView、ImageView还是Button、CheckBox都是继承自View，可以说我们的应用界面就是由各式各样的View组成的。

ViewGroup从名字就可以看出来表示一组View，它可以包含多个View。平时常用的LinearLayout、RelativeLayout、FrameLayout等都是继承自ViewGroup,并且ViewGroup也是继承自View。

EXACTLY模式下，父View为子View测量出所需要的大小，一般对应match_parent属性，强制大小充满父布局和父布局一样大，或者具体数值，比如100dp。

AT_MOST模式下，父View为子View提供一个最大的尺寸大小，子View大小可以任意由自己决定，但是最大不能超过这个尺寸，一般对应wrap_content属性，自适应大小。

Window是一个抽象的窗体的概念，每个Activity初始化默认会创建一个Window，界面上所有的View都会添加到这个Window上。Android中的Window类也是个抽象类，它的实现类是PhoneWindow。
