package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.API;
import View.JanelaAcusa;
import View.JanelaDeJogo;


public class TratadorSalvar implements ActionListener{
	JanelaDeJogo c;
	 public TratadorSalvar(JanelaDeJogo x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		 API.salvaJogo();
	 }
}