package positionlist;

import java.util.Iterator;

public class List<E> implements PositionList<E>{

	
	protected Nodo<E> header;
	protected Nodo<E> trailer;
	protected int size;
	
	public List() {
		header = new Nodo<E>(null,null,null);
		trailer = new Nodo<E>(null,header,null);
		header.setNext(trailer);
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Position<E> first() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("First: Lista vacia");
		return header.getNext();
	}
	
	public Position<E> last() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("Last: Lista vacia");
		return trailer.getPrev();
	}
	
	public Position<E> next(Position<E>  p) throws BoundaryViolationException, InvalidPositionException{
		Nodo<E> nodo = checkPosition(p);
		if(nodo.getNext() == trailer)
			throw new BoundaryViolationException("Next: no tiene siguiente");
		return nodo.getNext();
	}
	
	public Position<E> prev(Position<E> p) throws BoundaryViolationException, InvalidPositionException{
		Nodo<E> nodo = checkPosition(p);
		if(nodo.getPrev() == header)
			throw new BoundaryViolationException("prev: cai de la lista");
		return nodo.getPrev();
	}
	
	public void addFirst(E element) {
		Nodo<E> nuevo = new Nodo<E>(element,header,header.getNext());
		header.getNext().setPrev(nuevo);
		header.setNext(nuevo);
		size++;
	}
	
	public void addLast(E element) {
		Nodo<E> nuevo = new Nodo<E>(element,trailer.getPrev(),trailer);
		trailer.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		size++;
	}
	
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException{
		if(isEmpty())
			throw new InvalidPositionException("addAfter: la lista esta vacia");
		Nodo<E> pos = checkPosition(p);
		Nodo<E> nuevo = new Nodo<E>(elem,pos,pos.getNext());
		pos.getNext().setPrev(nuevo);
		pos.setNext(nuevo);
		size++;		
	}
	
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException{
		if(isEmpty())
			throw new InvalidPositionException("addBefore: lista vacia");
		Nodo<E> pos = checkPosition(p);
		Nodo<E> nuevo = new Nodo<E>(elem,pos.getPrev(),pos);
		pos.getPrev().setNext(nuevo);
		pos.setPrev(nuevo);
		size++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		if(p == null || isEmpty())
			throw new InvalidPositionException("remove: posicion invalida");
		Nodo<E> nodo = checkPosition(p);	
		nodo.getNext().setPrev(nodo.getPrev());
		nodo.getPrev().setNext(nodo.getNext());
		nodo.setNext(null);
		nodo.setPrev(null);
		size--;
		return nodo.element();
	}
	
	public E set(Position<E> p, E element) throws InvalidPositionException{
		if(isEmpty())
			throw new InvalidPositionException("set: lista vacia");
		Nodo<E> nodo = checkPosition(p);
		E aux = nodo.element();
		nodo.setElement(element);
		return aux;
	}
	
	private Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if(p == null || p == trailer || p == header)
			throw new InvalidPositionException("checkPosition: Posicion invalida");
		try {
			Nodo<E> n = (Nodo<E>) p;
			return n;			
		}catch(ClassCastException e) {
			throw new InvalidPositionException("checkPosition: error casteo");
		}
	}

	public Iterator<E> iterator() {
	    return (Iterator<E>) new ElementIterator<E>(this);
	  }

	public Iterable<Position<E>> positions() {
	    PositionList<Position<E>> toret = new List<Position<E>>();
	    if (!isEmpty()) {
	      try {
	        Position<E> recorro = first();
	        while (recorro != last()) {
	          toret.addLast(recorro);
	          recorro = next(recorro);
	        }
	        toret.addLast(recorro);
	      } catch (InvalidPositionException|BoundaryViolationException|EmptyListException e) {
	        e.printStackTrace();
	      }
	    }
	    return toret;
	  }

}