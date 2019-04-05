package personajes;
import estrategia.*;

public abstract class Enemigo extends Personaje {
	protected Jugador jugador;
	protected EstrategiaEnemigo inteligencia;
	
	public abstract boolean mover() ;
	
	public int getx_jugador() {
		return jugador.getx();
	}
	
	public int gety_jugador() {
		return jugador.gety();
	}
}
