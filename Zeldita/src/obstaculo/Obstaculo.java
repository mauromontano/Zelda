package obstaculo;

import personajes.ObjetoJuego;
import visitor.*;

public abstract class Obstaculo extends ObjetoJuego {
	
	

	public boolean mover() {
		return false;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}
}