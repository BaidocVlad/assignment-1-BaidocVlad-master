package data_source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * DATABASE connection class realized with SINGLETON DESIGN PATTERN
 * 
 *
 *
 */

public class DBConnection {
	/**
	 * connection settings
	 */

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/";
	private static final String DBName = "psa1";
	private static String USER = "root";
	private static String PASS = "root";

	private Statement instruction;
	private Connection con;

	/**
	 * singleton object
	 */
	private static DBConnection oneObject = null;
	
	private DBConnection(String database) {
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(DBURL + database, USER, PASS);

			instruction = con.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Creates a unique instance of the database connection
	 * @return
	 */
	public static DBConnection instance() {
		if (oneObject == null) {
			oneObject = new DBConnection(DBName);
		}
		return oneObject;
	}
	/**
	 * closes the connection
	 */
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * overrides method
	 * 
	 * @param querry
	 *            --query to be executed
	 * @return the results of the query
	 */
	public ResultSet executeQuerry(String querry) {
		ResultSet ret = null;
		try {
			ret = instruction.executeQuery(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * overrides method
	 * 
	 * @param querry
	 *            query to be executed
	 * @return if the query was successful
	 */
	public boolean execute(String querry) {
		boolean done = false;
		try {
			done = instruction.execute(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	public PreparedStatement prepareStatement(String query) throws Exception{
        return con.prepareStatement(query);
    }
}
