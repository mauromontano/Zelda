package positionlist;

@SuppressWarnings("serial")
public class InvalidPositionException extends Exception{

	public InvalidPositionException(String mensaje){
		super(mensaje );
	}
	
	public InvalidPositionException(){
		super("Posicion invalida");
	}
}
