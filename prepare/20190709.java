/**
	 * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
	 */
	public static Node reverse2(Node head) {
		if (head == null)
			return head;
		Node pre = head;// 上一结点
		Node cur = head.getNext();// 当前结点
		Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
		while (cur != null) {// 当前结点为null，说明位于尾结点
			tmp = cur.getNext();
			cur.setNext(pre);// 反转指针域的指向
 
			// 指针往下移动
			pre = cur;
			cur = tmp;
		}
		// 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
		head.setNext(null);
		
		return pre;
	}


public ListNode ReverseList(ListNode head){
		if(head == null)
			return null;
		ListNode preListNode = null;
		ListNode nowListNode = head;
		
		while(nowListNode != null){
			ListNode nextListNode = nowListNode.next;   //保存下一个结点
			nowListNode.next = preListNode;             //当前结点指向前一个结点
			preListNode = nowListNode;                  //前任结点 到现任节点
			nowListNode = nextListNode;					//现任节点到下一结点
		}
		return preListNode;
	}

https://blog.csdn.net/jsqfengbao/article/details/47187709

MVP模式是一个把view从低层模型分离出来的一种现代模式。MVP由model–view–controller (MVC)软件模式衍生而来，常用于构建UI

MVP中的M（model）代表的是将会显示在view（UI）中的数据。
MVP中的V（view）是显示数据（model）并且将用户指令（events）传送到presenter以便作用于那些数据的一个接口。View通常含有Presenter的引用。

MVP中的P（presenter）扮演的是“中间人”的作用（就如MVC中的controller），且presenter同时引用view和model。值得注意的是，“Model”这个词并不正确。严格意义上来说，它指的应该是检索或控制一个Model的业务逻辑层。举个例子，比如你的数据库里面包含了User，而你的View想要显示一个User列表，那么Presenter会引用数据库中的业务逻辑层（比如DAO）从而查询到一个User列表。如图1-1. 
	
	http://www.apkbus.com/blog-822721-68180.html
MVP模式的三种角色
主要做一些数据处理, 网路请求。Presenter 需要通过 Model 层存取、获取数据，Model是封装了数据库 Dao 层或者网络获取数据的角色，或者两种数据获取方式的集合。
交互中间人，核心逻辑，处理 View 的业务逻辑，沟通 View 和 Model 的桥梁，Presenter 持有的 View、Model 引用都是抽象，它从 Model 层检索数据后返回给 View 层，使得 View 和 Model 没有耦合，也将业务逻辑从 View 层抽取出来，经常会执行耗时操作。
用户界面，Activity、Fragment 或者某个 View 控件，含有一个 Presenter 成员变量，通常 View 层需要实现一个逻辑接口，将 View 上的操作通过会转交给 Presenter 进行实现，最后 Presenter 调用 View 逻辑接口将结果返回给 View 元素。

很多缺乏经验的工程师很可能会将各种各样的业务逻辑塞进某个 Activity、Fragment 或者自定义控件中，使得这些组件的单个类型臃肿不堪。MVP 模式可以让 UI 界面和数据分离，职责单一，易于维护。MVP 模式也并不是一个标准化的模式，它有很多实现方式，我们也可以根据自己的需求和自己认为对的方式去修正 MVP 的实现方式，它可以随着 Presenter 的复杂程度变化。只要保证我们是通过 Presenter 将 View 和 Model 解耦合、降低类型复杂度、各个模块可以独立测试、独立变化，这就是正确的方向。

http://www.apkbus.com/blog-822721-68180.html
