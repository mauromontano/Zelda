package disparo;

import juego.Celdas;
import personajes.ObjetoJuego;

public abstract class Disparo extends ObjetoJuego{
	
	protected int cantMovimientos;    // Determinara el alcance del disparo
	protected String dirmovimiento;
	protected Celdas tabla;
	
	
	/**
	 * Metodo que determina el movimiento del disparo
	 */
	
	public boolean mover() {
		boolean ret = false;
		if (vida==0)
			ret=true;
		else {
			tabla = Celdas.getinstance(); 
			cantMovimientos--; 
			
			if(dirmovimiento == "arriba" && posy != 0)
				sety(gety()-20);
			else
				if(dirmovimiento == "abajo" && posy+20 != 600)
					sety(gety()+20);
				else
					if(dirmovimiento == "derecha" && posx+20 != 600)
						setx(getx()+20);
					else
						if(dirmovimiento == "izquierda" && posx != 0)
							setx(getx()-20);
						else
							cantMovimientos = 0;
			
			if(cantMovimientos == 0) 
				ret = true;
		}
		return ret;
	}
	
}
