package juego;


import javax.swing.JFrame;

import obstaculo.Arbol;
import obstaculo.Roca;
import personajes.*;
import positionlist.*;

/**
 * Se realiza la creacion de la Gui y se crean los objetos
 * @author mauro
 *
 */


public class GUI extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	private PintarMapa panel ;
	private Hilos hilo;
	private PositionList<ObjetoJuego> lista ;
	private int cant;
	private Jugador jugador;
	private Celdas tabla;
	private InteligenciaJugador intel;
	private ManejadorLista manejador;
	
	public GUI(){
		iniciar();
	}
	
	private void iniciar() {
		
		cant=0;
		tabla = Celdas.getinstance();
		lista = new List<ObjetoJuego> ();
		crearJugador();
		intel = new InteligenciaJugador(jugador);
		manejador = new ManejadorLista (lista,intel, jugador);
		crearObstaculos();
		crearEnemigos();
		panel = new PintarMapa(jugador,lista);
		setSize(600,626);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		addKeyListener(intel);
		this.add(panel);
		intel.setPanel(panel);
		intel.setactualizador(manejador);
		hilo = new Hilos(panel,manejador,this);
		hilo.run();
	}
	
	
	private void agregar_entabla(int i, int j) { 
		tabla.setValor(true, i/20, j/20);
	}
	
	public boolean muerto() {
		int ret = jugador.getvida();
		if (ret == 0) {
			jugador.setRutaPerder ();
			this.intel.pause(true);
		}
		return ret == 0;
	}
	
	public void revivirJugador() {
		jugador.setvida(100);
		jugador.setRutaJugando();
		int random1 = generar_numero();
		int random2 = generar_numero();
		while (tabla.estaLibre(random1,random2) == true) {
			random1 = generar_numero();
			random2 = generar_numero();
		}
		jugador.setx(random1);
		jugador.sety(random2);
		intel.pause(false);
	}
	
	public boolean ganaste() {
		return (lista.size() == cant);
	}
	
	public void ganar() {
		panel.setganaste();
	}
	
	public void crearJugador () {
		cant++;
		int random1 = generar_numero();
		int random2 = generar_numero();
		while (tabla.estaLibre(random1,random2) == true) {
			random1 = generar_numero();
			random2 = generar_numero();
		}
		jugador = new Jugador(random1,random2);
		lista.addFirst(jugador);
		agregar_entabla(random1,random2);
	}
	
	private void crearObstaculos() {
		
		for (int i = 0 ; i<50 ; i++) {
			
			cant++;
			int random1 = generar_numero();
			int random2 = generar_numero();
			while (tabla.estaLibre(random1,random2) == true) {
				random1 = generar_numero();
				random2 = generar_numero();
			}
			
			int n = moneda_azar();
			
			if(n == 0)
				lista.addFirst(new Roca(random1,random2));
			else
				lista.addFirst(new Arbol (random1,random2));
				
			
		
			agregar_entabla(random1,random2);
		}
		
	}
	
	private int moneda_azar() {
		//Este metodo retorna un 0 o un 1, al azar
		return (int) (Math.random()*2);
	}
	
	private void crearEnemigos () {
		
		// Creo un enemigo del tipo dragon
		
		
				int random1,random2;
				random1 = generar_numero();
				random2 = generar_numero();
				
				while (tabla.estaLibre(random1,random2) == true) {
					random1 = generar_numero();
					random2 = generar_numero();
				}
				lista.addFirst(new Dragon (random1, random2, jugador, manejador));
				agregar_entabla(random1,random2);
		
		
		
		
		
		//Creo un enemigo del tipo duende
			
				random1 = generar_numero();
				random2 = generar_numero();
				
				while (tabla.estaLibre(random1,random2) == true) {
					random1 = generar_numero();
					random2 = generar_numero();
				}
				lista.addFirst(new Duende (random1, random2, jugador, manejador));
				agregar_entabla(random1,random2);
		
		
		
		// Creo un enemigo del tipo caballo
				
		random1 = generar_numero();
		random2 = generar_numero();
		
		while (tabla.estaLibre(random1,random2) == true) {
			random1 = generar_numero();
			random2 = generar_numero();
		}
		lista.addFirst(new Caballo (random1, random2, jugador, manejador));
		agregar_entabla(random1,random2);
		
	}

	private int generar_numero() {
		return (20 * ( (int) (Math.random() * 28) + 1));
	}


}
