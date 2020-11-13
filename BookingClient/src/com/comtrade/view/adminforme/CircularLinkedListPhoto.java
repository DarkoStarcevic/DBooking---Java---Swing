package com.comtrade.view.adminforme;


import java.util.List;


public class CircularLinkedListPhoto<Photo> implements Iterable<Photo> {
	
    private List<Photo>list;
    
    
	
	public CircularLinkedListPhoto(List<Photo> list) {
		super();
		this.list = list;
	}
	
	public IteratorLinkedList<Photo>iterator() {
		
		return new IteratorLinkedList<Photo>() {
			int pos = -1;

			@Override
			public boolean hasNext() {
				
				return !list.isEmpty();
			}

			@Override
			public Photo next() {
				pos = nextIndex();
				return list.get(pos);
			}

			@Override
			public boolean hasPrevious() {
				
				return !list.isEmpty();
			}

			@Override
			public Photo previous() {
				
				pos = previousIndex();
				return list.get(pos);
			}

			@Override
			public int nextIndex() {
				
				if(pos == list.size()-1) {
					return pos = 0;
				}else {
					return pos+1;
				}
			}

			@Override
			public int previousIndex() {
				
				if(pos <= 0) {
					return pos = list.size() - 1;
				}else {
					return pos-1;
				}
			}

			@Override
			public int getPosition() {
				return (int) list.get(pos);
			}
		}; 
			
			
		}
	}




