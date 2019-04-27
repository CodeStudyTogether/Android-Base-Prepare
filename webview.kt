WebView是Android系统提供能显示网页的系统控件，它是一个特殊的View，同时它也是一个ViewGroup可以有很多其他子View。

在Android 4.4以下(不包含4.4)系统WebView底层实现是采用WebKit内核，而在Android 4.4及其以上Google 采用了chromium内核作为系统WebView的底层内核支持。

基于Chromium 的Webview和基于Webkit webview的差异，基于Chromium Webview提供更广的HTML5,CSS3,Javascript支持，在目前最新Android 系统版本5.0上基于chromium 37，Webview提供绝大多数的HTML5特性支持。Webkit JavaScript引起采用WebCore Javascript 在Android 4.4上换成了V8能直接提升JavaScript性能。另外Chromium 支持远程调试(Chrome DevTools)。

                Webkit      Chromium           备注
HTML5            278          434       http://html5test.com
远程调试         不支持         支持       Android 4.4及以上支持
内存占用           小           大           相差20-30M左右
WebAudio        不支持        支持       Android 5.0及以上支持
WebGL           不支持        支持       Android 5.0及以上支持
WebRTC          不支持        支持       Android 5.0及以上支持
