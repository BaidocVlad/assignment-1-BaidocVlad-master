package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class ButtonListsner implements ActionListener{

	private JLabel label;
	private JTextField text;
	
	public ButtonListsner(JLabel label, JTextField text){
		this.label = label;
		this.text = text;		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		label.setText(text.getText());
		
	}

}

