package positionlist;

/**
 * @author Almaraz Fabricio, Quiruga Luciano.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> list; // Lista a iterar
	protected Position<E> cursor; // Posici�n del elemento corriente
	
	
	/**
	 * Constructor de la clase.
	 * @param l, el par�metro l recibe una lista.
	 */
	public ElementIterator(PositionList<E> l) {
		list = l;
		if(list.isEmpty())
			cursor = null;
		else
			try {
				cursor = list.first();
			} catch (EmptyListException e) {
				System.out.println("e: "+e.getMessage());
			}
	}
	
	
	/**
	 * Consulta si tengo un elemento en la posici�n actual.
	 * @return Devuelve verdadero si hay elemento en la posici�n actual, de lo contrario devuelve falso.
	 */
	public boolean hasNext() {
		return cursor != null;
	}
	
	
	/**
	 * Consulta por el elemento perteneciente a la posici�n actual y mueve el cursor a la posici�n siguiente.
	 * @return Devuelve el elemento perteneciente a la posici�n actual.
	 */
	public E next() throws NoSuchElementException {
		if(cursor == null)
			throw new NoSuchElementException("No tiene siguiente");
		
		E toReturn = cursor.element();
		
		try {
			cursor = (cursor == list.last())? null: list.next(cursor);
		} catch (EmptyListException e) {
			System.out.println("e: "+e.getMessage());
		} catch (InvalidPositionException e) {
			System.out.println("e: "+e.getMessage());
		} catch (BoundaryViolationException e) {
			System.out.println("e: "+e.getMessage());
		}
		return toReturn;
	}
	
}