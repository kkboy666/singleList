package List;

import List.dulList.Node;

public class singleList {
	public Node head ;// ����ͷ�ڵ�
	private int length = 0;
	
	public singleList() {// ���췽������ͷ�ڵ�head����
		this.head = null;
	}
	
	class Node{
			int data;//�ڵ�����
			Node next;//ָ����һ���ڵ�
		public Node(int data) {//���췽������data��ֵ
			this.data = data;
		}
	}
	/*
	 * ���ͷ�ڵ�
	 */
	//public void addHeadNode(int data) {
		//Node node = new Node(data);
		//node.next = head;
		//head = node;
	//}
	/*
	 *��ӽڵ� 
	 */
	
	public void addNode(int data){
		Node temp = new Node(data);
		if(head==null){//�ж��Ƿ�Ϊ��һ���ڵ�
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
	 * ���뵽ָ��λ��
	 */
	public void addNodeindex(int index,int data) {
		if(index < 1 && index > length+1  ) {//�жϲ���λ��		
			System.out.println("����λ�ô���");
			return;
		}
		Node node = new Node(data);
		Node temp = head;
		for(int i=0;i<=length;i++) {
		
			if(i==index) {	//�����½ڵ�
				node.next = temp.next;
				temp.next = node;
				length += 1;//�����ȼ�1
			}
	}
		temp = temp.next;
		
	}
	/**
	 * ɾ��ָ���ڵ�
	 */
	public void delNode(int index) {
		if(index < 1||index > length) {
			System.out.print("ָ���ڵ㲻����");
			return;
		}
		Node temp = head;
		for(int i=1;i<=length;i++) {
			if(i == index-1) {
				temp.next = temp.next.next;//ʹǰһ���ڵ�ָ����һ���ڵ�
				length -= 1;  //�����ȼ�һ
				return;
			}
			temp = temp.next;
		}
	
		
	}
	/**
	 * ���������ð������
	 */
	public void bubbleSortNode() {
		if(length < 2) {
			System.out.print("��ǰ������������");
			return;
		}
		//ð������
		Node temp1 = head;
		Node temp2 = null;
		for(int i=0;i<length-1;i++) {
			temp2 = temp1.next;
			for(int j=0;j<length-i-1;j++) {
				if(temp1.data > temp2.data) {
					//���������ڵ�����ֵ
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
	 * �������ѡ������
	 */
	public void selectSort() {
		if(length < 2) {
			System.out.print("�ڵ���������");
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
	 * ��ӡ���
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
			System.out.print("��ǰ������������");
			return;
		}
		Node temp = head;
		Node temp1 = head.next; 
		Node temp2 = new Node(1);//�����ڵ�
		temp2.next = head;
		
		for(int i=1;i<length;i++) {
				if(temp.data > temp1.data) {
					temp.next = temp1.next; //��Ҫ����Ľ����������Ƴ�
					
					Node temp4 = temp2;
					Node temp3 = temp2.next;
					//Node  
					while(temp1.data > temp3.data ) {
						temp4 = temp3;
						temp3 = temp3.next;
					}
					temp4.next= temp1;
					temp1.next = temp3;
					temp1 = temp.next;//ָ����һ��������Ľ�㡣
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
		System.out.print("��������"+"\n");
		list.printNode();
		System.out.print("ָ�����һ���ڵ�"+"\n");
		list.addNodeindex(2, 6);
		list.printNode();
		System.out.print("ð������"+"\n");
		list.bubbleSortNode();
		list.printNode();
		System.out.print("ѡ������"+"\n");
		list.selectSort();
		list.printNode();
		System.out.print("ָ��ɾ��һ���ڵ�"+"\n");
		list.delNode(4);
		list.printNode();
	}
}

		
		
		
		
		
		
	
