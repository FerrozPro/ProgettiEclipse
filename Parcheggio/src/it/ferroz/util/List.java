package it.ferroz.util;

public interface List<E> extends Iterable<E>{

	public boolean isEmpty();

	public Boolean add(E elem);
	
	public Boolean add(E elem, Integer position);

	public Boolean addAll(List<E> list);

	public E getHead() throws Exception;
	
	public E getTail() throws Exception;

	public E findElemByPosition(Integer position) throws Exception;
	
	public void remove(Integer position) throws Exception;
	
	public Integer size();

}

//Libreria di container: scrivere una libreria di classi generiche per manipolare liste, collection, array, set, mappe ecc. Simile ai package java.util, si tratta di riprodurre l'architettura di interfacce e classi offerte dal JDK per manipolare container. Una  delle sfide maggiori consiste nella definizione di una gerarchia di iteratori, opportunamente generalizzati e parametrizzati, per accedere ai container in modo sicuro.
