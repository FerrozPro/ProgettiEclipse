package it.ferroz.tinylib.interfaces;

import it.ferroz.tinylib.NotFoundException;

public interface MySequence<U> extends MyIterable<U> {
	int size();

	U getAt(int position) throws NotFoundException;

}
