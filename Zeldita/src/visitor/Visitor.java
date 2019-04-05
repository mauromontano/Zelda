package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import personajes.*;
import obstaculo.Obstaculo;

public interface Visitor {

	public abstract void visitar(Obstaculo obstaculo);
	public abstract void visitar(Duende duende);
	public abstract void visitar(DisparoEnemigo disparoenemigo);
	public abstract void visitar(Jugador jugador);
	public abstract void visitar(DisparoJugador disparojugador);
	public abstract void visitar(Dragon dragones);
	public abstract void visitar(Caballo caballo);

}
