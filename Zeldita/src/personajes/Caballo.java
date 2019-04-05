package personajes;



import estrategia.EstrategiaRandom;
import juego.ManejadorLista;
import visitor.*;

public class Caballo extends Enemigo{

	public Caballo (int posx, int posy, Jugador jugador,ManejadorLista actualizador){
		this.posx = posx;
		this.posy = posy;
		this.imagen = "/archivos/caballo.png";
		this.alcancedisparo = 5;
		v = new VisitorEnemigo(this);
		inteligencia = new EstrategiaRandom(this,actualizador);
		this.jugador = jugador;
		this.vida=100;
	}
	
	@Override
	public boolean mover() {
		return inteligencia.mover();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

}
