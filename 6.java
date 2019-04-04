冒泡排序
for(int i=0;i<a.length-1;i++){
  for(int j=0;j<a.length-1-i;j++){
    if(a[j]>a[j+1]){
      temp=a[j];
      a[j]=a[j+1];
      a[j+1]=temp;
    }
  }
}

快速排序
通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

递归思想很重要

数据库建表时索引的用处
有些程序员没听过索引是什么，有些从前辈那里得知索引可以加快查询但对原理却不甚了解，掌握这些常用技巧背后的理论知识才能做到合理使用，比如为什么我们不对表的每一个field都建立索引呢？理解索引是通过「新建表」配合「B+树」来实现快速查询的，就能很好明白索引这项利器的优和劣。索引也是我面试时的必问问题之一。

用注解去封装eventbus https://blog.csdn.net/jiashuai94/article/details/79725755

RoundedBitmapDrawable 是 Android 版本 22.1.0 的时候加入的，它的主要作用是创建圆角的 Drawable。

Android 开发过程中，Model 层通常是比较薄弱的。获取数据的代码经过各种优秀的封装，已经可以简化到短短几行代码，对于简单的项目而言，全都写在 Activity/Fragment 中就是最合适的了，如果使用了 MVP 或者 MVVM 模式，也基本会把数据的获取放在 Presenter/ViewModel 中。（后面用业务逻辑层表示 Controller/Presenter/ViewModel）

Android Q:Wifi 模式选择（high performance / low latency）

https://juejin.im/post/5c9f3027f265da30c90269b4
