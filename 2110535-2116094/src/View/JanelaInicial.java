package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.TratadorCarregar;
import Controller.TratadorStart;

public class JanelaInicial extends JFrame {
	public JanelaInicial(){
		super("Detetive");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel newp = new JPanel() {
			 @Override
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        Image i;
					try {
						i = ImageIO.read(new File("src/View/Tabuleiros/Clue1.jpg"));
						g.drawImage(i,0, 0, 1200, 700, null); 
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
		add (newp);
		setLocationRelativeTo(null);
		setBounds(0,0,1200,700);

		JButton comecar = new JButton("Novo jogo");
		comecar.setBounds(200,270,120,30);
		comecar.addActionListener(new TratadorStart(this));
		newp.add(comecar);
		JButton carregar = new JButton("Carregar jogo");
		carregar.setBounds(200,330,120,30);
		newp.add(carregar);
		carregar.addActionListener(new TratadorCarregar(this));
		setVisible(true);
	}

}
