package List;

import List.dulList.Node;

public class singleList {
	public Node head ;// 声明头节点
	private int length = 0;
	
	public singleList() {// 构造方法，给头节点head赋空
		this.head = null;
	}
	
	class Node{
			int data;//节点数据
			Node next;//指向下一个节点
		public Node(int data) {//构造方法，给data赋值
			this.data = data;
		}
	}
	/*
	 * 添加头节点
	 */
	//public void addHeadNode(int data) {
		//Node node = new Node(data);
		//node.next = head;
		//head = node;
	//}
	/*
	 *添加节点 
	 */
	
	public void addNode(int data){
		Node temp = new Node(data);
		if(head==null){//判断是否为第一个节点
			head=temp;
			length++;
			return;
		}
		Node temp1=head;
		while(temp1.next!=null)
			temp1=temp1.next;
		temp1.next =temp;
		length++;
	}

	/*
	 * 插入到指定位置
	 */
	public void addNodeindex(int index,int data) {
		if(index < 1 && index > length+1  ) {//判断插入位置		
			System.out.println("插入位置错误");
			return;
		}
		Node node = new Node(data);
		Node temp = head;
		for(int i=0;i<=length;i++) {
		
			if(i==index) {	//插入新节点
				node.next = temp.next;
				temp.next = node;
				length += 1;//链表长度加1
			}
	}
		temp = temp.next;
		
	}
	/**
	 * 删除指定节点
	 */
	public void delNode(int index) {
		if(index < 1||index > length) {
			System.out.print("指定节点不存在");
			return;
		}
		Node temp = head;
		for(int i=1;i<=length;i++) {
			if(i == index-1) {
				temp.next = temp.next.next;//使前一个节点指向下一个节点
				length -= 1;  //链表长度减一
				return;
			}
			temp = temp.next;
		}
	
		
	}
	/**
	 * 对链表进行冒泡排序
	 */
	public void bubbleSortNode() {
		if(length < 2) {
			System.out.print("当前链表无需排序");
			return;
		}
		//冒泡排序
		Node temp1 = head;
		Node temp2 = null;
		for(int i=0;i<length-1;i++) {
			temp2 = temp1.next;
			for(int j=0;j<length-i-1;j++) {
				if(temp1.data > temp2.data) {
					//交换两个节点数据值
					int temp = temp1.data;
					temp1.data = temp2.data;
					temp2.data = temp;
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
	}
	
	/**
	 * 单链表的选择排序
	 */
	public void selectSort() {
		if(length < 2) {
			System.out.print("节点少于两个");
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			Node secondTemp = temp.next;
			while(secondTemp != null) {
				if(temp.data < secondTemp.data) {
					int constantTemp = secondTemp.data;
					secondTemp.data = temp.data;
					temp.data = constantTemp;
				}
				secondTemp = secondTemp.next;
			}
			temp = temp.next;
		}
	}
	/*
	 * 打印输出
	 */
	public void printNode() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+"\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	/*
	 * public void insertSort() {
		if(length<2) {
			System.out.print("当前链表无需排序");
			return;
		}
		Node temp = head;
		Node temp1 = head.next; 
		Node temp2 = new Node(1);//辅助节点
		temp2.next = head;
		
		for(int i=1;i<length;i++) {
				if(temp.data > temp1.data) {
					temp.next = temp1.next; //将要插入的结点从链表中移除
					
					Node temp4 = temp2;
					Node temp3 = temp2.next;
					//Node  
					while(temp1.data > temp3.data ) {
						temp4 = temp3;
						temp3 = temp3.next;
					}
					temp4.next= temp1;
					temp1.next = temp3;
					temp1 = temp.next;//指向下一个带插入的结点。
				}else {
					temp = temp.next;
					temp1 = temp1.next;
				}
		}
	}
	
	 */
	public static void main(String args[]) {
		singleList list = new singleList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(4);
		list.addNode(1);
		list.addNode(2);
		System.out.print("链表数据"+"\n");
		list.printNode();
		System.out.print("指定添加一个节点"+"\n");
		list.addNodeindex(2, 6);
		list.printNode();
		System.out.print("冒泡排序"+"\n");
		list.bubbleSortNode();
		list.printNode();
		System.out.print("选择排序"+"\n");
		list.selectSort();
		list.printNode();
		System.out.print("指定删除一个节点"+"\n");
		list.delNode(4);
		list.printNode();
	}
}

		
		
		
		
		
		
	
