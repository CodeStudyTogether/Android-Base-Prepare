https://www.jianshu.com/p/bb53cba6c8f4  谢谢作者~
1.没有“;”
2.重要的“:”
3.没有“new”
4.变量、常量、类型推断
5.初始化和延迟加载
6.空指针安全
7.定义函数
8.用is取代了instance of
9.in、区间和集合
10.用when取代了switch
11.字符串模板
12.数据类
13.单例模式
14.为已存在的类扩展方法和属性
15.类的家族结构
16.构造函数
17.初始化模块init

java类加载机制
jdk和jre是什么区别？ JDK就是Java Development Kit.简单的说JDK是面向开发人员使用的SDK，它提供了Java的开发环境和运行环境。SDK是Software Development Kit 一般指软件开发包，可以包括函数库、编译程序等。JRE是Java Runtime Enviroment是指Java的运行环境，是面向Java程序的使用者，而不是开发者。

Bootstrap Class Loader是所有classloader的父加载器。它是有native代码实现的

JVM在加载类时默认采用的是双亲委派机制。

JVM预定义的三种类型类加载器：

启动（Bootstrap）类加载器：是用本地代码实现的类装入器，它负责将 <Java_Runtime_Home>/lib下面的类库加载到内存中（比如rt.jar）。由于引导类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用，所以不允许直接通过引用进行操作。
标准扩展（Extension）类加载器：是由 Sun 的 ExtClassLoader（sun.misc.Launcher$ExtClassLoader）实现的。它负责将< Java_Runtime_Home >/lib/ext或者由系统变量 java.ext.dir指定位置中的类库加载到内存中。开发者可以直接使用标准扩展类加载器。
系统（System）类加载器：是由 Sun 的 AppClassLoader（sun.misc.Launcher$AppClassLoader）实现的。它负责将系统类路径（CLASSPATH）中指定的类库加载到内存中。开发者可以直接使用系统类加载器。

某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次递归，如果父类加载器可以完成类加载任务，就成功返回；只有父类加载器无法完成此加载任务时，才自己去加载。
