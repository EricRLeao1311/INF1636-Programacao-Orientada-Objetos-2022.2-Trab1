package Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.API;
import View.*;


public class TratadorAcusa implements ActionListener{
	 Component c;
	 Component t;
	 public TratadorAcusa(Component x, Component y) {
		 c=x;
		 t=y;
		 }
	 public void actionPerformed(ActionEvent e) {
		 if(Controladora.acusa()) {
			 JFrame JanelaDeAviso = new JanelaFimdeJogo(c,API.getNomeJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())) +" ganhou!");
		 }
		 else {
			 JFrame JanelaDeAviso = new JanelaDeAviso(("Você foi eliminado!"));
		 }
		 if(API.Terminado()) {
			 JFrame JanelaDeAviso = new JanelaFimdeJogo(c, "Não existem vencedores");
		 }
		 else{
			 t.setVisible(false);
			 t.repaint();
			 JanelaDeJogo janela = (JanelaDeJogo)c;
			 janela.botaoProximoAtivado(true);
			 janela.clickProximo();
			 janela.repaint();
		 }
	 }
}