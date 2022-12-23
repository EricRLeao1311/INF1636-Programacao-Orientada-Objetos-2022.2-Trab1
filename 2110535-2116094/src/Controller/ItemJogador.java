package Controller;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import Model.API;

public class ItemJogador implements ItemListener {
	
	int posJogador;
	JCheckBox checkbox;
	Component c;
	
	public ItemJogador(int posJogador, JCheckBox checkbox, Component c) {
		this.posJogador = posJogador;
		this.checkbox = checkbox;
		this.c = c;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		boolean selecionado = (e.getStateChange() == 1);
		
		if (selecionado) {

			API.mudaEscolhido(posJogador, true);
			API.incQtdJogadores(true);
			
		}
		else {
		API.mudaEscolhido(posJogador, false);
		API.incQtdJogadores(false);
			
		}
		
		c.repaint();
		
	}

}
