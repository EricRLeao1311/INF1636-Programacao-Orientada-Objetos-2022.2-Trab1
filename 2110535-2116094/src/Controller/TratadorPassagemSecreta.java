package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.API;
import View.JanelaDeJogo;
import View.JanelaMostraCartas;

public class TratadorPassagemSecreta implements ActionListener {

	JanelaDeJogo c;

	public TratadorPassagemSecreta(JanelaDeJogo x) {
		c=x;
	}

	public void actionPerformed(ActionEvent e) {
		if(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())) == null) {
			return;
		}
		if(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())).equals(API.getComodoWithString("Sala de Estar"))) {
			API.PuxaComodo(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()), API.getComodoWithString("Jardim de Inverno"));
		}
		else if(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())).equals(API.getComodoWithString("Jardim de Inverno")))
			API.PuxaComodo(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()), API.getComodoWithString("Sala de Estar"));
		else if(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())).equals(API.getComodoWithString("Cozinha")))
			API.PuxaComodo(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()), API.getComodoWithString("Escritório"));
		else if(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())).equals(API.getComodoWithString("Escritório")))
			API.PuxaComodo(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()), API.getComodoWithString("Cozinha"));
		c.botaoDadoAtivado(false);
		c.botaoPassagemAtivado(false);
		c.repaint();
	 }
	
}
