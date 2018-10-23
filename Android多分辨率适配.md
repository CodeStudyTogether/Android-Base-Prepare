## 屏幕尺寸
- 含义：手机对角线的物理尺寸
- 单位：英寸（inch），1英寸=2.54cm
## 屏幕像素密度
- 含义：每英寸的像素点数
- 单位：dpi（dots per ich）
- 假设设备内每英寸有160个像素，那么该设备的屏幕像素密度=160dpi
## 密度无关像素
- 含义：density-independent pixel，叫dp或dip，与终端上的实际物理像素点无关。
- 单位：dp，可以保证在不同屏幕像素密度的设备上显示相同的效果
## 最小宽度（Smallest-width）限定符
- sw xxxdp，即small width的缩写，其不区分方向，即无论是宽度还是高度，只要大于 xxxdp，就采用次此布局
## 宽高限定符适配
- 为了高效的实现UI开发，出现了新的适配方案，我把它称作宽高限定符适配。简单说，就是穷举市面上所有的Android手机的宽高像素值：
![Alt text](https://user-gold-cdn.xitu.io/2018/6/12/163f4802fbef23d0?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)
但是这个方案有一个致命的缺陷，那就是需要精准命中才能适配，比如1920x1080的手机就一定要找到1920x1080的限定符，否则就只能用统一的默认的dimens文件了。而使用默认的尺寸的话，UI就很可能变形，简单说，就是容错机制很差。

## 今日头条方案
- 支持以宽或者高一个维度去适配，保持该维度上和设计图一致；
- 支持dp和sp单位，控制迁移成本到最小。
- 从dp和px的转换公式 ：px = dp * density 。可以看出，如果设计图宽为360dp，想要保证在所有设备计算得出的px值都正好是屏幕宽度的话，我们只能修改 density 的值。

> https://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650826103&idx=1&sn=a11a8cb56988df2a0f0978a90e358dc2&chksm=80b7b1e9b7c038ff9988c15cccd5656ab3aab8fa2ee5d527298f85693217078aa7d0744df5b2&mpshare=1&scene=23&srcid=1023mbDTFytpwvvBHQZ3tzgN#rd

> https://github.com/JessYanCoding/AndroidAutoSize/blob/master/README-zh.md

> https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
