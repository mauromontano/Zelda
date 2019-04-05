package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import personajes.*;
import obstaculo.Obstaculo;

public class VisitorJugador implements Visitor{
	private Jugador jugador;
	
	public VisitorJugador (Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void visitar(Obstaculo obstaculo) {
	}

	@Override
	public void visitar(Duende duende) {
		duende.setvida(0);
		this.jugador.setvida(0);
	}

	@Override
	public void visitar(DisparoEnemigo disparoenemigo) {
		disparoenemigo.setvida(0);
		this.jugador.setvida(0);
	}


	@Override
	public void visitar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(DisparoJugador disparojugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Dragon dragones) {
		dragones.setvida(0);
		this.jugador.setvida(0);
	}

	@Override
	public void visitar(Caballo caballo) {
		caballo.setvida(0);
		jugador.setvida(0);
	}

}
