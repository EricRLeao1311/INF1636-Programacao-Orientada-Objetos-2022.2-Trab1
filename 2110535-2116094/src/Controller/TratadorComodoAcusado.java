package Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.API;
import View.*;


public class TratadorComodoAcusado implements ActionListener{
	 Component c;
	 public TratadorComodoAcusado(Component x) {
		 c=x;
		 }
	 public void actionPerformed(ActionEvent e) {
		 JRadioButton button = (JRadioButton) e.getSource();
		 API.setComodoAcusado(button.getText());
	 }
}