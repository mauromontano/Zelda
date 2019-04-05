package juego;

/**
 * Se crea un tablero de 30x30 para saber si cada celda 
 * estara libre u ocupada
 * @author mauro
 *
 */

public class Celdas {
	
	private boolean [][] tablero;
	private static Celdas instancia;
	
	
	private Celdas(){
		tablero = new boolean[30][30];
		for (int i = 0 ; i<30 ; i++) {
			for (int j = 0 ; j<30 ; j++) {
				tablero[i][j] = false;
			}
		}
	}
	public static Celdas getinstance () {
		if (instancia == null) {
			instancia = new Celdas();
		}
		return instancia;
	}
	
	public boolean getValor(int i, int j) {
		return tablero[i][j];
	}
	
	public void setValor(boolean b, int i, int j) {
		if(i>=0 && j>=0 && i<30 && j<30)
			tablero[i][j] = b;
	}
	
	public boolean estaLibre(int i, int j) {
		if (i<0 || j<0 || i>599 || j>599)
			return !false;
		return tablero[i/20][j/20];
	}
}
