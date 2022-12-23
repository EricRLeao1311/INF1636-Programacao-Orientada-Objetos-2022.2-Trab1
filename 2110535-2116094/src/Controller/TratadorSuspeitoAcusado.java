package Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.API;
import View.*;


public class TratadorSuspeitoAcusado implements ActionListener{
	 Component c;
	 public TratadorSuspeitoAcusado(Component x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		 JRadioButton button = (JRadioButton) e.getSource();
		 API.setPersonagemAcusado(button.getText());
	 }
}