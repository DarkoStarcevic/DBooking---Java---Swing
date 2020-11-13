package com.comtrade.view.adminforme;

import java.util.Iterator;



public interface IteratorLinkedList<Photo> extends Iterator<Photo> {
	
	boolean hasPrevious();
	Photo previous(); // moze i current
	int nextIndex();
	int previousIndex();
	int getPosition();

	

	
	

}
