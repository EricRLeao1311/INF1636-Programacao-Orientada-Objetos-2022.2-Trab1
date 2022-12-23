package Controller;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Model.API;
import View.JanelaDeJogo;
import View.JanelaJogadores;

public class TratadorRestart implements ActionListener{
	Component c;
	Component t;
	public TratadorRestart(Component c, Component t){
		this.c = c;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		API.restartAPI();
		Controladora.restartControladora();
		c.setVisible(false);
		t.setVisible(false);
		JFrame escolhaJogador = new JanelaJogadores();
	}

}
