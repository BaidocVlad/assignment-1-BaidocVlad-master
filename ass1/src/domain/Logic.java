package domain;

import java.util.List;

import data_source.ClientGateway;
import data_source.ContGateway;
import data_source.LoginGateway;
import data_source.TranzactieGateway;

public class Logic {
	
	/////////Clienti logic
	public List<Client> addClient(Client client){
		List<Client> all = null;
		ClientGateway clientGateway = new ClientGateway();
		clientGateway.insert(client);
		all = clientGateway.listAllClients();
		return all;
	}
	
	public List<Client> selectClient(int id_client){
		List<Client> all = null;
		ClientGateway clientGateway = new ClientGateway();
		clientGateway.getClient(id_client);
		all = clientGateway.listAllClients();
		return all;
	}
	
	public List<Client> deleteClient(Client client) {
		List<Client> all = null;
		ClientGateway clientGateway = new ClientGateway();
		clientGateway.delete(client);
		all = clientGateway.listAllClients();
		return all;
	}
	
	
	public List<Client> updateClient(Client client){
		List<Client> all = null;
		ClientGateway clientGateway = new ClientGateway();
		clientGateway.update(client);
		all = clientGateway.listAllClients();
		return all;
	}
	////////////Conturi logic
	public List<Conturi> addCont(Conturi cont){
		List<Conturi> all = null;
		ContGateway contGateway = new ContGateway();
		contGateway.insert(cont);
		all = contGateway.listAllCounts();
		return all;
	}
	
	public List<Conturi> selectCont(Conturi cont) {
		List<Conturi> all = null;
		ContGateway contGateway = new ContGateway();
		contGateway.getCont(cont);
		all = contGateway.listAllCounts();
		return all;
	}
	
	public List<Conturi> deleteCont(Conturi cont) {
		List<Conturi> all = null;
		ContGateway contGateway = new ContGateway();
		contGateway.delete(cont);
		all = contGateway.listAllCounts();
		return all;
	}
	
	public List<Conturi> updateCont(Conturi cont){
		List<Conturi> all = null;
		ContGateway contGateway = new ContGateway();
		contGateway.update(cont);
		all = contGateway.listAllCounts();
		return all;
	}
	////////Tranzactii logic
	public List<Tranzactie> addTranzactie(Tranzactie trans){
		TranzactieGateway tranzactieGateway = new TranzactieGateway();
		tranzactieGateway.insert(trans);
		return tranzactieGateway.listAllTranzaction();
	}
	//////////////////////////////////////////////////////////////////////////////
	/*public List<Tranzactie> selectTranzactie(int id_client, int cont_s){
		TranzactieGateway tranzactieGateway = new TranzactieGateway();
		tranzactieGateway.selectCont_s(id_client, cont_s);
		return tranzactieGateway.listAllTranzaction();
	}*/
	////////Login logic
	public List<Login> addLogin(Login login){
		List<Login> all = null;
		LoginGateway loginGateway = new LoginGateway();
		loginGateway.insert(login);
		all = loginGateway.listAllLogin();
		return all;
	}
	
	public Login selectLogin(String username, String password){
		//List<Login> all = null;
		LoginGateway loginGateway = new LoginGateway();
		return loginGateway.getRole(username, password);
		//all = loginGateway.listAllLogin();
		//return all;
	}
	
	public List<Login> deleteLogin(int id_login) {
		List<Login> all = null;
		LoginGateway loginGateway = new LoginGateway();
		loginGateway.delete(id_login);
		all = loginGateway.listAllLogin();
		return all;
	}
	
	public List<Login> updateLogin(Login login){
		List<Login> all = null;
		LoginGateway loginGateway = new LoginGateway();
		loginGateway.update(login);
		all = loginGateway.listAllLogin();
		return all;
	}

	public List<Tranzactie> selectRaport(int id_client, java.sql.Date sql_start, java.sql.Date sql_end) {
		List<Tranzactie> all = null;
		TranzactieGateway tranzactieGateway = new TranzactieGateway();
		tranzactieGateway.selectRaport(id_client, sql_end, sql_end);
		all = tranzactieGateway.listAllTranzaction();
		return all;
	}

}
