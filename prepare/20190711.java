在构造器中利用建造者模式来构建 OkHttpClient 的对象。

在 getResponseWithInterceptorChain() 方法中有一堆的拦截器！！！

拦截器是 OkHttp 的精髓。

最后在聚合了这些拦截器后，利用 RealInterceptorChain 来链式调用这些拦截器，利用的就是责任链模式。

多线程是为了使得多个线程并行的工作以完成多项任务，以提高系统的效率。线程是在同一时间需要完成多项任务的时候被实现的。

最佳方案：使用线程安全的对象是实现线程安全的。 java.util.concurrent包下的类。

比如 闭锁 CountDownLatch、ConcurrentHashMap、HashTable 、ThreadPoolExecutor 
