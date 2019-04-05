package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import disparo.Disparo;
import disparo.DisparoJugador;
import personajes.*;

public class InteligenciaJugador implements KeyListener {
	
	private Jugador jugador;
	private Celdas tabla;
	private PintarMapa p;
	private boolean pausado;
	private ManejadorLista actualizador;
	private String direccion;
	
	public InteligenciaJugador(Jugador jugador) {
		this.jugador = jugador;
		tabla = Celdas.getinstance();
		direccion = "arriba";
		pausado = false;
	}

	public void keyPressed(KeyEvent e) {
		if (!pausado) {
			if(KeyEvent.VK_LEFT == e.getKeyCode()) {
				if (!tabla.estaLibre(jugador.getx()-20,jugador.gety())) {
					mover_izq();
					direccion = "izquierda";
				}
			}
			if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
				if (!tabla.estaLibre(jugador.getx()+20,jugador.gety())) {
					mover_der();
					direccion = "derecha";
				}
			}
			if(KeyEvent.VK_SPACE == e.getKeyCode()) {
				generar_disparo();
			}
			if(KeyEvent.VK_UP == e.getKeyCode()) {
				if (!tabla.estaLibre(jugador.getx(),jugador.gety()-20)) {
					mover_arriba();
					direccion = "arriba";
				}
			}
			if(KeyEvent.VK_DOWN == e.getKeyCode()) {
				if (!tabla.estaLibre(jugador.getx(),jugador.gety()+20)) {
					mover_abajo();
					direccion = "abajo";
				}
			}
		}
	}
	
	protected void generar_disparo () { 
		Disparo d = null;
		if(direccion == "arriba")
			d = new DisparoJugador(jugador.getx(), jugador.gety()-20, jugador.getAlcance(), "arriba");
		if(direccion == "abajo")
			d = new DisparoJugador(jugador.getx(), jugador.gety()+20, jugador.getAlcance(), "abajo");
		if(direccion == "derecha")
				d = new DisparoJugador(jugador.getx()+20, jugador.gety(), jugador.getAlcance(), "derecha");
		if(direccion == "izquierda")
					d = new DisparoJugador(jugador.getx()-20, jugador.gety(), jugador.getAlcance(), "izquierda");
		
		actualizador.agregarDisparo(d);
	}
	
	public void setactualizador (ManejadorLista actualizador) {
		this.actualizador = actualizador;
	}

	public void setPanel(PintarMapa p) {
		this.p = p;
	}
	
	private void mover_arriba() {
		tabla.setValor(false, jugador.getx(), jugador.gety());
		jugador.sety(jugador.gety()-20);
		tabla.setValor(true, jugador.getx(), jugador.gety());
		
		jugador.setRutaArriba();
		p.paintJugador();
	}
	private void mover_abajo() {
		tabla.setValor(false, jugador.getx(), jugador.gety());
		jugador.sety(jugador.gety()+20);
		tabla.setValor(true, jugador.getx(), jugador.gety());
		
		jugador.setRutaAbajo();
		p.paintJugador();
	}
	private void mover_der() {
		tabla.setValor(false, jugador.getx(), jugador.gety());
		jugador.setx(jugador.getx()+20);
		tabla.setValor(true, jugador.getx(), jugador.gety());
		
		jugador.setRutaDerecha();
		p.paintJugador();

	}

	private void mover_izq() {
		tabla.setValor(false, jugador.getx(), jugador.gety());
		jugador.setx(jugador.getx()-20);
		tabla.setValor(true, jugador.getx(), jugador.gety());
		
		jugador.setRutaIzquierda();
		p.paintJugador();

	}

	public void pause(boolean b) {
		pausado = b; 
	}

	
	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}
	
	
	public static void main(String[] args){
		new GUI();
		}
	
}