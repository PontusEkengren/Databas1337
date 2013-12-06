package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Dmm;
import View.View;

public class Controller {

	private Dmm theModel;
	private View theView;

	String user = "tidaa_temp"; // user name
	String pwd = "UqrAZdxNZXF8nPwc"; // password
	String database = "tidaa_temp"; // The name of the specific database in your
									// DBMS
	String server = "jdbc:mysql://178.78.213.33:3306/" + database
			+ "?UseClientEnc=UTF8";

	public Controller(View theView, Dmm theModel) {
		this.theView = theView;
		this.theModel = theModel;

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(server, user, pwd);
			System.out.println("Connected!");

			executeQuery(con, "SELECT * FROM Lab_1_Music");
			// addArtist(con,
			// "INSERT INTO Lab_1_Music(artist, genre, rating) VALUES('Test1', '2', 7)");
			// theView = new View();
			// theView.setVisible(true);
			try {
				insertAll(con, "SELECT * FROM Lab_1_Music");
				theView.initView();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
			}
		}

		// Start preforming shit that matters:
		this.theView.setColumns(3, "Shit");
		this.theView.printAnything("[DEBUG] NU FUNKAR DET!");
		this.theView.updateView();

	}

	public static void addArtist(Connection con, String query)
			throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("added");
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public void insertAll(Connection con, String query) throws SQLException {
		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData metaData = rs.getMetaData();
			int ccount = metaData.getColumnCount();
			int tmp = 0;
			while (rs.next()) {
				tmp++;
				for (int c = 1; c <= ccount; c++) {
					// System.out.print(rs.getObject(c) + "\t");
					theView.insertAll(tmp, rs.getObject(c), c);
				}
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	public static void executeQuery(Connection con, String query)
			throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Get the attribute names
			ResultSetMetaData metaData = rs.getMetaData();
			int ccount = metaData.getColumnCount();
			for (int c = 1; c <= ccount; c++) {
				System.out.print(metaData.getColumnName(c) + "\t");
				// theView.setColumns(c, metaData.getColumnName(c));
			}
			System.out.println();

			// Get the attribute values
			while (rs.next()) {
				// NB! This is an example, not the preferred way to retrieve
				// data.
				// You should use methods that return a specific data type, like
				// rs.getInt(), rs.getString() or such.
				// It's also advisable to store each tuple (row) in an object of
				// custom type (e.g. Employee).

				// int temp = 0;
				// frame.insertRow(rs.getObject(1));
				/*
				 * for(int c = 1; c <= ccount; c++) {
				 * System.out.print(rs.getObject(c) + "\t"); //
				 * System.out.println(rs.getObject(4));
				 * 
				 * 
				 * }
				 */
				System.out.println();
				// temp++;
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
