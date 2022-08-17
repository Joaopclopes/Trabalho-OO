package dama.view;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{

	private JLabel label;
	
	public void iniciar() {
		label = new JLabel();
	}
	
	public PanelImagen() {
		iniciar();
		//47
	    JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "./imagenes/FondoInformacao.png" );
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        imagen.setBounds(100,100,100,520);
        add( imagen );

//		setLayout(new GridLayout(8, 0));
//		JPanel panel = new JPanel();
//		label.setText("                 novo jogo                       ");
//		cambiarlabel('N');
	}
	
//	public void cambiarlabel(char color){
//		
//		if(color == 'R') {
//			label.setText("             vez das vermelhas               ");
//			remove(label);
//		}else if(color == 'N') {
//			label.setText("             vez das pretas             ");
//			remove(label);
//		}
//		
//		add(label);
//	}
//	
}
