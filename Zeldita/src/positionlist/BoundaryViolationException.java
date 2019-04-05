package positionlist;

@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception {

	public BoundaryViolationException(String mensaje) {
		super(mensaje);
	}
}
