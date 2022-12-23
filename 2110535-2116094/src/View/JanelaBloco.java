package View;

import java.awt.Dimension;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import Controller.Controladora;
import Controller.TratadorAcusa;
import Controller.TratadorOpcaoBloco;
import Model.API;
import Model.Selecionado;


public class JanelaBloco extends JFrame {
	public JanelaBloco(){
		
		
		super("Bloco de Notas");
		ArrayList<Selecionado> blocoDeNotas = API.getJogadorBloco(Controladora.getRodada() % API.getQtdJogadores());
		setResizable(false);
		JCheckBox p1=new JCheckBox(API.getNome(0)); 
		JCheckBox p2=new JCheckBox(API.getNome(1));
		JCheckBox p3=new JCheckBox(API.getNome(2));    
		JCheckBox p4=new JCheckBox(API.getNome(3));
		JCheckBox p5=new JCheckBox(API.getNome(4));    
		JCheckBox p6=new JCheckBox(API.getNome(5));
		p1.setBounds(75,50,200,30);
		p2.setBounds(75,75,200,30);
		p3.setBounds(75,100,200,30);
		p4.setBounds(75,125,200,30);
		p5.setBounds(75,150,200,30);  
		p6.setBounds(75,175,200,30);
		JCheckBox a1=new JCheckBox(API.getArma(0));    
		JCheckBox a2=new JCheckBox(API.getArma(1));
		JCheckBox a3=new JCheckBox(API.getArma(2));    
		JCheckBox a4=new JCheckBox(API.getArma(3));
		JCheckBox a5=new JCheckBox(API.getArma(4));    
		JCheckBox a6=new JCheckBox(API.getArma(5));
		a1.setBounds(275,50,200,30);
		a2.setBounds(275,75,200,30);
		a3.setBounds(275,100,200,30);
		a4.setBounds(275,125,200,30);
		a5.setBounds(275,150,200,30);  
		a6.setBounds(275,175,200,30);  
		JCheckBox c1=new JCheckBox(API.getComodo(0));    
		JCheckBox c2=new JCheckBox(API.getComodo(1));
		JCheckBox c3=new JCheckBox(API.getComodo(2));    
		JCheckBox c4=new JCheckBox(API.getComodo(3));
		JCheckBox c5=new JCheckBox(API.getComodo(4));    
		JCheckBox c6=new JCheckBox(API.getComodo(5));
		JCheckBox c7=new JCheckBox(API.getComodo(6));    
		JCheckBox c8=new JCheckBox(API.getComodo(7));
		JCheckBox c9=new JCheckBox(API.getComodo(8));  
		
		JCheckBox[] opcoesBloco = {p1,p2,p3,p4,p5,p6,a1,a2,a3,a4,a5,a6,c1,c2,c3,c4,c5,c6,c7,c8,c9};
		
		for(int i =0;i<21;i++) {
			opcoesBloco[i].setSelected(false);
			if (blocoDeNotas.get(API.idCarta(opcoesBloco[i].getText())) == Selecionado.SELECIONADOJOGO) {
				opcoesBloco[i].setSelected(true);
//				System.out.println(opcoesBloco[i].getText());
				opcoesBloco[i].setEnabled(false);
			}
			
			else if (blocoDeNotas.get(API.idCarta(opcoesBloco[i].getText())) == Selecionado.SELECIONADOUSUARIO) {
				opcoesBloco[i].doClick();
//				System.out.println(opcoesBloco[i].getText());
			}
			
			opcoesBloco[i].addActionListener(new TratadorOpcaoBloco(i, opcoesBloco[i], blocoDeNotas));
		}
		
		c1.setBounds(475,50,200,30);
		c2.setBounds(475,75,200,30);
		c3.setBounds(475,100,200,30);
		c4.setBounds(475,125,200,30);
		c5.setBounds(475,150,200,30);  
		c6.setBounds(475,175,200,30);
		c7.setBounds(475,200,200,30);  
		c8.setBounds(475,225,200,30); 
		c9.setBounds(475,250,200,30);   

		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
		add(a1);
		add(a2);
		add(a3);
		add(a4);
		add(a5);
		add(a6);
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(c5);
		add(c6);
		add(c7);
		add(c8);
		add(c9);
		JPanel newp = new JPanel();
		newp.setLayout(null);
		newp.setPreferredSize(new Dimension(10,10));
		add (newp);
		setLocationRelativeTo(null);
		setBounds(0,0,700,400);
		setVisible(true);
	}

}
