package disparo;

import visitor.*;

public class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int posx, int posy, int cantidadmovimientos, String dirmovimiento) {
		this.cantMovimientos = cantidadmovimientos; 
		this.posx = posx;
		this.posy = posy;
		this.imagen ="/archivos/balaEnem.png";
		this.dirmovimiento = dirmovimiento;
		this.vida=100;
		this.v = new VisitorDisparoEnemigo(this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}
	

}