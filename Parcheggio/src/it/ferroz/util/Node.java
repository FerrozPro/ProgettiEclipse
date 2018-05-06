package it.ferroz.util;

public class Node<E> {
	
	private E value;
	
	private Node<E> next;
	
	private Integer position;
	
	public Node(E value, Integer position){
		this.value = value;
		this.position = position;
	}
	
	public E getValue() {
		return value;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public boolean hasNext() {
		return next != null;
	}
	
}
