package obstaculo;

import visitor.VisitorObstaculo;

public class Arbol extends Obstaculo{
	
	public Arbol(int posx, int posy){
		this.posx = posx;
		this.posy = posy;
		this.imagen = "/archivos/arbol.png";
		this.v= new VisitorObstaculo();
		this.vida=100;
	}
}