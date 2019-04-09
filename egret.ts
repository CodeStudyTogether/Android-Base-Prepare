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
