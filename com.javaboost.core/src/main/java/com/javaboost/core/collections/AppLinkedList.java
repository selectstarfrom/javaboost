package com.javaboost.core.collections;

/**
 * Created by s726346 on 16/01/2017.
 */
public class AppLinkedList {

	public static void main(String[] args) {

		XLinkedList lLinkedList = new XLinkedList();
		lLinkedList.add(1);
		lLinkedList.add(2);
		lLinkedList.add(3);
		lLinkedList.add(4);
		lLinkedList.add(5);

		System.out.println(lLinkedList.toString());

	}
}

class XLinkedList {
	
	private Node head;

	public boolean add(int pData) {

		Node lLastNode = null;
		Node lNewNode = null;
		
		if (isEmpty()) {
			lNewNode = new Node(pData, null);
			this.head = lNewNode;
		} else {
			lLastNode = getLastNode();
			lNewNode = new Node(pData, lLastNode);
		}
		System.out.println("Added New:" + lNewNode + "----Last Node:" + lLastNode);
		return true;
	}

	private Node getLastNode() {

		if (isEmpty()) {
			return null;
		} else {
			Node lCurrent = getFirst();
			Node lNext = lCurrent;
			while (lNext != null) {
				lCurrent = lNext;
				lNext = lCurrent.getNext();
			}
			return lCurrent;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node getFirst() {
		return head;
	}

	public Node next() {
		return head;
	}

	@Override
	public String toString() {

		String lValue = "[";
		Node lNext = getFirst();
		lValue = lValue.concat(",").concat(lNext.getData() + "");
		while (lNext.hasNext()) {
			int lData = lNext.getNext().getData();
			lValue = lValue.concat(",").concat(lData + "");
			lNext = lNext.getNext();
		}
		lValue = lValue.replaceFirst(",", "").concat("]");
		return lValue;
	}
}

class Node {
	private Node next;
	private int data;

	public Node(int pData, Node pLast) {

		this.data = pData;
		if (pLast != null) {
			pLast.setNext(this);
		}
	}

	public Node getNext() {

		return next;
	}

	public void setNext(Node pNext) {

		next = pNext;
	}

	public int getData() {

		return data;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public String toString() {

		return "Node{" + "next=" + next + ", data=" + data + '}';
	}
}
