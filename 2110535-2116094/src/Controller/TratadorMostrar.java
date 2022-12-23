package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.API;
import View.JanelaAcusa;
import View.JanelaDeJogo;
import View.JanelaMostraCartas;

public class TratadorMostrar implements ActionListener {

	String c;

	public void actionPerformed(ActionEvent e) {
		 JFrame janela = new JanelaMostraCartas(Controladora.imagemCartas((API.getJogadorStr(Controladora.getRodada() % API.getQtdJogadores())))); 
	 }
	
}
