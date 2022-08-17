package dama.view;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel_Imagem extends JPanel{

	private JLabel label;
	
	public void iniciar() {
		label = new JLabel();
	}
	
	public Painel_Imagem() {
		iniciar();
		//47
	    JLabel imagem = new JLabel( );
        ImageIcon icone = new ImageIcon( "./imagenes/Fundo.png" );
        imagem = new JLabel( "" );
        imagem.setIcon(icone );
        imagem.setBounds(100,100,100,520);
        add(imagem );


	}
        
	public void mudar_label(char color){
		
		if(color == 'R') {
			label.setText("             Vez da Vermelha           ");
                        remove(label);

                }else if(color == 'N') {
			label.setText("             Vez das Pretas              ");
			remove(label);
		}
		
		add(label);
	}
	
}
