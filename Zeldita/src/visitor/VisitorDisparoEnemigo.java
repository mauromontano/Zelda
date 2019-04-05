package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import obstaculo.Obstaculo;
import personajes.*;

public class VisitorDisparoEnemigo implements Visitor {
	private DisparoEnemigo propio;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d) {
		propio = d;
	}
	
	public void visitar(Obstaculo obstaculo) {
		propio.setvida(0);
	}

	public void visitar(Duende duende) {
		duende.setvida(duende.getvida()-100);
		propio.setvida(0);
	}

	public void visitar(DisparoEnemigo disparoenemigo) {
		
	}

	public void visitar(Jugador jugador) {
		jugador.setvida(jugador.getvida()-20);
		propio.setvida(0);
	}

	@Override
	public void visitar(DisparoJugador disparojugador) {
		disparojugador.setvida(0);
		propio.setvida(0);
	}

	@Override
	public void visitar(Dragon dragones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Caballo caballo) {
		
	}

}
