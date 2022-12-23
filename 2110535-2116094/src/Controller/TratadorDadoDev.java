package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.API;
import View.JanelaDeJogo;

public class TratadorDadoDev implements ActionListener {

	JanelaDeJogo c;
	
	public TratadorDadoDev(JanelaDeJogo c) {
		this.c = c;
	}
	public void actionPerformed(ActionEvent e) {
		 c.attQtdPassos(c.getDadoDev());
		 c.botaoSalvarAtivado(false);
		 c.botaoDadoAtivado(false);
		 c.repaint();
	 }
	
}
