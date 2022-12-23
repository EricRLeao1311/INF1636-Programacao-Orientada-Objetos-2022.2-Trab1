package View;

import java.awt.Component;

import javax.swing.*;
import Controller.TratadorAviso;
import Controller.TratadorRestart;


	public class JanelaFimdeJogo extends JFrame {
		public JanelaFimdeJogo(Component c, String aviso){
			super("Fim de Jogo");
			setResizable(false);
			JPanel newp = new JPanel();
			JLabel textoAviso = new JLabel(aviso, SwingConstants.CENTER);
			textoAviso.setBounds(-10, 20, 300, 50);
			JButton ok = new JButton("Novo jogo");
			JButton exit = new JButton("Sair");
			ok.addActionListener(new TratadorRestart(c, this));
			ok.setBounds(50, 100, 100, 50);
			exit.setBounds(150, 100, 100, 50);
			newp.setLayout(null);
			newp.add(ok);
			newp.add(exit);
			newp.add(textoAviso);
			add (newp);
			setLocationRelativeTo(null);
			setBounds(340,180,300,200);
			setVisible(true);
		}
		
//		API.setEliminado(API.getJogador(rodada % API.getQtdJogadores()));
	}

