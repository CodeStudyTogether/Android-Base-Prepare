webview加载h5的优化
通过介绍才发现这个 SDK 是可以共享微信和手机 QQ 的 X5 内核。这就很方便了，作为国内市场最不可或缺的两个 App，我们能只需要集成一个很小的 SDK 就可以共享使用 X5 内核了，不得不说腾讯还是很有想法的。
使用 WebView 的时候，不在 XML 里面声明，而是在代码中直接 new 出来，传入 application context 来防止 activity 引用被滥用。

https://mp.weixin.qq.com/s/vxkAIfQrFkjrStG59RuRbg
https://juejin.im/post/5d0110a6f265da1b80203eb2
