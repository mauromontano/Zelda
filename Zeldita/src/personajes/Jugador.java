package personajes;

import visitor.*;

public class Jugador extends Personaje {
	private String im_jugando;
	private String im_perder; 
	private String im_derecha; 
	private String im_izquierda; 
	private String im_abajo; 
	
	public Jugador (int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		im_jugando= "/archivos/mario.png";
		im_perder ="";
		
		im_derecha="/archivos/mario_derecha.png";
		im_izquierda="/archivos/mario_izquierda.png";
		im_abajo="/archivos/mario_abajo.png";
		
		
		imagen = im_jugando;
		this.v = new VisitorJugador(this);
		this.vida=100;
		this.alcancedisparo = 5;
	}
	
	public void setRutaPerder () {
		imagen =im_perder;
	}
	
	public void setRutaJugando() {
		imagen = im_jugando ;
	}
	
	public void setRutaDerecha(){
		imagen= im_derecha;
	}
	
	
	public void setRutaIzquierda(){
		imagen= im_izquierda;
	}
	
	public void setRutaAbajo() {
		imagen= im_abajo;
	}
	
	public void setRutaArriba() {
		imagen= im_jugando;
	}
	
	public boolean mover() {
		if (vida==0)
			return true;
		else
			return false;
	}



	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

}
