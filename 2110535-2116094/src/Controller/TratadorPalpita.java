package Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.API;
import Model.Selecionado;
import View.*;


public class TratadorPalpita implements ActionListener{
	 Component c;
	 JanelaDeJogo d;
	 public TratadorPalpita(Component x, JanelaDeJogo test) {
		 c=x;
		 d = test;
		 }
	 public void actionPerformed(ActionEvent e) {
		 String carta = Controladora.palpita();
		 API.entraComodo(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()), API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())));
		 API.PuxaComodo(API.getJogadorWithString(API.suspeitoAcusado), API.getComodoWithString(API.comodoAcusado));
		 JFrame JanelaDeAviso;
		 if (carta == null)
			 JanelaDeAviso = new JanelaDeAviso("Nenhuma carta encontrada");
		 else {
			 JanelaDeAviso = new JanelaMostraCartas(Controladora.imagemCarta(carta), "Carta Encontrada!");
		 API.getJogadorBloco(Controladora.getRodada() % API.getQtdJogadores()).set(API.idCarta(carta), Selecionado.SELECIONADOJOGO);
		 }
		d.botaoProximoAtivado(true);
		 c.setVisible(false);
		 c.repaint();
	 }
}