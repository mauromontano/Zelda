package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import personajes.*;
import obstaculo.Obstaculo;

public class VisitorDisparoJugador implements Visitor{
	
	private DisparoJugador propio;
	
	public VisitorDisparoJugador (DisparoJugador propio) {
		this.propio = propio;
	}
	
	@Override
	public void visitar(Obstaculo obstaculo) {
		propio.setvida(0);
	}

	@Override
	public void visitar(Duende duende) {
		duende.setvida(duende.getvida()-100);
		propio.setvida(0);
	}

	@Override
	public void visitar(DisparoEnemigo disparoenemigo) {
		disparoenemigo.setvida(0);
		this.propio.setvida(0);
		
	}


	@Override
	public void visitar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(DisparoJugador disparojugador) {
		
	}

	@Override
	public void visitar(Dragon dragones) {
		dragones.setvida(0);
		propio.setvida(0);
	}

	@Override
	public void visitar(Caballo caballo) {
		caballo.setvida(0);
		propio.setvida(0);
	}

}
