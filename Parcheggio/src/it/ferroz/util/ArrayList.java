package it.ferroz.util;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {

	private Integer length;

	private Node<E> head;

	public ArrayList() {
		this.length = 0;
	}

	public Integer getLength() {
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		return getLength() == 0;
	}

	@Override
	public void add(E elem) {
		if (head != null) {
			Node<E> aux = head;
			while (aux.hasNext()) {
				aux = aux.getNext();
			}
			aux.setNext(new Node<E>(elem, aux.getPosition() + 1));
		} else {
			head = new Node<E>(elem, 0);
		}
		this.length++;
	}

	@Override
	public void addAll(List<E> list) {
		for (E elem : list) {
			add(elem);
		}
	}

	@Override
	public E getHead() {
		return findElemByPosition(0);
	}

	@Override
	public E getTail() {
		return findElemByPosition(length);
	}

	@Override
	public E findElemByPosition(Integer position) {
		Node<E> aux = head;
		while (--position != 0) {
			aux = aux.getNext();
		}
		return aux.getValue();
	}

	@Override
	public void remove(Integer position) throws Exception{
		if (position > length) {
			throw new IndexOutOfBoundException();
		}else {
			Node<E> aux = head;
			while (--position != 1) {
				aux = aux.getNext();
			}
			aux.setNext(aux.getNext().getNext());
			length--;
		}
	}

	@Override
	public Integer size() {
		return length;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		// ?????????????
		Iterator<E> iterator = new Iterator<E>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return null;
	}

}
