package disparo;

import visitor.*;

public class DisparoJugador extends Disparo {

	public DisparoJugador(int posx, int posy, int cantidadmovimientos, String dirmovimiento) {
		this.cantMovimientos = cantidadmovimientos; 
		this.posx = posx;
		this.posy = posy;
		this.imagen ="/archivos/balaJug.png";
		this.dirmovimiento = dirmovimiento;
		this.vida=100;
		this.v = new VisitorDisparoJugador(this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	
}
