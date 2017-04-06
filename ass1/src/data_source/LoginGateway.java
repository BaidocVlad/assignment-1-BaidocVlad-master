package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Login;

public class LoginGateway {

	private DBConnection db = DBConnection.instance();
	
	private final static String findAllStatementString = "SELECT * "
			+ " from login ";
	
	public List<Login> listAllLogin() {

		PreparedStatement findStatement = null;
		ResultSet rs = null;

		List<Login> loginList = new ArrayList<Login>();

		try {
			try {
				findStatement = db.prepareStatement(findAllStatementString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = findStatement.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId_login(rs.getInt("id_login"));
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));
				login.setRol(rs.getInt("rol"));
				loginList.add(login);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// ("Error in  findById class ProductCOmplexGateway");
		}
		return loginList;
	}
	
	private static final String insertStatementString = "INSERT INTO login (id_login, username, password, rol)"
			+ " VALUES (?,?,?,?)";
	
	public boolean insert(Login login) {
		PreparedStatement insertStatement = null;
		boolean done = false;
		try {
			insertStatement = db.prepareStatement(insertStatementString);
			insertStatement.setInt(1, login.getId_login());
			insertStatement.setString(2, login.getUsername());
			insertStatement.setString(3, login.getUsername());
			insertStatement.setInt(4, login.getRol());
			insertStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	public boolean update(Login login) {
		PreparedStatement updateStatement = null;
		boolean done = false;
		try {
			updateStatement = db.prepareStatement("UPDATE TABLE login set id_login = "+login.getId_login()+", username="+login.getUsername()+", password="+login.getPassword()+", rol="+login.getRol()+" where id_cont = "+login.getId_login()+";");
			updateStatement.execute();
			done = true;
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	public boolean delete(int id_login) {
		PreparedStatement deleteStatement = null;
		boolean done = false;
		try {
			deleteStatement = db.prepareStatement("DELETE FROM login where id_login="+id_login+";");
			deleteStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	public Login getRole(String username, String password) {
		PreparedStatement getStatement = null;
		ResultSet rs = null;
		Login login = null;
		try {
			getStatement = db.prepareStatement("SELECT * FROM login where username=? and password=?");
			getStatement.setString(1,username);
			getStatement.setString(2,password);
			getStatement.execute();
			rs= getStatement.executeQuery();
			while(rs.next()){
				login = new Login();
				login.setId_login(rs.getInt("id_login"));
				login.setRol(rs.getInt("rol"));
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return login;
	}

}
