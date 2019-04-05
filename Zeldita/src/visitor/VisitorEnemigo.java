package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import personajes.*;
import obstaculo.Obstaculo;

public class VisitorEnemigo implements Visitor{

	private Enemigo propio;
	
	public VisitorEnemigo (Enemigo propio) {
		this.propio = propio; 
	}
	
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitar(Jugador jugador) {
		jugador.setvida(0);
		this.propio.setvida(0);
	}

	@Override
	public void visitar(DisparoJugador disparojugador) {
		propio.setvida(0);
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
