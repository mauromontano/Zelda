package juego;

public class Hilos extends Thread {
	private volatile boolean ejecutar;
	private GUI c;
	private PintarMapa p ;
	private ManejadorLista actualizador; 
	
	public Hilos (PintarMapa p, ManejadorLista m, GUI c) {
		this.c = c; 
		this.p = p; 
		this.actualizador = m;
	}

	public void gameOver() {
		ejecutar = false;
	}
	
	public void run() {
		this.ejecutar = true;
		while(ejecutar) {
			try {
				p.repaint();
				Thread.sleep(500);
				actualizador.actualizar_entidades();
				
				if(c.muerto()) {
					p.repaint(); 
					Thread.sleep(2000);
					c.revivirJugador();
				}
				if (c.ganaste()) {
					c.ganar();
					gameOver();
				}
			}
			catch (InterruptedException e) {
				
			}
		}
	}
	
}
