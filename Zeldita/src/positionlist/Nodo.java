package positionlist;

/**
  * @author Almaraz Fabricio, Quiruga Luciano.
  */


public class Nodo<E> implements Position<E> {

	 private Nodo<E> next;
	 private Nodo<E> prev;
	 private E element;
	 
	 /**
	  * Constructor de la clase
	  * @param e, el p�rametro e recibe el elemento que pertenecer� al nodo actual.
	  * @param p, el p�rametro p recibe el nodo previo al actual.
	  * @param n, el p�rametro n recibe el nodo siguiente al actual.
	  */
	 public Nodo(E e, Nodo<E> p, Nodo<E> n) {
		 element = e;
		 setPrev(p);
		 setNext(n);
	 }
	 
	 
	/**
	 * Constructor de la clase sin parametros.
	 * asigna null a las variables pertenecientes a la clase actual.
	 */
	 public Nodo() {
		 this(null,null,null);
	 }

	 
	/**
	 * Consulta por el elemento perteneciente al nodo actual.
	 * @return Devuelve el elemento del nodo actual.
	 */
	public E element() {
		return element;
	}
	
	
	/**
	 * Establece un elemento al nodo actual.
	 * @param e, el p�rametro e recibe un elemento.
	 */
	public void setElement(E e) {
		element = e;
	}

	
	/**
	 * Consulta por el nodo siguiente al actual.
	 * @return Devuelve al nodo siguiente al actual.
	 */
	public Nodo<E> getNext() {
		return next;
	}

	
	/**
	 * Establece un nodo siguiente al actual.
	 * @param next, el par�metro next recibe un nodo.  
	 */
	public void setNext(Nodo<E> next) {
		this.next = next;
	}

	
	/**
	 * Consulta por el nodo anterior al actual.
	 * @return Devuelve el nodo anterior al actual.
	 */
	public Nodo<E> getPrev() {
		return prev;
	}

	
	/**
	 * Establece el nodo anterior al actual.
	 * @param prev, el par�metro prev recibe un nodo.
	 */
	public void setPrev(Nodo<E> prev) {
		this.prev = prev;
	}
	 
	

}
