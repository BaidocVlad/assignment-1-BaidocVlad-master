package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_source.DBConnection;
import domain.Conturi;

public class ContGateway {

	private DBConnection db = DBConnection.instance();
	
	private final static String findAllStatementString = "SELECT * "
			+ " from conturi ";
	
	public List<Conturi> listAllCounts() {

		PreparedStatement findStatement = null;
		ResultSet rs = null;

		List<Conturi> contList = new ArrayList<Conturi>();

		try {
			try {
				findStatement = db.prepareStatement(findAllStatementString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = findStatement.executeQuery();
			while (rs.next()) {
				Conturi cont = new Conturi();
				cont.setId_cont(rs.getInt("id_cont"));
				cont.setId_client(rs.getInt("id_client"));
				cont.setTip(rs.getString("tip"));
				cont.setSuma(rs.getInt("suma"));
				cont.setData(rs.getDate("data"));
				contList.add(cont);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contList;
	}
	
	private static final String insertStatementString = "INSERT INTO conturi (id_client, tip, suma, data)"
			+ " VALUES (?,?,?,?)";
	
	public boolean insert(Conturi cont) {
		PreparedStatement insertStatement = null;
		boolean done = false;
		try {
			insertStatement = db.prepareStatement(insertStatementString);
			insertStatement.setInt(1, cont.getId_client());
			insertStatement.setString(2, cont.getTip());
			insertStatement.setInt(3, cont.getSuma());
			insertStatement.setDate(4, (java.sql.Date) cont.getData());
			insertStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	/*public boolean update(int id_cont, int id_client, String tip, int suma, Date data) {
		PreparedStatement updateStatement = null;
		boolean done = false;
		try {
			updateStatement = db.prepareStatement("UPDATE TABLE conturi set id_cont = "+id_cont+", id_client="+id_client+", tip="+tip+", suma="+suma+", data="+data+" where id_cont = "+id_cont+";");
			updateStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}*/
	public boolean update(Conturi cont) {
		PreparedStatement updateStatement = null;
		boolean done = false;
		try {
			updateStatement = db.prepareStatement("UPDATE conturi set id_client=?, tip=?, suma=?, data=? where id_cont =?");
			updateStatement.setInt(5,cont.getId_cont());
			updateStatement.setInt(1,cont.getId_client());
			updateStatement.setString(2,cont.getTip());
			updateStatement.setInt(3,cont.getSuma());
			updateStatement.setDate(4,(java.sql.Date) cont.getData());
			updateStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}
	
	public boolean delete(Conturi cont) {
		PreparedStatement deleteStatement = null;
		boolean done = false;
		try {
			deleteStatement = db.prepareStatement("DELETE FROM conturi where id_cont="+cont.getId_cont()+";");
			deleteStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}

	public Conturi getCont(Conturi cont) {
		PreparedStatement getStatement = null;
		ResultSet rs = null;
		try {
			getStatement = db.prepareStatement("SELECT * FROM client where id_client=" +cont.getId_client()+";");
			getStatement.execute();
			rs= getStatement.executeQuery();
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return cont;
		
	}

	
}
