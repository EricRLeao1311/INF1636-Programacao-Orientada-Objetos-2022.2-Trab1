package Controller;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.API;
import View.*;


public class TratadorBloco implements ActionListener{
	 Component c;
	
	 public TratadorBloco(Component x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		 JFrame janela = new JanelaBloco();
	 }
}