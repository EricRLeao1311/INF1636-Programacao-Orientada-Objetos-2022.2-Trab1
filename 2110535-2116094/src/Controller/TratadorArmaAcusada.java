package Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.API;
import View.*;


public class TratadorArmaAcusada implements ActionListener{
	 Component c;
	 public TratadorArmaAcusada(Component x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		 JRadioButton button = (JRadioButton) e.getSource();
		 API.setArmamAcusada(button.getText());
	 }
}