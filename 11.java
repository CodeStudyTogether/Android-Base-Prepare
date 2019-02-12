ArrayMap在内存使用上较HashMap更有优势，在Android开发中广为使用的基础API，也是大家所推荐的方法


HashMap和ArrayMap各自的优势

1.查找效率

HashMap因为其根据hashcode的值直接算出index，所以其查找效率是随着数组长度增大而增加的。

ArrayMap使用的是二分法查找，所以当数组长度每增加一倍时，就需要多进行一次判断，效率下降。

所以对于Map数量比较大的情况下，推荐使用



2.扩容数量


HashMap初始值16个长度，每次扩容的时候，直接申请双倍的数组空间。

ArrayMap每次扩容的时候，如果size长度大于8时申请size*1.5个长度，大于4小于8时申请8个，小于4时申请4个。

这样比较ArrayMap其实是申请了更少的内存空间，但是扩容的频率会更高。因此，如果当数据量比较大的时候，还是使用HashMap更合适，因为其扩容的次数要比ArrayMap少很多。



3.扩容效率

HashMap每次扩容的时候时重新计算每个数组成员的位置，然后放到新的位置。

ArrayMap则是直接使用System.arraycopy。

所以效率上肯定是ArrayMap更占优势。

这里需要说明一下，网上有一种传闻说因为ArrayMap使用System.arraycopy更省内存空间，这一点我真的没有看出来。arraycopy也是把老的数组的对象一个一个的赋给新的数组。当然效率上肯定arraycopy更高，因为是直接调用的c层的代码。



4.内存耗费

以ArrayMap采用了一种独特的方式，能够重复的利用因为数据扩容而遗留下来的数组空间，方便下一个ArrayMap的使用。而HashMap没有这种设计。

由于ArrayMap只缓存了长度是4和8的时候，所以如果频繁的使用到Map，而且数据量都比较小的时候，ArrayMap无疑是相当的节省内存的。



5.总结

综上所述，

数据量比较小，并且需要频繁的使用Map存储数据的时候，推荐使用ArrayMap。

而数据量比较大的时候，则推荐使用HashMap。

那么使用SparseArray：
1、如果key的类型已经确定为int类型，那么使用SparseArray，因为它避免了自动装箱的过程，如果key为long类型，它还提供了一个LongSparseArray来确保key为long类型时的使用

2、如果key类型为其它的类型，则使用ArrayMap
