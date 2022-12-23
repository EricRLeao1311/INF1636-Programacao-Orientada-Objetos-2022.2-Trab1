package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.API;
import View.JanelaAcusa;
import View.JanelaDeJogo;
import View.JanelaPalpita;


public class TratadorPalpitar implements ActionListener{
	JanelaDeJogo c;
	 public TratadorPalpitar(JanelaDeJogo x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		c.botaoPalpiteAtivado(false);
		JFrame janela = new JanelaPalpita(c);
		c.botaoDadoAtivado(false);
		c.botaoPalpiteAtivado(false);
		c.repaint();
	 }
}