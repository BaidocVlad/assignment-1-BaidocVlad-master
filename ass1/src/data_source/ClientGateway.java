package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_source.DBConnection;
import domain.Client;

public class ClientGateway {

	private DBConnection db = DBConnection.instance();
	
	private final static String findAllStatementString = "SELECT * "
			+ " from client ";
	
	public List<Client> listAllClients() {

		PreparedStatement findStatement = null;
		ResultSet rs = null;

		List<Client> clientList = new ArrayList<Client>();

		try {
			try {
				findStatement = db.prepareStatement(findAllStatementString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = findStatement.executeQuery();
			while (rs.next()) {
				Client client = new Client();
				client.setId_client(rs.getInt("id_client"));
				client.setNume(rs.getString("nume"));
				client.setCnp(rs.getInt("cnp"));
				client.setAdresa(rs.getString("adresa"));
				client.setId_card(rs.getInt("id_card"));
				client.setId_login(rs.getInt("id_login"));
				clientList.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// ("Error in  findById class ProductCOmplexGateway");
		}
		return clientList;
	}
	
	private static final String insertStatementString = "INSERT INTO client (nume, cnp, adresa, id_card, id_login)"
			+ " VALUES (?,?,?,?,?)";
	
	public boolean insert(Client client) {
		PreparedStatement insertStatement = null;
		boolean done = false;
		try {
			insertStatement = db.prepareStatement(insertStatementString);
			insertStatement.setString(1, client.getNume());
			insertStatement.setInt(2, client.getCnp());
			insertStatement.setString(3, client.getAdresa());
			insertStatement.setInt(4, client.getId_card());
			insertStatement.setInt(5, client.getId_login());
			insertStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	
	
	public boolean update(Client client) {
		PreparedStatement updateStatement = null;
		boolean done = false;
		try {
			
			updateStatement = db.prepareStatement("UPDATE client set nume=?, cnp=?, adresa=?, id_card=?, id_login=? where id_client = ?");
			updateStatement.setInt(6,client.getId_client());
			updateStatement.setString(1,client.getNume());
			updateStatement.setInt(2,client.getCnp());
			updateStatement.setString(3,client.getAdresa());
			updateStatement.setInt(4,client.getId_card());
			updateStatement.setInt(5,client.getId_login());
			updateStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	public boolean delete(Client client) {
		PreparedStatement deleteStatement = null;
		boolean done = false;
		try {
			deleteStatement = db.prepareStatement("DELETE FROM client where id_client="+client.getId_client()+";");
			deleteStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	public Client getClient(int Id_client) {
		PreparedStatement getStatement = null;
		ResultSet rs = null;
		Client client = null;
		//int id_client, cnp, id_card, id_login;
		//String nume, adresa;
		try {
			getStatement = db.prepareStatement("SELECT * FROM client where id_client="+Id_client+";");
			getStatement.execute();
			rs= getStatement.executeQuery();
			while(rs.next()){
				client = new Client();
			    client.setId_client(rs.getInt("id_client"));
				client.setNume(rs.getString("nume"));
				client.setCnp(rs.getInt("cnp"));
				client.setAdresa(rs.getString("adresa"));
				client.setId_card(rs.getInt("id_card"));
				client.setId_login(rs.getInt("id_login"));
				
				/*int id_client = rs.getInt("id_client");
				String nume = rs.getString("nume");
				int cnp = rs.getInt("cnp");
				String adresa = rs.getString("adresa");
				int id_card = rs.getInt("id_card");
				int id_login = rs.getInt("id_login");
				client = new Client(id_client);
				client.setNume(nume);
				client.setCnp(cnp);
				client.setAdresa(adresa);
				client.setId_card(id_card);
				client.setId_login(id_login);
				return client;*/
			}
			
			//return null;
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		//return client;
		return client;
	}
}
