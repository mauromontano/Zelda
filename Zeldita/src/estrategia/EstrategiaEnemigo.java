package estrategia;


import disparo.Disparo;
import disparo.DisparoEnemigo;
import juego.*;
import personajes.*;

public abstract class EstrategiaEnemigo {
	
	protected Enemigo miEnemigo;
	protected Celdas tabla ;
	protected int pos_x_jugador, pos_y_jugador, pos_x_enemigo, pos_y_enemigo;
	protected ManejadorLista actualizador; 
	
	// Metodo abstracto que cada estrategia implementara
	public abstract boolean mover() ;
	
	
	// Metodo que genera numero random entre 0 y 1
	protected int azar2() {

		return (int) (Math.random()*2);
	}
	
	
	//Metodo que genera numero random entre 1 y 5
	protected int azar4() {
		
		return (int) (Math.random()*4) +1 ;
	}
	
	
	//Metodo que genera numero entre 1 y 29
	protected int generar_numero() {
		return (int) (Math.random() * 28) + 1;
	}
	
	
	// Metodos de mover hacia X lugar
	
	protected void mover_arriba() {
		miEnemigo.sety(pos_y_enemigo + 20);
		tabla.setValor(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setValor(true, pos_x_enemigo/20, (pos_y_enemigo + 20) /20);
	}
	protected void mover_abajo() {
		miEnemigo.sety(pos_y_enemigo - 20);
		tabla.setValor(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setValor(true, pos_x_enemigo/20, (pos_y_enemigo - 20) /20);
	}
	protected void mover_der() {
		miEnemigo.setx(pos_x_enemigo + 20);
		tabla.setValor(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setValor(true, (pos_x_enemigo + 20) / 20, pos_y_enemigo / 20 );
	}

	protected void mover_izq() {
		miEnemigo.setx(pos_x_enemigo - 20);
		tabla.setValor(false, pos_x_enemigo/20, pos_y_enemigo/20);
		tabla.setValor(true, (pos_x_enemigo - 20) / 20, pos_y_enemigo / 20 );
	}
	
	
	// Metodo que genera un disparo dependiendo la direccion que reciba por par
	
	protected void crearDisparo(int i) {
		Disparo d = null;
		if(i==1)
			d = new DisparoEnemigo(miEnemigo.getx(), miEnemigo.gety()-20, miEnemigo.getAlcance(), "arriba");
		if (i==2) 
			d = new DisparoEnemigo(miEnemigo.getx(),miEnemigo.gety()+20, miEnemigo.getAlcance(), "abajo");
		if (i==3) 
			d = new DisparoEnemigo(miEnemigo.getx()+20, miEnemigo.gety(), miEnemigo.getAlcance(), "derecha");
		if (i==4)
			d = new DisparoEnemigo(miEnemigo.getx()-20, miEnemigo.gety()-20, miEnemigo.getAlcance(), "izquierda");
		actualizador.agregarDisparo(d);
	}
}