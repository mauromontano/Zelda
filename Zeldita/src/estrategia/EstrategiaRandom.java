package estrategia;

import juego.*;
import personajes.*;

/**
 * Estrategia que realiza el movimiento de los enemigos 
 * de manera aleatoria
 * @author mauro
 *
 */

public class EstrategiaRandom extends EstrategiaEnemigo{
	
	public EstrategiaRandom (Enemigo enemigo, ManejadorLista a) {
		this.miEnemigo = enemigo; 
		this.tabla = Celdas.getinstance();
		this.actualizador = a; 
	}
	
	public boolean mover() {
		if(miEnemigo.getvida()==0)
			return true;
		else {
			pos_x_enemigo = miEnemigo.getx();
			pos_y_enemigo = miEnemigo.gety();
			moverEje();
			
			if(generar_numero()==5);
			crearDisparo(azar4());
		}
		return false;
	}
	
	private void moverEje() {
		int num = azar2();
		if (num==1)
			moverX();
		else
			moverY();
	}
	
	private void moverX() {
		boolean move_izq = ! (tabla.estaLibre(pos_x_enemigo - 20, pos_y_enemigo));
		boolean move_der = ! (tabla.estaLibre(pos_x_enemigo + 20, pos_y_enemigo));
		boolean memovi = false;
		
		int num = azar2();
		if(!memovi && move_der &&num==0) {
			mover_der();
			memovi=true;
		}
		if(!memovi && move_izq && num==1) {
			mover_izq();
			memovi=true;
		}
	}
	
	private void moverY() {
		boolean memovi = false;
		boolean move_arriba = ! (tabla.estaLibre(pos_x_enemigo, pos_y_enemigo + 20));
		boolean move_abajo =  ! (tabla.estaLibre(pos_x_enemigo, pos_y_enemigo - 20));
		//Analizo si me puedo mover para algun lado
		
		int num = azar2();
		if (!memovi && move_abajo && num==0) {
			mover_abajo();
			memovi=true;
		}
		if(!memovi && move_arriba && num==1) {
			mover_arriba();
			memovi=true;
		}
	}
}
