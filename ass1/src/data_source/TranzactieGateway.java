package data_source;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Tranzactie;

public class TranzactieGateway {

	private DBConnection db = DBConnection.instance();
	
	private final static String findAllStatementString = "SELECT * "
			+ " from tranzactie ";
	
	public List<Tranzactie> listAllTranzaction() {

		PreparedStatement findStatement = null;
		ResultSet rs = null;

		List<Tranzactie> transList = new ArrayList<Tranzactie>();

		try {
			try {
				findStatement = db.prepareStatement(findAllStatementString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = findStatement.executeQuery();
			while (rs.next()) {
				Tranzactie trans = new Tranzactie();
				trans.setId_tranzactie(rs.getInt("id_tranzactie"));
				trans.setId_client(rs.getInt("id_client"));
				trans.setCont_s(rs.getInt("cont_s"));
				trans.setCont_d(rs.getInt("cont_d"));
				trans.setSuma(rs.getInt("suma"));
				trans.setDate(rs.getDate("data"));
				//////////////////
				transList.add(trans);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// ("Error in  findById class ProductCOmplexGateway");
		}
		return transList;
	}
	
	public List<Tranzactie> selectRaport(int id_client, Date d1, Date d2) {

		PreparedStatement selectStatement = null;
		ResultSet rs = null;

		List<Tranzactie> transList = new ArrayList<Tranzactie>();

		try {
			try {
				/*selectStatement = db.prepareStatement("select * from tranzactie where id_client = "+id_client+" and data BETWEEN '"+
						d1+"' and '"+d2+"' ;");*/
				selectStatement = db.prepareStatement("SELECT * FROM tranzactie WHERE data > ? and data < ?");
			} catch (Exception e) {
				e.printStackTrace();
			}
			selectStatement.setDate(1, d1);
			selectStatement.setDate(2, d2);
			rs = selectStatement.executeQuery();
			while (rs.next()) {
				Tranzactie trans = new Tranzactie();
				trans.setId_tranzactie(rs.getInt("id_tranzactie"));
				trans.setId_client(rs.getInt("id_client"));
				trans.setCont_s(rs.getInt("cont_s"));
				trans.setCont_d(rs.getInt("cont_d"));
				trans.setSuma(rs.getInt("suma"));
				trans.setDate(rs.getDate("data"));
				//////////////////
				transList.add(trans);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// ("Error in  findById class ProductCOmplexGateway");
		}
		return transList;
	}

	private static final String insertStatementString = "INSERT INTO tranzactie (id_client, cont_s, cont_d, suma, data)"
			+ " VALUES (?,?,?,?,?)";
	
	public boolean insert(Tranzactie trans) {
		PreparedStatement insertStatement = null;
		boolean done = false;
		try {
			insertStatement = db.prepareStatement(insertStatementString);
			insertStatement.setInt(1, trans.getId_client());
			insertStatement.setInt(2, trans.getCont_s());
			insertStatement.setInt(3, trans.getCont_d());
			insertStatement.setInt(4, trans.getSuma());
			insertStatement.setDate(5, trans.getDate());
			insertStatement.execute();
			done = true;

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return done;
	}

	/*public Tranzactie selectCont_s(int id_client, int cont_s) {
		PreparedStatement getStatement = null;
		ResultSet rs = null;
		Tranzactie trans = null;
		try {
			getStatement = db.prepareStatement("SELECT * FROM tranzactie where id_client=? and cont_s=?");
			getStatement.setInt(1,id_client);
			getStatement.setInt(2,cont_s);
			getStatement.execute();
			rs= getStatement.executeQuery();
			while(rs.next()){
				trans = new Tranzactie();
				trans.setCont_d(rs.getInt("cont_d"));
				trans.setSuma(rs.getInt("suma"));
				trans.setDate(rs.getDate("data"));
			}
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return trans;
	}*/
}
