package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import personajes.*;
import obstaculo.Obstaculo;

public class VisitorObstaculo implements Visitor {

	@Override
	public void visitar(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Duende duende) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(DisparoEnemigo disparoenemigo) {
		disparoenemigo.setvida(0);
	}


	@Override
	public void visitar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(DisparoJugador disparojugador) {
		disparojugador.setvida(0);
	}

	@Override
	public void visitar(Dragon dragones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Caballo caballo) {
		// TODO Auto-generated method stub
		
	}


}
