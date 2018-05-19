package it.ferroz.util;

import java.util.Iterator;

public class OrderedList<E> implements List<E> {

	private Node<E> head;

	private Integer lenght;

	public OrderedList() {
		this.lenght = 0;
	}

	public Integer getLenght() {
		return lenght;
	}

	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean add(E elem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(E elem, Integer position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addAll(List<E> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getHead() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getTail() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E findElemByPosition(Integer position) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer position) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return null;
	}

}
