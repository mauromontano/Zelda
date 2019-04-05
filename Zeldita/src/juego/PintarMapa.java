package juego;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import personajes.*;
import positionlist.*;


@SuppressWarnings("serial")
public class PintarMapa extends JPanel { 
	
	private PositionList<ObjetoJuego> lista;
	
	private boolean ganaste;
	
	public PintarMapa(Jugador jugador, PositionList<ObjetoJuego> lista) {
		
		this.lista = lista;
		this.ganaste=false;
	}

	public void setganaste() {
		ganaste = true;
	}
	
	/**
	 * Metodo que pinta todo con los componentes
	 */
	public void paint(Graphics g){
		super.paint(g);
		if(!ganaste) {
			ImageIcon icono= new ImageIcon(this.getClass().getResource("/archivos/grass.png"));
			Image imagen = icono.getImage();
			g.drawImage(imagen, 0, 0, 600,600, this);
		
			for (Position<ObjetoJuego> p : lista.positions()) {
				ImageIcon i= new ImageIcon(this.getClass().getResource(p.element().getImagen()));
				Image imag= i.getImage();
				g.drawImage(imag, p.element().getx(), p.element().gety(), 20,20, this);
			}
		}
		else {
			ImageIcon icono= new ImageIcon(this.getClass().getResource("/archivos/win.png"));
			Image imagen = icono.getImage();
			g.drawImage(imagen, 0, 0, 600,600, this);
		}
	}
	
	public void paintJugador() {
		repaint();
	}
}