package presentation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domain.Client;
import domain.Conturi;
import domain.Logic;
import domain.Tranzactie;

public class AdminWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	
	private JLabel label1 = new JLabel("Client    ");
	private JLabel label2 = new JLabel("Conturi   ");
	
	private JLabel label3 = new JLabel("Nume      ");
	private JLabel label4 = new JLabel("Cnp       ");
	private JLabel label5 = new JLabel("Adresa    ");
	private JLabel label6 = new JLabel("Id_card   ");
	private JLabel label7 = new JLabel("id_login  ");
	
	private JLabel label8 = new JLabel("Id_client ");
	private JLabel label9 = new JLabel("Tip       ");
	private JLabel label10 = new JLabel("Suma      ");
	private JLabel label11 = new JLabel("Data      ");
	
	private JLabel label15 = new JLabel("Raport    ");
	private JLabel label16 = new JLabel("Data_start");
	private JLabel label17 = new JLabel("Data_end  ");
	private JLabel label18 = new JLabel("Id_client ");
	
	private JButton button1 = new JButton("Insert");
	private JButton button2 = new JButton("Select");
	private JButton button3 = new JButton("Update");
	private JButton button4 = new JButton("Delete");
	private JButton button5 = new JButton("Insert");
	private JButton button6 = new JButton("Select");
	private JButton button7 = new JButton("Update");
	private JButton button8 = new JButton("Delete");
	private JButton button9 = new JButton("Raport");

	private JTextField text1 = new JTextField(6);
	private JTextField text2 = new JTextField(6);
	private JTextField text3 = new JTextField(6);
	private JTextField text4 = new JTextField(6);
	private JTextField text5 = new JTextField(6);
	private JTextField text6 = new JTextField(6);
	private JTextField text7 = new JTextField(6);
	private JTextField text8 = new JTextField(6);
	private JTextField text9 = new JTextField(6);
	private JTextField text10 = new JTextField(6);
	private JTextField text11 = new JTextField(6);
	private JTextField text12 = new JTextField(6);
	
	private JTextArea textArea = new JTextArea();
	private JScrollPane textAreaScroll = new JScrollPane(textArea);
 
	
	public AdminWindow() {
		Dimension size = new Dimension(500, 500);
		this.setSize(size);
		this.setPreferredSize(size);
		getContentPane().add(panel);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(label3, c);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(label4, c);
		c.gridx = 3;
		c.gridy = 1;
		panel.add(label5, c);
		c.gridx = 4;
		c.gridy = 1;
		panel.add(label6, c);
		c.gridx = 5;
		c.gridy = 1;
		panel.add(label7, c);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(label1, c);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(text1, c);
		c.gridx = 2;
		c.gridy = 2;
		panel.add(text2, c);
		c.gridx = 3;
		c.gridy = 2;
		panel.add(text3, c);
		c.gridx = 4;
		c.gridy = 2;
		panel.add(text4, c);
		c.gridx = 5;
		c.gridy = 2;
		panel.add(text5, c);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(label8, c);
		c.gridx = 2;
		c.gridy = 3;
		panel.add(label9, c);
		c.gridx = 3;
		c.gridy = 3;
		panel.add(label10, c);
		c.gridx = 4;
		c.gridy = 3;
		panel.add(label11, c);
		c.gridx = 0;
		c.gridy = 4;
		panel.add(label2, c);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(text6, c);
		c.gridx = 2;
		c.gridy = 4;
		panel.add(text7, c);
		c.gridx = 3;
		c.gridy = 4;
		panel.add(text8, c);
		c.gridx = 4;
		c.gridy = 4;
		panel.add(text9, c);
		
		c.gridx = 1;
		c.gridy = 7;
		panel.add(text10, c);
		c.gridx = 2;
		c.gridy = 7;
		panel.add(text11, c);
		c.gridx = 3;
		c.gridy = 7;
		panel.add(text12, c);
		c.gridx = 0;
		c.gridy = 7;
		panel.add(label15, c);
		c.gridx = 2;
		c.gridy = 6;
		panel.add(label16, c);
		c.gridx = 3;
		c.gridy = 6;
		panel.add(label17, c);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(label18, c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel.add(button1, c);
		button1.addActionListener(this);

		c.gridx = 2;
		c.gridy = 0;
		panel.add(button2, c);
		button2.addActionListener(this);

		c.gridx = 3;
		c.gridy = 0;
		panel.add(button3, c);
		button3.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 0;
		panel.add(button4, c);
		button4.addActionListener(this);
		
		c.gridx = 1;
		c.gridy = 5;
		panel.add(button5, c);
		button5.addActionListener(this);
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(button6, c);
		button6.addActionListener(this);

		c.gridx = 3;
		c.gridy = 5;
		panel.add(button7, c);
		button7.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 5;
		panel.add(button8, c);
		button8.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 7;
		panel.add(button9, c);
		button9.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 10;
		textAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textAreaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textAreaScroll.setPreferredSize(new Dimension(300,125));
		panel.add(textAreaScroll,c);
	}
	//insert client
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == button1) {
			
			Logic logic = new Logic();
			Client client = new Client();
			client.setNume(text1.getText());
			client.setAdresa(text3.getText());
			client.setCnp(Integer.parseInt(text2.getText()));
			client.setId_card(Integer.parseInt(text4.getText()));
			client.setId_login(Integer.parseInt(text5.getText()));
			logic.addClient(client);
		}
		
		//insert cont
		if (source == button5) {
			/*int id_client = Integer.parseInt(text6.getText());
			String tip = text7.getText();
	 		int suma = Integer.parseInt(text8.getText());
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date = format.parse(text9.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(date.getTime());
			Logic logic = new Logic();
			logic.addCont(id_client, tip, suma, sql);*/
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date = format.parse(text9.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(date.getTime());
			Logic logic = new Logic();
			Conturi cont = new Conturi();
			////////////casuta id_cont noua
			cont.setId_client(Integer.parseInt(text6.getText()));
			cont.setTip(text7.getText());
			cont.setSuma(Integer.parseInt(text8.getText()));
			cont.setData(sql);
			logic.addCont(cont);
		}
		//select client
		
		if (source == button2) {
			int id_client = Integer.parseInt(text6.getText());
			Logic logic = new Logic();
			List<Client> all = null;
			all = logic.selectClient(id_client);
			textArea.append("Clienti\n");
			for(Client p:all){
				if(p.getId_client() == id_client){
					textArea.append(p.getNume()+" "+p.getCnp()+" "+p.getAdresa()+" "+p.getId_card()+" "+p.getId_login()+"\n");
				}
			}
		}
		
		//select conturi
		if (source == button6) {
			int id_client = Integer.parseInt(text6.getText());
			Logic logic = new Logic();
			Conturi cont = new Conturi();
			cont.setId_client(id_client);
			List<Conturi> all = null;
			all = logic.selectCont(cont);
			textArea.append("Conturi\n");
			for(Conturi p:all){
				if(p.getId_client() == id_client){
					textArea.append(p.getId_cont()+" "+p.getId_client()+" "+p.getTip()+" "+p.getSuma()+" "+p.getData()+"\n");
				}
			}
			//logic.updateClient(id_client, nume, cnp, adresa, id_card, id_login);
			//logic.updateCont(id_cont, id_client, tip, suma, data);
		}
		
		//update client
		if (source == button3) {
			/*String nume = text1.getText();
			int cnp = Integer.parseInt(text2.getText());
			String adresa = text3.getText();
			int id_card = Integer.parseInt(text4.getText());
			int id_login = Integer.parseInt(text5.getText());
			int id_client = Integer.parseInt(text6.getText());*/
			Logic logic = new Logic();
			Client client = new Client();
			client.setId_client(Integer.parseInt(text6.getText()));
			client.setNume(text1.getText());
			client.setAdresa(text3.getText());
			client.setCnp(Integer.parseInt(text2.getText()));
			client.setId_card(Integer.parseInt(text4.getText()));
			client.setId_login(Integer.parseInt(text5.getText()));
			logic.updateClient(client);
		}
		
		//update cont
		if (source == button7) {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date = format.parse(text9.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(date.getTime());
			Logic logic = new Logic();
			Conturi cont = new Conturi();
			/////////////////////////////////////////////////////////////////////////////////////////
			////////////casuta id_cont noua
			/////////////////////////////////////cont.setId_cont(Integer.parseInt(text1.getText()));
			int id_client = Integer.parseInt(text6.getText());
			int id_cont = 0;
			cont.setId_client(id_client);
			List<Conturi> all = null;
			all = logic.selectCont(cont);
			for(Conturi p:all){
				if(p.getId_client() == id_client){
					id_cont = p.getId_cont();
				}
			}
			
			cont.setId_cont(id_cont);
			cont.setTip(text7.getText());
			cont.setSuma(Integer.parseInt(text8.getText()));
			cont.setData(sql);
			logic.updateCont(cont);
		}
		
		//delete client
		if (source == button4) {
			Logic logic = new Logic();
			Client client = new Client();
			client.setId_client(Integer.parseInt(text6.getText()));
			logic.deleteClient(client);
			
		}
		
		//delet cont
		if (source == button8) {
			/*Date date = new Date();
			DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date = format.parse(text9.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(date.getTime());*/
			Logic logic = new Logic();
			Conturi cont = new Conturi();
			////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////casuta id_cont noua
			////////////////////////////////////////cont.setId_cont(Integer.parseInt(text1.getText()));
			
			int id_client = Integer.parseInt(text6.getText());
			int id_cont = 0;
			cont.setId_client(id_client);
			List<Conturi> all = null;
			all = logic.selectCont(cont);
			for(Conturi p:all){
				if(p.getId_client() == id_client){
					id_cont = p.getId_cont();
				}
			}
			
			cont.setId_cont(id_cont);
			
			
			/*cont.setId_client(Integer.parseInt(text6.getText()));
			cont.setTip(text7.getText());
			cont.setSuma(Integer.parseInt(text8.getText()));
			cont.setData(sql);*/
			logic.deleteCont(cont);
		}
		
		//raport
		if (source == button9) {
			int id_client = Integer.parseInt(text10.getText());
			Date date_start = new Date();
			Date date_end = new Date();
			DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date_start = format.parse(text11.getText());
				date_end = format.parse(text12.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql_start = new java.sql.Date(date_start.getTime());
			java.sql.Date sql_end = new java.sql.Date(date_end.getTime());
			Logic logic = new Logic();
			List<Tranzactie> all = null;
			all = logic.selectRaport(id_client, sql_start, sql_end);
			textArea.append("Raport\n");
			Writer writer = null;
			String tranzaction = "";
			for(Tranzactie p:all){
				if(p.getId_client() == id_client){
					int results = p.getDate().compareTo(sql_start);
					int result1 = p.getDate().compareTo(sql_end);
				    if (results > 0 && result1 < 0) {
				    	try {
					        writer = new BufferedWriter(new OutputStreamWriter(
					              new FileOutputStream("filename.txt"), "utf-8"));
					        /*tranzaction = tranzaction + "id_tranzactie=" + p.getId_tranzactie() + ", " + "id_client=" + p.getId_client() + ", " +
					              "cont_sursa=" + p.getCont_s() + ", " + "cont_destinatie=" + p.getCont_d() + ", " + "suma=" + p.getSuma() + ", " +
					        		"data=" + p.getDate() + "\r\n";*/
					        tranzaction = tranzaction + "Tranzactia " + p.getId_tranzactie() + " a clientului " + p.getId_client() +
						              " din contul " + p.getCont_s() + " in contul " + p.getCont_d() + " cu suma de " + p.getSuma() +
						        		" la data de " + p.getDate() + "\r\n";
					        writer.write(tranzaction);
					    } catch (IOException ex) {
					      // report
					    } finally {
					       try {writer.close();} catch (Exception ex) {/*ignore*/}
					    }
				    	textArea.append(p.getId_tranzactie()+" "+p.getId_client()+" "+p.getCont_s()+" "+p.getCont_d()+" "+p.getSuma()+" "+p.getDate()+"\n");
				    } else if (results == 0 || result1 == 0) {
				    	textArea.append(p.getId_tranzactie()+" "+p.getId_client()+" "+p.getCont_s()+" "+p.getCont_d()+" "+p.getSuma()+" "+p.getDate()+"\n");
				    	try {
					        writer = new BufferedWriter(new OutputStreamWriter(
					              new FileOutputStream("filename.txt"), "utf-8"));
					        /*tranzaction = tranzaction + "id_tranzactie=" + p.getId_tranzactie() + ", " + "id_client=" + p.getId_client() + ", " +
				              "cont_sursa=" + p.getCont_s() + ", " + "cont_destinatie=" + p.getCont_d() + ", " + "suma=" + p.getSuma() + ", " +
				        		"data=" + p.getDate() + "\r\n";*/
					        tranzaction = tranzaction + "Tranzactia " + p.getId_tranzactie() + " a clientului " + p.getId_client() +
						              " din contul " + p.getCont_s() + " in contul " + p.getCont_d() + " cu suma de " + p.getSuma() +
						        		" la data de " + p.getDate() + "\r\n";
						    writer.write(tranzaction);
					    } catch (IOException ex) {
					      // report
					    } finally {
					       try {writer.close();} catch (Exception ex) {/*ignore*/}
					    }
				    }
				}
			}
		}
	}
	
	public static void main(String args[]){
		AdminWindow frame = new AdminWindow();
		frame.setTitle("AdminWindow");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
