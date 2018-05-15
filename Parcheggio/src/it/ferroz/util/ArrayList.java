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
		// for (E elem : list) {
		// add(elem);
		// }
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			E e = iterator.next();
			add(e);
		}
	}

	@Override
	public E getHead() throws NotFoundException {
		return findElemByPosition(0);
	}

	@Override
	public E getTail() throws NotFoundException {
		return findElemByPosition(length);
	}

	@Override
	public E findElemByPosition(Integer position) throws NotFoundException {
		Node<E> aux = head;
		while (--position != 0) {
			if (aux.hasNext()) {
				aux = aux.getNext();
			} else {
				throw new NotFoundException();
			}
		}
		return aux.getValue();
	}

	@Override
	public void remove(Integer position) throws IndexOutOfBoundException {
		if (position > length) {
			throw new IndexOutOfBoundException();
		} else {
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
		return new Iterator<E>() {

			private Integer position = 0;

			@Override
			public boolean hasNext() {
				return position < size();
			}

			@Override
			public E next() {
				try {
					return findElemByPosition(++position);
				} catch (NotFoundException e) {
					e.printStackTrace();
					throw new RuntimeException("iterator.next() failed");
				}
			}
		};
	}

}
