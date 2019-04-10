https://wangdoc.com/javascript/basic/introduction.html

https://ts.xcatliu.com/introduction/get-typescript.html

表达式不需要分号结尾。一旦在表达式后面添加分号，则 JavaScript 引擎就将表达式视为语句，这样会产生一些没有任何意义的语句。

var a = 1;

undefined是一个特殊的值，表示“无定义”。

JavaScript 是一种动态类型语言，也就是说，变量的类型没有限制，变量可以随时更改类型。

if (m === 0) {
  // ...
} else if (m === 1) {
  
数值（number）：整数和小数（比如1和3.14）
字符串（string）：文本（比如Hello World）。
布尔值（boolean）：表示真伪的两个特殊值，即true（真）和false（假）
undefined：表示“未定义”或不存在，即由于目前没有定义，所以此处暂时没有任何值
null：表示空值，即此处的值为空。
对象（object）：各种值组成的集合。

https://wangdoc.com/javascript/types/null-undefined-boolean.html
https://ts.xcatliu.com/introduction/get-typescript.html

变量a分别被赋值为undefined和null，这两种写法的效果几乎等价。

在if语句中，它们都会被自动转为false，相等运算符（==）甚至直接报告两者相等。
  
var print = function(s) {
  console.log(s);
};
  
函数参数如果是原始类型的值（数值、字符串、布尔值），传递方式是传值传递（passes by value）。这意味着，在函数体内修改参数值，不会影响到函数外部。

外层函数每次运行，都会生成一个新的闭包，而这个闭包又会保留外层函数的内部变量，所以内存消耗很大。因此不能滥用闭包，否则会造成网页的性能问题。

https://wangdoc.com/javascript/types/array.html
  
https://ts.xcatliu.com/introduction/get-typescript.html

指数运算符：x ** y
  
简单说，它们的区别是相等运算符（==）比较两个值是否相等，严格相等运算符（===）比较它们是否为“同一个值”。如果两个值不是同一类型，严格相等运算符（===）直接返回false，而相等运算符（==）会将它们转换成同一个类型，再用严格相等运算符进行比较。
  
EvalError 对象
eval函数没有被正确执行时，会抛出EvalError错误。该错误类型已经不再使用了，只是为了保证与以前代码兼容，才继续保留。

JavaScript 最大的语法缺点，可能就是全局变量对于任何一个代码块，都是可读可写。这对代码的模块化和重复使用，非常不利。

因此，建议避免使用全局变量。如果不得不使用，可以考虑用大写字母表示变量名，这样更容易看出这是全局变量，比如UPPER_CASE。

JavaScript 原生提供Object对象（注意起首的O是大写），本章介绍该对象原生的各种方法。

JavaScript 的所有其他对象都继承自Object对象，即那些对象都是Object的实例。

JavaScript 提供了一个内部数据结构，用来描述对象的属性，控制它的行为，比如该属性是否可写、可遍历等等。这个内部数据结构称为“属性描述对象”（attributes object）。每个属性都有自己对应的属性描述对象，保存该属性的一些元信息。

writable

writable是一个布尔值，表示属性值（value）是否可改变（即是否可写），默认为true。

enumerable是一个布尔值，表示该属性是否可遍历，默认为true。如果设为false，会使得某些操作（比如for...in循环、Object.keys()）跳过该属性。

Array是 JavaScript 的原生对象，同时也是一个构造函数，可以用它生成新的数组。

三种原始类型的值——数值、字符串、布尔值——在一定条件下，也会自动转为对象，也就是原始类型的“包装对象”。

包装对象的最大目的，首先是使得 JavaScript 的对象涵盖所有的值，其次使得原始类型的值可以方便地调用某些方法。

Math.E：常数e。
  
（1）全局环境

全局环境使用this，它指的就是顶层对象window。

（1）全局环境

全局环境使用this，它指的就是顶层对象window。

大部分面向对象的编程语言，都是通过“类”（class）实现对象的继承。传统上，JavaScript 语言的继承不通过 class，而是通过“原型对象”（prototype）实现，本章介绍 JavaScript 的原型链继承。

单线程模型指的是，JavaScript 只在一个线程上运行。也就是说，JavaScript 同时只能执行一个任务，其他任务都必须在后面排队等待。

注意，JavaScript 只在一个线程上运行，不代表 JavaScript 引擎只有一个线程。事实上，JavaScript 引擎有多个线程，单个脚本只能在一个线程上运行（称为主线程），其他线程都是在后台配合。

Promise 对象是 JavaScript 的异步操作解决方案，为异步操作提供统一接口。它起到代理作用（proxy），充当异步操作与回调函数之间的中介，使得异步操作具备同步操作的接口。Promise 可以让异步操作写起来，就像在写同步操作的流程，而不必一层层地嵌套回调函数。

DOM 是 JavaScript 操作网页的接口，全称为“文档对象模型”（Document Object Model）。它的作用是将网页转为一个 JavaScript 对象，从而可以用脚本进行各种操作（比如增删内容）。

JavaScript 是浏览器的内置脚本语言。也就是说，浏览器内置了 JavaScript 引擎，并且提供各种接口，让 JavaScript 脚本可以控制浏览器的各种功能。一旦网页内嵌了 JavaScript 脚本，浏览器加载网页，就会去执行脚本，从而达到操作浏览器的目的，实现网页的各种动态效果。

Cookie 是服务器保存在浏览器的一小段文本信息，每个 Cookie 的大小一般不能超过4KB。浏览器每次向服务器发出请求，就会自动附上这段信息。

客户端储存应该使用 Web storage API 和 IndexedDB。

1995年，同源政策由 Netscape 公司引入浏览器。目前，所有浏览器都实行这个政策。

TypeScript 最大的优势便是增强了编辑器和 IDE 的功能，包括代码补全、接口提示、跳转到定义、重构等。

主流的编辑器都支持 TypeScript，这里我推荐使用 Visual Studio Code。

它是一款开源，跨终端的轻量级编辑器，内置了 TypeScript 支持。

另外它本身也是用 TypeScript 编写的。

TypeScript 只会进行静态检查，如果发现有错误，编译的时候就会报错。

TypeScript 编译的时候即使报错了，还是会生成编译结果，我们仍然可以使用这个编译之后的文件。

如果要在报错的时候终止 js 文件的生成，可以在 tsconfig.json 中配置 noEmitOnError 即可。关于 tsconfig.json
  
如果定义的时候没有赋值，不管之后有没有赋值，都会被推断成 any 类型而完全不被类型检查：

目前 TypeScript 的代码检查主要有两个方案：使用 TSLint 或使用 ESLint + typescript-eslint-parser。
  
JavaScript是前端开发的核心语言，但是这门语言天生就存在很多的问题，比如变量提升，不支持类型认证，难以理解的面向对象。

接口的概念，是之前的JavaScript不具备的，它代表了一个类，必须对某些属性或者方法进行实现。

TypeScript也在积极拥抱ES6的变化，它的发展也在根据JavaScript的语法的演变而进化。
