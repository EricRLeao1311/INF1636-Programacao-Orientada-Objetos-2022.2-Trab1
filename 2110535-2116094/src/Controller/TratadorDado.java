package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.API;
import View.JanelaDeJogo;

public class TratadorDado implements ActionListener {

	JanelaDeJogo c;
	
	public TratadorDado(JanelaDeJogo c) {
		this.c = c;
	}
	public void actionPerformed(ActionEvent e) {
		 Controladora.setDado1(API.jogaDado());
		 Controladora.setDado2(API.jogaDado());
		 c.attQtdPassos();
		 c.botaoSalvarAtivado(false);
		 c.botaoDadoAtivado(false);
		 c.repaint();
	 }
	
}
