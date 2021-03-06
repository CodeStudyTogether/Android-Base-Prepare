同时其内部的缓存设计也很好的提升了我们的App流畅度

RecyclerView由layoutManager，Adapter，ItemAnimator，ItemDecoration，ViewHolder五大核心组件。

RecyclerView对于View的缓存有分为三层，第一级是CachedViews，第二级是开发者可以自定义的一层缓存拓展ViewCacheExtension，第三级缓存是RecyclerPool。当三层缓存缓存都差不多相应的View之后，则会通过Adapter进行View的创建和数据的绑定。

https://juejin.im/post/5c9488eef265da612b1ab960#heading-2
