package juego;

import disparo.Disparo;
import personajes.*;
import positionlist.*;

public class ManejadorLista {

	private PositionList<ObjetoJuego> lista ;
	Jugador jugador;
	
	public ManejadorLista (PositionList<ObjetoJuego> lista, InteligenciaJugador control, Jugador jugador) {
		this.lista = lista; 
		this.jugador = jugador;
	}
	
	public void actualizar_entidades () {
		boolean debo_eliminar = false;
		for(Position<ObjetoJuego> p : lista.positions()) {
			debo_eliminar = p.element().mover();
			if (debo_eliminar) {
						try {
								lista.remove(p);
						} catch (InvalidPositionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
						actualizar_jugador();
			}
		}
		chequear_colisiones();
	}

	
	public void actualizar_jugador() {
		jugador.mover();
	}

	public void chequear_colisiones () {
		for(Position<ObjetoJuego> p : lista.positions()) {
			for(Position<ObjetoJuego> e : lista.positions()) {
				if (p.element().iguales(e.element())) {
					e.element().aceptar(p.element().getvisitador());
				}
			}
		}
	}
	
	public void agregarDisparo(Disparo d) {
		lista.addFirst(d);
	}

	
}
