equals的作用是判断两个对象是否相等。

通过判断两个对象的地址是否相同来判断。

能够高效率的产生一个离散的int值。

通过hashCode（）来计算出两个对象的hash值然后进行比较。

如果两个对象的hashCode相同，也不能 100%保证它们是相同的。

1.Person person = new A(); 不是父类对象指向子类引用而是父类引用指向子类对象

我们先对比下String, StringBuffer, StringBuilder这三个类。他们的主要区别一般体现在线程安全和执行效率上。
