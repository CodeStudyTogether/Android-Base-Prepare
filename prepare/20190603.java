https://mp.weixin.qq.com/s?__biz=MzI2OTQxMTM4OQ==&amp;mid=2247489077&amp;idx=1&amp;sn=c9a1348a8ac83d2d0e25cfb58f46eeb6&amp;chksm=eae1e367dd966a71140b131452956c41c1410b4fab9ae9c8b8032050ca3ab950f4a34f455d58&amp;token=1903328570&amp;lang=zh_CN#rd&comefrom=https://blogread.cn/news/

在字节跳动的两年时间中见证了抖音从百万日活到2.5亿、团队从10人到100多人的过程，技术上不同时期的选型以及迭代、沉淀和更替。项目上经历了一个工程到模块化再到组件化最后插件化，深刻理解项目不同阶段和不同体量的时候技术框架的选型。流程上不同阶段不同的方案，一直在探索最大的效率的协同开发。产品上从不断试错到稳步发展的过程，也就是数据驱动业务的过程。

按照这个原则这次面试我就大胆的面试架构师或者能够带人的职位，所以很多问题都是架构的考虑和知识的广度以及自己的思考，这些回答很大程度上是开放题，相信大家都有自己的想法和见解，我就不班门弄斧了

mcv适用于较小，功能较少，业务逻辑较少的项目。
ViewModle易于单元测试。
适用于界面展示的数据较多的项目。

设计模式六大原则
单一职责原则
里氏替换原则
依赖倒置原则
接口隔离原则
迪米特法则
开放封闭原则
单一职责原则告诉我们实现类要职责单一；里氏替换原则告诉我们不要破坏继承体系；依赖倒置原则告诉我们要面向接口编程；接口隔离原则告诉我们在设计接口的时候要精简单一；迪米特法则告诉我们要降低耦合。而开闭原则是总纲，他告诉我们要对扩展开放，对修改关闭。

访问者模式
https://img-blog.csdn.net/20161206165956259?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMTUxODEyMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
软件系统中拥有一个由许多对象构成的，比较稳定的对象结构。这些对象都拥有一个accept方法来接受访问者的访问。

日志系统
https://blog.csdn.net/feiyangxiaomi/article/details/45560313
PrintStream
存到本地数据库

日志上传
wifi的时候上传
