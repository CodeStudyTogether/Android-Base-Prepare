https://juejin.im/post/5a24ec145188254dd9363b81

编码格式统一为 UTF-8；

编辑完 .java、.xml 等文件后一定要 格式化，格式化，格式化（如果团队有公共的样式包，那就遵循它，否则统一使用 AS 默认模板即可）

删除多余的 import，减少警告出现，可利用 AS 的 Optimize Imports（Settings -> Keymap -> Optimize Imports）快捷键；

代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式。正确的英文拼写和语法可以让阅读者易于理解，避免歧义。

注意：即使纯拼音命名方式也要避免采用。但 alibaba、taobao、youku、hangzhou 等国际通用的名称，可视同英文。

包名全部小写，连续的单词只是简单地连接起来，不使用下划线，采用反域名命名规则，全部使用小写字母。一级包名是顶级域名，通常为 com、edu、gov、net、org 等，二级包名为公司名，三级包名根据应用进行命名，后面就是对包名的划分了，关于包名的划分，推荐采用 PBF（按功能分包 Package By Feature）

常量名命名模式为 CONSTANT_CASE，全部字母大写，用下划线分隔单词。
