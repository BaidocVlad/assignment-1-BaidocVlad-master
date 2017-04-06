package presentation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
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

import domain.Conturi;
import domain.Logic;
import domain.Tranzactie;

public class ClientWindow extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	
	private JLabel label1 = new JLabel("Conturi   ");
	private JLabel label2 = new JLabel("Tranzactie");
	private JLabel label3 = new JLabel("Utilitati ");
	
	private JLabel label4 = new JLabel("Id_client ");
	private JLabel label5 = new JLabel("Id_client ");
	private JLabel label6 = new JLabel("Cont_sursa");
	private JLabel label7 = new JLabel("Cont_dest ");
	private JLabel label8 = new JLabel("Suma      ");
	private JLabel label9 = new JLabel("Data      ");
	private JLabel label10 = new JLabel("Id_client ");
	private JLabel label11 = new JLabel("Cont_sursa");
	private JLabel label12 = new JLabel("Cont_dest ");
	private JLabel label13 = new JLabel("Suma      ");
	private JLabel label14 = new JLabel("Data      ");
	private JLabel label15 = new JLabel("Raport    ");
	private JLabel label16 = new JLabel("Data_start");
	private JLabel label17 = new JLabel("Data_end  ");
	private JLabel label18 = new JLabel("Id_client ");
	
	//private JButton button1 = new JButton("Insert");
	private JButton button1 = new JButton("Select");
	//private JButton button3 = new JButton("Update");
	//private JButton button4 = new JButton("Delete");
	private JButton button2 = new JButton("Transfer");
	//private JButton button6 = new JButton("Select");
	//private JButton button7 = new JButton("Update");
	//private JButton button8 = new JButton("Delete");
	private JButton button3 = new JButton("Pay");
	private JButton button4 = new JButton("Raport");

	private JTextField text1 = new JTextField(6);
	/*private JTextField text2 = new JTextField(6);
	private JTextField text3 = new JTextField(6);
	private JTextField text4 = new JTextField(6);*/
	private JTextField text5 = new JTextField(6);
	private JTextField text6 = new JTextField(6);
	private JTextField text7 = new JTextField(6);
	private JTextField text8 = new JTextField(6);
	private JTextField text9 = new JTextField(6);
	private JTextField text10 = new JTextField(6);
	private JTextField text11 = new JTextField(6);
	private JTextField text12 = new JTextField(6);
	private JTextField text13 = new JTextField(6);
	private JTextField text14 = new JTextField(6);
	
	private JTextField text2 = new JTextField(6);
	private JTextField text3 = new JTextField(6);
	private JTextField text4 = new JTextField(6);
	
	private JTextArea textArea = new JTextArea();
	private JScrollPane textAreaScroll = new JScrollPane(textArea); 
	
	public ClientWindow() {
		Dimension size = new Dimension(500, 500);
		this.setSize(size);
		this.setPreferredSize(size);
		getContentPane().add(panel);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(label4, c);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(label1, c);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(text1, c);
		/*c.gridx = 2;
		c.gridy = 0;
		panel.add(text2, c);
		c.gridx = 3;
		c.gridy = 0;
		panel.add(text3, c);
		c.gridx = 4;
		c.gridy = 0;
		panel.add(text4, c);*/
		c.gridx = 1;
		c.gridy = 2;
		panel.add(label5, c);
		c.gridx = 2;
		c.gridy = 2;
		panel.add(label6, c);
		c.gridx = 3;
		c.gridy = 2;
		panel.add(label7, c);
		c.gridx = 4;
		c.gridy = 2;
		panel.add(label8, c);
		c.gridx = 5;
		c.gridy = 2;
		panel.add(label9, c);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(label2, c);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(text5, c);
		c.gridx = 2;
		c.gridy = 3;
		panel.add(text6, c);
		c.gridx = 3;
		c.gridy = 3;
		panel.add(text7, c);
		c.gridx = 4;
		c.gridy = 3;
		panel.add(text8, c);
		c.gridx = 5;
		c.gridy = 3;
		panel.add(text9, c);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(label10, c);
		c.gridx = 2;
		c.gridy = 5;
		panel.add(label11, c);
		c.gridx = 3;
		c.gridy = 5;
		panel.add(label12, c);
		c.gridx = 4;
		c.gridy = 5;
		panel.add(label13, c);
		c.gridx = 5;
		c.gridy = 5;
		panel.add(label14, c);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(label3, c);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(text10, c);
		c.gridx = 2;
		c.gridy = 6;
		panel.add(text11, c);
		c.gridx = 3;
		c.gridy = 6;
		panel.add(text12, c);
		c.gridx = 4;
		c.gridy = 6;
		panel.add(text13, c);
		c.gridx = 5;
		c.gridy = 6;
		panel.add(text14, c);
		text12.setText("9999");
		
		c.gridx = 0;
		c.gridy = 9;
		panel.add(label15, c);
		c.gridx = 1;
		c.gridy = 8;
		panel.add(label18, c);
		c.gridx = 2;
		c.gridy = 8;
		panel.add(label16, c);
		c.gridx = 3;
		c.gridy = 8;
		panel.add(label17, c);
		c.gridx = 1;
		c.gridy = 9;
		panel.add(text2, c);
		c.gridx = 2;
		c.gridy = 9;
		panel.add(text3, c);
		c.gridx = 3;
		c.gridy = 9;
		panel.add(text4, c);
		
		c.gridx = 2;
		c.gridy = 1;
		panel.add(button1, c);
		button1.addActionListener(this);

		/*c.gridx = 1;
		c.gridy = 0;
		panel.add(button1, c);
		button1.addActionListener(this);

		c.gridx = 3;
		c.gridy = 0;
		panel.add(button3, c);
		button3.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 0;
		panel.add(button4, c);
		button4.addActionListener(this);*/
		
		c.gridx = 1;
		c.gridy = 4;
		panel.add(button2, c);
		button2.addActionListener(this);

		/*c.gridx = 2;
		c.gridy = 3;
		panel.add(button6, c);
		button6.addActionListener(this);

		c.gridx = 3;
		c.gridy = 3;
		panel.add(button7, c);
		button7.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 3;
		panel.add(button8, c);
		button8.addActionListener(this);*/
		
		c.gridx = 1;
		c.gridy = 7;
		panel.add(button3, c);
		button3.addActionListener(this);
		
		c.gridx = 4;
		c.gridy = 9;
		panel.add(button4, c);
		button4.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 10;
		textAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textAreaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textAreaScroll.setPreferredSize(new Dimension(300,125));
		panel.add(textAreaScroll,c);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		/*int id_client = Integer.parseInt(text1.getText());
		String tip = text2.getText();
		int suma = Integer.parseInt(text3.getText());
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
		try {
			date = format.parse(text4.getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(date.getTime());
		*/
		if (source == button1) {
			int id_client = Integer.parseInt(text1.getText());
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
		}
		
		if (source == button2) {
			int id_client = Integer.parseInt(text5.getText());
			int cont_s = Integer.parseInt(text6.getText());
			int cont_d = Integer.parseInt(text7.getText());
			int suma = Integer.parseInt(text8.getText());
			Date date = new Date();
			DateFormat format1 = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date = format1.parse(text9.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(date.getTime());
			Tranzactie trans = new Tranzactie();
			trans.setId_client(id_client);
			trans.setCont_s(cont_s);
			trans.setCont_d(cont_d);
			trans.setSuma(suma);
			trans.setDate(sql);
			Logic logic = new Logic();
			Conturi cont = new Conturi();
			Conturi cont1 = new Conturi();
			cont.setId_client(id_client);
			cont1.setId_client(cont_d);
			List<Conturi> all = null;
			List<Conturi> all1 = null;
			all = logic.selectCont(cont);
			all1 = logic.selectCont(cont1);
			int sum = 0, sum1 = 0;
			String tip = "", tip1 = "";
			for(Conturi p:all){
				if(p.getId_client() == id_client){
					if(p.getId_cont() == cont_s){
						sum = p.getSuma();
						tip = p.getTip();
						cont.setId_client(id_client);
						cont.setId_cont(cont_s);
						cont.setSuma(sum - suma);
						cont.setTip(p.getTip());
						cont.setData(p.getData());
						logic.updateCont(cont);
					
					
					}
					
				}
			}
			
			
			for(Conturi p:all1){
				
					if(p.getId_cont() == cont_d){
						sum1 = p.getSuma();
						tip = p.getTip();
						cont1.setId_client(cont_d);
						cont1.setId_cont(cont_d);
						cont1.setSuma(sum1 + suma);
						cont1.setTip(p.getTip());
						cont1.setData(p.getData());
						logic.updateCont(cont1);
					
					
					}
					
				}
			logic.addTranzactie(trans);
			}
			
			
				
	
		if (source == button3) {
			int id_client = Integer.parseInt(text10.getText());
			int cont_s = Integer.parseInt(text11.getText());
			int cont_d = Integer.parseInt(text12.getText());
			int suma = Integer.parseInt(text13.getText());
			Date date = new Date();
			DateFormat format1 = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date = format1.parse(text9.getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(date.getTime());
			Tranzactie trans = new Tranzactie();
			trans.setId_client(id_client);
			trans.setCont_s(cont_s);
			trans.setCont_d(cont_d);
			trans.setSuma(suma);
			trans.setDate(sql);
			Logic logic = new Logic();
			Conturi cont = new Conturi();
			cont.setId_client(id_client);
			List<Conturi> all = null;
			all = logic.selectCont(cont);
			int sum = 0, sum1 = 0;
			String tip = "", tip1 = "";
			for(Conturi p:all){
				if(p.getId_client() == id_client){
					if(p.getId_cont() == cont_s){
						sum = p.getSuma();
						tip = p.getTip();
					}
					else if(p.getId_cont() == cont_d){
						sum1 = p.getSuma();
						tip1 = p.getTip();
					}
				}
			}
			logic.addTranzactie(trans);
			cont.setId_client(id_client);
			cont.setId_cont(cont_s);
			cont.setSuma(sum - suma);
			cont.setTip(tip);
			cont.setData(sql);
			logic.updateCont(cont);
			cont.setId_cont(cont_d);
			cont.setSuma(sum1 + suma);
			cont.setTip(tip1);
			logic.updateCont(cont);
		}
		
		if (source == button4) {
			int id_client = Integer.parseInt(text2.getText());
			Date date_start = new Date();
			Date date_end = new Date();
			DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
			try {
				date_start = format.parse(text3.getText());
				date_end = format.parse(text4.getText());
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
		ClientWindow frame = new ClientWindow();
		frame.setTitle("ClientWindow");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
