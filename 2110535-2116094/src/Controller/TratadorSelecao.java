package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.API;
import View.JanelaDeJogo;

public class TratadorSelecao implements ActionListener{
	Component c;
	
	public TratadorSelecao(Component c){
		this.c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		API.criaJogadores(API.getQtdJogadores());
		new JanelaDeJogo();
		c.setVisible(false);
		
	}

}
