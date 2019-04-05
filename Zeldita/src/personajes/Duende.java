package personajes;

import estrategia.*;
import juego.*;
import visitor.*;
public class Duende extends Enemigo {
	private boolean bandera;
	private Jugador jugador;
	private ManejadorLista actualizador;
	
	public Duende (int posx, int posy, Jugador jugador,ManejadorLista actualizador){
		this.posx = posx;
		this.posy = posy;
		this.imagen = "/archivos/duende.png";
		this.alcancedisparo = 5;
		v = new VisitorEnemigo(this);
		this.jugador = jugador;
		this.actualizador = actualizador; 
		this.vida=100;
		bandera = false;
	}
	
	public void aceptar (Visitor v) {
		v.visitar(this);
	}

	@Override
	public boolean mover() {
		if (!bandera) {
			this.inteligencia = new EstrategiaRandom(this, actualizador);
			bandera = true;
		}
		if(bandera) {
			this.inteligencia = new EstrategiaAsistida (jugador, this, actualizador);
			bandera = false;
		}
		return inteligencia.mover();
	}
	
}
