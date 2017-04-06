package domain;

import java.util.Date;

public class Conturi {

	private int id_cont;
	private int id_client;
	private String tip;
	private int suma;
	private Date data;
	
	public int getId_cont() {
		return id_cont;
	}
	public void setId_cont(int id_cont) {
		this.id_cont = id_cont;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma = suma;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
