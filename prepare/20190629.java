看到源码默认的图片解码格式为ARGB_8888,和Picasso的默认格式相同了（貌似以前是RGB565）这个会多占内存了但是速度却快了，这需要牺牲空间换来换取更多的时间。

Glide.get(context)这里实际上是通过单例模式初始化Glide对象并赋值

builder.build内部通过构建者模式出创建实例

这个方法内部主要用于创建一个Fragment主要用来实现的Glide对Activity生命周期的感知作用（真是看了源码觉得fragment 还可以这样用）最终返回RequestManager。
