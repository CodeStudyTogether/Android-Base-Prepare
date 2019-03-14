null安全性
它可以让编译器系统地标记潜在的空指针解引用，避免运行时错误。

字符串插值
就好像String.format()这个语言内置了一个更智能，更可读的Java版本：val x = 4 
val y = 7 
print（“$ x和$ y之和为$ {x + y}”）// 4和7之和为11

智能的类型推断和类型转换类型转换Kotlin会智能推断你的类型：val a =“abc”//类型推断为String 
val b = 4 //类型推断为Int 

val c：Double = 0.7 //显式声明
val d：List <String> = ArrayList

if（obj is String）{ 
    print（obj.toUpperCase（））// obj现在已知是一个String 
}

直观的等式没有了equals()和==的混淆：val john1 =Person（“John”）
val john2 =Person（“John”）
john1 == john2 // true（结构相等）
john1 === john2 // false（引用相等）

没有更多的分号
为什么分号在Java中是必需的？没有分号可以更快的编写代码。

没有new关键字
省去你不要的代码。

默认参数
不需要用不同的参数定义几个类似的方法：fun doSomething（title：String，width：Int = 800，height：Int = 600）{ 

}

Lambdas
超级简洁：val sum = { x: Int, y: Int -> x + y }   // type: (Int, Int) -> Int
val res = sum(4,7)                      // res == 11

扩展函数
允许将方法添加到类中，而无需修改其源代码。这意味着再也不用写utils了。

视图绑定
在Android开发中最常见和无聊的操作之一是findViewById。虽然有像ButterKnife这样的其他选择可以改善这种体验，但可以在Kotlin中使用Kotlin Android Extension避免它。//在XML中      
<button> 
//然后在Java中，不需要查找按钮的id或创建对象loginBtn.setText（“Something Else”）//注意按钮的id在这里使用
</ button >

The Data Class
数据类的出现，告别了 get() set() 等模版代码：Java example：public class UserModel {
    private int userId;
    private String firstName;
    private String lastName;
    private String address;
    public UserModel() {
    }
    public UserModel(int userId, String firstName, String lastName, String address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}Kotlin example：data class UserModel(var userId:Int, var firstName: String, var lastName: String, var address: String)是不是超级简洁？
协程 
因为是实验性质的，所以不多说。
