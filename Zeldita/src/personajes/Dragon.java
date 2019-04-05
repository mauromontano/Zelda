package personajes;



import estrategia.*;
import juego.*;
import visitor.*;

public class Dragon extends Enemigo{
	
	public Dragon (int posx, int posy, Jugador jugador,ManejadorLista actualizador){
		this.posx = posx;
		this.posy = posy;
		this.imagen = "/archivos/dragon.png";
		this.alcancedisparo = 10;
		v = new VisitorEnemigo(this);
		inteligencia = new EstrategiaRandom(this,actualizador);
		this.vida=100;
	}
	
	public void aceptar (Visitor v) {
		v.visitar(this);
	}

	@Override
	public boolean mover() {
		return inteligencia.mover();
	}
	
}
