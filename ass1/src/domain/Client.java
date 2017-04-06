package domain;

public class Client {

	private int id_client;
	private String nume;
	private int cnp;
	private String adresa;
	private int id_card;
	private int id_login;

	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getCnp() {
		return cnp;
	}
	public void setCnp(int cnp) {
		this.cnp = cnp;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public int getId_card() {
		return id_card;
	}
	public void setId_card(int id_card) {
		this.id_card = id_card;
	}
	public int getId_login() {
		return id_login;
	}
	public void setId_login(int id_login) {
		this.id_login = id_login;
	}
}
