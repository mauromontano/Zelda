package personajes;

import visitor.*;
public abstract class ObjetoJuego {
	
	protected String imagen;
	protected int posx;
	protected int posy;
	protected Visitor v;
	protected int vida;
	
	public void setvida (int i) {
		vida=i;
	}
	
	public int getvida() {
		return vida;
	}
	
	public Visitor getvisitador() {
		return v;
	}
	
	public abstract void aceptar (Visitor v);
	
	public String getImagen(){
		return imagen;
	}
	
	public boolean iguales(ObjetoJuego e) {
		return (( e.getx() == posx) && (e.gety()==posy));
	}
	
	public int getx() {
		return posx;
	}
	
	public int gety() {
		return posy;
	}
	
	public void setx(int x) {
		posx = x;
	}
	
	public void sety(int y) {
		posy= y;
	}

	public abstract boolean mover();
}
