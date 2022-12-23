package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import Model.API;

public class TratadorAviso implements ActionListener{
	 Component c;
	 public TratadorAviso(Component x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		c.setVisible(false);
	 }
}