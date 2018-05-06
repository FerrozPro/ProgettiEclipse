package it.ferroz.util;

public interface List<E> extends Iterable<E>{

	public boolean isEmpty();

	public void add(E elem);

	public void addAll(List<E> list);

	public E getHead();
	
	public E getTail();

	public E findElemByPosition(Integer position);
	
	public void remove(Integer position) throws Exception;
	
	public Integer size();

}
