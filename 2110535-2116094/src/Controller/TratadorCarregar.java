package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import Model.API;
import View.JanelaAcusa;
import View.JanelaDeJogo;
import View.JanelaInicial;
import View.JanelaJogadores;


public class TratadorCarregar implements ActionListener{
	JanelaInicial c;
	 public TratadorCarregar(JanelaInicial janelaInicial) {
		 c=janelaInicial;
		 }
	 public void actionPerformed(ActionEvent e) {
		 boolean t = false;
		 try {
			t = API.carregaJogo();
		} catch (IOException e1) {
		}
		if(t) {
			 JFrame janela = new JanelaDeJogo();
			 c.setVisible(false);
		}
	 }
}