package estrategia;
import juego.*;
import personajes.*;


/**
 * Estrategia que mueve a los enemigos de manera dirigida
 * hacia el jugador
 * @author mauro
 *
 */


public class EstrategiaAsistida extends EstrategiaEnemigo {
	private Jugador jugador;
	
	public EstrategiaAsistida(Jugador jugador, Enemigo enemigo, ManejadorLista a) {
		this.jugador = jugador; 
		miEnemigo = enemigo;
		this.tabla =Celdas.getinstance();
		this.actualizador = a; 
	}
		
	public boolean mover() {
		if (miEnemigo.getvida()==0)
			return true;
		else {
			pos_x_jugador = jugador.getx();
			pos_y_jugador = jugador.gety();
			pos_x_enemigo = miEnemigo.getx();
			pos_y_enemigo = miEnemigo.gety();
			moverEje();
		
			if(generar_numero()==5)
				crearDisparo(azar4());
		}
		return false;
		
	}
	
	
	// Veo en que eje mover al enemigo si x o y, lo dejo al azar
	
	private void moverEje() {
		int num = azar2();
		
		if (num==1)
			moverX();
		else
			moverY();
	}
	
	private void moverX() {
		
		boolean move_izq , move_der; 
		
		move_izq = ! (tabla.estaLibre(pos_x_enemigo - 20, pos_y_enemigo));
		move_der = ! (tabla.estaLibre(pos_x_enemigo + 20, pos_y_enemigo));
		
		boolean debo_ir_izq = pos_x_enemigo > pos_x_jugador;
		boolean debo_ir_der = pos_x_enemigo < pos_x_jugador;
		
		boolean memovi = false;
		
		//CHEQUEO SI PUEDO MOVERME A DONDE ESTA EL JUGADOR
		if (!memovi && debo_ir_izq && move_izq) {
			mover_izq();
			memovi = true;
		}
		if(!memovi && debo_ir_der && move_der) {
			mover_der();
			memovi = true;
		}
		//CHEQUEO SI PUEDO MOVERME A ALGUN LUGAR
		if(!memovi && move_der) {
			mover_der();
			memovi=true;
		}
		if(!memovi && move_izq) {
			mover_izq();
			memovi=true;
		}
	}
	
	private void moverY() {
		boolean memovi = false;
		boolean move_arriba , move_abajo; 
		move_arriba = ! (tabla.estaLibre(pos_x_enemigo, pos_y_enemigo + 20));
		move_abajo =  ! (tabla.estaLibre(pos_x_enemigo, pos_y_enemigo - 20));
		boolean debo_ir_abajo = pos_y_enemigo > pos_y_jugador;
		boolean debo_ir_arriba = pos_y_enemigo < pos_y_jugador;
		
		//CHEQUEO SI PUEDO MOVERME A DONDE ESTA EL JUGADOR
		if (!memovi && debo_ir_abajo && move_abajo ) {
				mover_abajo();
				memovi = true;
		}
		if (!memovi && debo_ir_arriba && move_arriba) {
			mover_arriba();
			memovi=true;
		}
		//CHEQUEO SI PUEDO MOVERME A ALGUN LUGAR
		if (!memovi && move_abajo) {
			mover_abajo();
			memovi=true;
		}
		if(!memovi && move_arriba) {
			mover_arriba();
			memovi=true;
		}
	}

}