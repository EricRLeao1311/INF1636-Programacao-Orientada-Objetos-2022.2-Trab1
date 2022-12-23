package View;

import java.awt.Color;
import javax.swing.*;
import Controller.TratadorAviso;

public class JanelaDeAviso extends JFrame {
	public JanelaDeAviso(String aviso){
		super("Aviso");
		setResizable(false);
		JPanel newp = new JPanel();
		JButton ok = new JButton("OK");
		ok.addActionListener(new TratadorAviso(this));
		JLabel textoAviso = new JLabel(aviso, SwingConstants.CENTER);
		textoAviso.setBounds(-10, 20, 300, 50);
		ok.setBounds(90, 100, 100, 50);
		newp.setLayout(null);
		newp.add(ok);
		newp.add(textoAviso);
		add (newp);
		setLocationRelativeTo(null);
		setBounds(340,180,300,200);
		setVisible(true);
	}
	
//	API.setEliminado(API.getJogador(rodada % API.getQtdJogadores()));
}