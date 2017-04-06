package domain;

import java.sql.Date;

public class Tranzactie {

	private int id_tranzactie;
	private int id_client;
	private int cont_s;
	private int cont_d;
	private int suma;
	private Date data;
	
	public int getId_tranzactie() {
		return id_tranzactie;
	}
	public void setId_tranzactie(int id_tranzactie) {
		this.id_tranzactie = id_tranzactie;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getCont_s() {
		return cont_s;
	}
	public void setCont_s(int cont_s) {
		this.cont_s = cont_s;
	}
	public int getCont_d() {
		return cont_d;
	}
	public void setCont_d(int cont_d) {
		this.cont_d = cont_d;
	}
	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma = suma;
	}
	public Date getDate() {
		return data;
	}
	public void setDate(Date data) {
		this.data = data;
	}
	
	
}
