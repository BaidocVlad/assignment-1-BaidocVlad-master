package presentation;

import javax.swing.JFrame;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import domain.Logic;
import domain.Login;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	public Window() {
		initialize();
		frame.setVisible(true);
		frame.setTitle("LoginWindow");
	}
	
	private JButton btnLogin = new JButton("Login");
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(176, 62, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(176, 116, 86, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin.setBounds(176, 147, 89, 23);
		btnLogin.addActionListener(this);
		frame.getContentPane().add(btnLogin);
		
		Label label = new Label("Username");
		label.setAlignment(Label.CENTER);
		label.setBounds(186, 34, 62, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Password");
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(186, 88, 62, 22);
		frame.getContentPane().add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		Logic logic = new Logic();
		Login login = null;
		login = logic.selectLogin(username, password);
		if (source == btnLogin) {
			if(login.getRol()==1)
			{
				//AdminWindow aw = new AdminWindow();
				AdminWindow.main(null);
				frame.setVisible(false);
			}
			else {
				//ClientWindow cw = new ClientWindow();
				ClientWindow.main(null);
				frame.setVisible(false);
			}
		}
	}
	
	public static void main(String args[]){
		new Window();
	}
}
