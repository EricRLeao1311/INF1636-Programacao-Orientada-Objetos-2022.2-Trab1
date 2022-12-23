package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaMostraCartas extends JFrame {
	ArrayList<String> cartaImagens;
	String cartaImagem;
	public JanelaMostraCartas(ArrayList<String> cartaImagens){
		super("Suas Cartas");
		this.cartaImagens = cartaImagens;
		setResizable(false);
		JPanel newp = new JPanel() {
			 @Override
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        Image carta;
			        int x=0;
			        int y=0;
			        String cartaAntiga = null;
					try {
						for(String cartaAtual:cartaImagens) {
							if (cartaAntiga != null && cartaAtual.equals(cartaAntiga)) {
								break;
							}
							carta = ImageIO.read(new File("src/View/" + cartaAtual));
							g.drawImage(carta,200 + x, 20+y, 180, 290, null); 
							x+= 250;
							if (x==750) {y+=300;x=0;}
							cartaAntiga = String.valueOf(cartaAtual);
						}
					}
					catch(IOException e){
						System.out.println(e.getMessage());
						System.exit(1);
					}
			    }
			
		};
		newp.setLayout(null);
		newp.setBackground(Color.BLACK);
		newp.setPreferredSize(new Dimension(400,500));
		newp.setBackground(Color.LIGHT_GRAY);
		add (newp);
		setLocationRelativeTo(null);
		setBounds(0,0,1200,700);
		setVisible(true);
	}
	
	public JanelaMostraCartas(String cartaImagem, String titulo){
		super(titulo);
		this.cartaImagem = cartaImagem;
		
		JPanel newp = new JPanel() {
			 @Override
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        Image carta;
			        int x=0;
			        int y=0;
					try {
							carta = ImageIO.read(new File("src/View/" + cartaImagem));
							g.drawImage(carta,50, 20, 180, 290, null); 
							
					}
					
					catch(IOException e){
						System.out.println(e.getMessage());
						System.exit(1);
					}
			    }
		};
		newp.setLayout(null);
		newp.setBackground(Color.BLACK);
		newp.setPreferredSize(new Dimension(400,500));
		newp.setBackground(Color.LIGHT_GRAY);
		add (newp);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(0,0,500,500);
		setVisible(true);
	}
	
//	API.setEliminado(API.getJogador(rodada % API.getQtdJogadores()));
}
