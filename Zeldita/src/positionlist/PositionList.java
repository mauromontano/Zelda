package positionlist;

import java.util.Iterator;


public interface PositionList<E> extends Iterable<E> {

	/**
	   * Consulta por el tama�o de la lista.
	   * @return Devuelve el tama�o de la lista.
	   */
	public int size();
	
	/**
	   * Consulta si la lista esta vacia.
	   * @return Devuelve verdadero si el tama�o de la lista es 0, de lo contrario devuelve falso.
	   */
	public boolean isEmpty();
	
	/**
	   * Consulta por la primer posici�n de la lista.
	   * @return Devuelve la posici�n del primer elemento de la lista.
	   */
	public Position<E> first() throws EmptyListException;
	
	/**
	   * Consulta por la ultima posici�n de la lista.
	   * @return Devuelve la posici�n del ultimo elemento de la lista.
	   */
	public Position<E> last() throws EmptyListException;;
	
	/**
	   * Consulta por la posici�n siguiente a la pasada por par�metro.
	   * @param p, el par�metro p recibe una posici�n.
	   * @return Devuelve la posici�n siguiente a la recibida por par�metro.
	   */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	   * Consulta por la posici�n anterior a la pasada por par�metro.
	   * @param p, el par�metro p recibe una posici�n.
	   * @return Devuelve la posici�n anterior a la recibida por par�metro.
	   */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	  * Inserta el elemento pasado por par�metro en la primera posici�n de la lista.
	  * @param element, el par�metro element recibe el elemento que insertaremos en la lista.
	  */
	public void addFirst(E element);
	
	/**
	   * Inserta el elemento pasado por par�metro en la utlima posici�n de la lista.
	   * @param element, el par�metro element recibe el elemento que insertaremos en la lista. 
	   */
	public void addLast(E element);
	
	/**
	   * Inserta el elemento pasado por par�metro en la posici�n siguiente a la pasada por par�metro.
	   * @param p, el par�metro p recibe una posici�n.
	   * @param element, el par�metro element recibe el elemento que insertaremos en la lista.
	   */
	public void addAfter(Position<E> p, E element) throws InvalidPositionException;
	
	/**
	   * Inserta el elemento pasado por par�metro en la posici�n anterior a la pasada por par�metro.
	   * @param p, el par�metro p recibe una posici�n.
	   * @param element, el par�metro element recibe el elemento que insertaremos en la lista.
	   */
	public void addBefore(Position<E> p, E element) throws InvalidPositionException;
	
	/**
	   * Remueve de la lista a la posici�n pasada por par�metro.
	   * @param p, el parametro p recibe una posici�n.
	   * @return Devuelve el elemento perteneciente a la posici�n removida.
	   */
	public E remove(Position<E> p) throws InvalidPositionException;

	/**
	   * Establece un nuevo elemento a la posici�n pasada por par�metro.
	   * @param p, el p�rametro p recibe una posici�n.
	   * @param element, el p�rametro element recibe un elemento.
	   * @return Devuelve elemento perteneciente a la posici�n recibida por par�metro. 
	   */
	public E set(Position<E> p, E element) throws InvalidPositionException;
	
	/**
	   * Consulta 
	   * @return Devuelve un elemento iterabl
	   */
	public Iterator<E> iterator();
	
	/**
	   * Consulta por un 
	   */
	public Iterable<Position<E>> positions();

}
