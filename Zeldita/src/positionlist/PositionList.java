package positionlist;

import java.util.Iterator;


public interface PositionList<E> extends Iterable<E> {

	/**
	   * Consulta por el tamaño de la lista.
	   * @return Devuelve el tamaño de la lista.
	   */
	public int size();
	
	/**
	   * Consulta si la lista esta vacia.
	   * @return Devuelve verdadero si el tamaño de la lista es 0, de lo contrario devuelve falso.
	   */
	public boolean isEmpty();
	
	/**
	   * Consulta por la primer posición de la lista.
	   * @return Devuelve la posición del primer elemento de la lista.
	   */
	public Position<E> first() throws EmptyListException;
	
	/**
	   * Consulta por la ultima posición de la lista.
	   * @return Devuelve la posición del ultimo elemento de la lista.
	   */
	public Position<E> last() throws EmptyListException;;
	
	/**
	   * Consulta por la posición siguiente a la pasada por parámetro.
	   * @param p, el parámetro p recibe una posición.
	   * @return Devuelve la posición siguiente a la recibida por parámetro.
	   */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	   * Consulta por la posición anterior a la pasada por parámetro.
	   * @param p, el parámetro p recibe una posición.
	   * @return Devuelve la posición anterior a la recibida por parámetro.
	   */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	  * Inserta el elemento pasado por parámetro en la primera posición de la lista.
	  * @param element, el parámetro element recibe el elemento que insertaremos en la lista.
	  */
	public void addFirst(E element);
	
	/**
	   * Inserta el elemento pasado por parámetro en la utlima posición de la lista.
	   * @param element, el parámetro element recibe el elemento que insertaremos en la lista. 
	   */
	public void addLast(E element);
	
	/**
	   * Inserta el elemento pasado por parámetro en la posición siguiente a la pasada por parámetro.
	   * @param p, el parámetro p recibe una posición.
	   * @param element, el parámetro element recibe el elemento que insertaremos en la lista.
	   */
	public void addAfter(Position<E> p, E element) throws InvalidPositionException;
	
	/**
	   * Inserta el elemento pasado por parámetro en la posición anterior a la pasada por parámetro.
	   * @param p, el parámetro p recibe una posición.
	   * @param element, el parámetro element recibe el elemento que insertaremos en la lista.
	   */
	public void addBefore(Position<E> p, E element) throws InvalidPositionException;
	
	/**
	   * Remueve de la lista a la posición pasada por parámetro.
	   * @param p, el parametro p recibe una posición.
	   * @return Devuelve el elemento perteneciente a la posición removida.
	   */
	public E remove(Position<E> p) throws InvalidPositionException;

	/**
	   * Establece un nuevo elemento a la posición pasada por parámetro.
	   * @param p, el párametro p recibe una posición.
	   * @param element, el párametro element recibe un elemento.
	   * @return Devuelve elemento perteneciente a la posición recibida por parámetro. 
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
