package obstaculo;


import visitor.VisitorObstaculo;

public class Roca extends Obstaculo{

	
	public Roca (int posx, int posy){
		
		this.posx = posx;
		this.posy = posy;
		this.imagen = "/archivos/roca.png";
		this.v= new VisitorObstaculo();
		this.vida=100;
	}
}
