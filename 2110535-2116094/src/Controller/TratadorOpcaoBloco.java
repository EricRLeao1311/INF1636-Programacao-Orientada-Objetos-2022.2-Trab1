package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import Model.API;
import Model.Selecionado;

public class TratadorOpcaoBloco implements ActionListener{
	 JCheckBox opcao;
	 Integer index;
	 ArrayList<Selecionado> blocoDeNotas;
	 public TratadorOpcaoBloco(Integer index, JCheckBox opcao, ArrayList<Selecionado> blocoDeNotas) {
		this.opcao = opcao;
		this.index = index;
		this.blocoDeNotas = blocoDeNotas;
		 }
	 public void actionPerformed(ActionEvent e) {
		if (opcao.isSelected()) {
			blocoDeNotas.set(index, Selecionado.SELECIONADOUSUARIO);
		}
		else {
			blocoDeNotas.set(index, Selecionado.NAOSELECIONADO);
		}
	 }
}