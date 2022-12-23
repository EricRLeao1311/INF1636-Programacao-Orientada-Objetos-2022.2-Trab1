package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ItemJogador;
import Controller.TratadorSelecao;
import Controller.TratadorStart;
import Model.API;

public class JanelaJogadores extends JFrame {

	public JanelaJogadores(){
		super("Seleção de Jogadores");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JButton comecarJogo = new JButton("Começar Jogo");
		JPanel newp = new JPanel() {
			 @Override
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        Image personagem;
			        String[] personagens = {"Green.jpg", "Mustard.jpg", "Peacock.jpg", "Plum.jpg", "Scarlet.jpg", "White.jpg"};
			        int x=0;
			        int y=0;
					try {
						for(String pAtual:personagens) {
							personagem = ImageIO.read(new File("src/View/Suspeitos/" + pAtual));
							g.drawImage(personagem,200 + x, 20+y, 180, 290, null); 
							x+= 250;
							if (x==750) {y+=300;x=0;}
							
							
						}
						comecarJogo.setEnabled(((API.getQtdJogadores()>2) ? true : false ));
						
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
		
		/*
		  { "Senhorita Scarlet", "Coronel Mustarda", "Senhorita White","Reverendo Green",
       "Senhorita Peacock", "Professor Plum" }; 
		 */
		
		comecarJogo.addActionListener(new TratadorSelecao(this));
		comecarJogo.setBounds(950, 500, 150, 30);
		
		
		JCheckBox srtaScarlet = new JCheckBox("Senhorita Scarlet");
		srtaScarlet.setBounds(950, 250, 150, 40);
		srtaScarlet.setBackground(Color.RED);
		srtaScarlet.addItemListener(new ItemJogador(0,srtaScarlet,this));
		srtaScarlet.doClick();
		srtaScarlet.setEnabled(false);
		
		JCheckBox corMustarda = new JCheckBox("Coronel Mustarda");
		corMustarda.setBounds(950, 290, 150, 40);
		corMustarda.setBackground(Color.YELLOW);
		corMustarda.addItemListener(new ItemJogador(1,corMustarda,this));
		corMustarda.doClick();
		
		JCheckBox srtaWhite = new JCheckBox("Senhorita White");
		srtaWhite.setBounds(950, 330, 150, 40);
		srtaWhite.setBackground(Color.WHITE);
		srtaWhite.addItemListener(new ItemJogador(2,srtaWhite,this));
		srtaWhite.doClick();
		
		JCheckBox revGreen = new JCheckBox("Reverendo Green");
		revGreen.setBounds(950, 370, 150, 40);
		revGreen.setBackground(Color.GREEN);
		revGreen.addItemListener(new ItemJogador(3,revGreen,this));
		
		JCheckBox srtaPeacock = new JCheckBox("Senhorita Peacock");
		srtaPeacock.setBounds(950, 410, 150, 40);
		srtaPeacock.setBackground(Color.BLUE);
		srtaPeacock.setForeground(Color.WHITE);
		srtaPeacock.addItemListener(new ItemJogador(4,srtaPeacock,this));
		
		JCheckBox profPlum = new JCheckBox("Professor Plum");
		profPlum.setBounds(950, 450, 150, 40);
		profPlum.setBackground(new Color(145, 100, 255));
		profPlum.addItemListener(new ItemJogador(5,profPlum,this));
		
		newp.add(srtaScarlet);
		newp.add(corMustarda);
		newp.add(srtaWhite);
		newp.add(revGreen);
		newp.add(srtaPeacock);
		newp.add(profPlum);
		
		newp.add(comecarJogo);
		newp.setBackground(Color.LIGHT_GRAY);
		add (newp);
		
		setLocationRelativeTo(null);
		setBounds(0,0,1200,700);

		setVisible(true);
	}
	
}
