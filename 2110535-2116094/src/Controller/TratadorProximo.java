package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Model.API;
import View.JanelaDeJogo;

public class TratadorProximo implements ActionListener{
	
	JanelaDeJogo c;
	public TratadorProximo(JanelaDeJogo c) {
		this.c = c;
	}
	public void actionPerformed(ActionEvent e) {
		c.botaoDadoAtivado(true);
		c.botaoProximoAtivado(false);
		c.botaoPalpiteAtivado(false);
		c.botaoPassagemAtivado(false);
		c.botaoSalvarAtivado(true);
		Controladora.passaRodada();
		if((API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))) != null){
			c.botaoPalpiteAtivado(true);
			API.setComodoAcusado(API.getNomeComodo(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))));
			if (API.checaPassagem(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))) && !Controladora.getAndou()) {
				c.botaoPassagemAtivado(true);
			}
		}
		c.repaint();
	}

}
