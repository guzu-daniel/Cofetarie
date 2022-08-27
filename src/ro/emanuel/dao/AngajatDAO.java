package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Angajat;

public class AngajatDAO {

	//create
	public static void insert(Angajat angajat) throws SQLException {

		Connection con=DBHelper.getConnection();
		String insertString="INSERT INTO angajat(nume,prenume,adresa,telefon)"
				+ " VALUES(?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(insertString);
		stmt.setString(1, angajat.getNume());
		stmt.setString(2, angajat.getPrenume());
		stmt.setString(3, angajat.getAdresa());
		stmt.setString(4, angajat.getTelefon());
		stmt.executeUpdate();		
		
		DBHelper.closeConnection(con);
		
	}

	//read
	public static ArrayList<Angajat> getAllAngajat() throws SQLException {		
		Connection con=DBHelper.getConnection();

		String query="SELECT * FROM angajat";
		Statement stmt= con.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		ArrayList<Angajat> results= new ArrayList<Angajat>();
		while(rs.next()) {
			int id=rs.getInt("id");
			String nume=rs.getString("nume");
			String prenume=rs.getString("prenume");
			String adresa=rs.getString("adresa");
			String telefon=rs.getString("telefon");
			
			Angajat angajat = new Angajat(id,nume,prenume,adresa,telefon);
			results.add(angajat);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static Angajat getAngajatById( int id) throws SQLException
	{
		Connection con = DBHelper.getConnection();
		String query ="SELECT * FROM angajat WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		 Angajat angajat = null;
		 if(rs.next()) { int idAngajat=rs.getInt("id");
		 	String nume =rs.getString("nume");
		 	String prenume =rs.getString("prenume");
			String adresa =rs.getString("adresa");
			String telefon =rs.getString("telefon");
			 angajat= new Angajat(idAngajat,nume,prenume,adresa,telefon);
			 
		 }
		 DBHelper.closeConnection(con);
		 return angajat;
		}
 
	// update
	public static void updateAngajat(Angajat angajat) throws SQLException
	{
		Connection con=DBHelper.getConnection();
		
		String updateString="UPDATE angajat SET nume = ?, prenume = ?, adresa=?, telefon = ? WHERE id = ? ";
		PreparedStatement stmt=con.prepareStatement(updateString);
		stmt.setString(1, angajat.getNume());
		stmt.setString(2, angajat.getPrenume());
		stmt.setString(3, angajat.getAdresa());
		stmt.setString(4, angajat.getTelefon());
		
		stmt.setInt(5, angajat.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	// delete
	
	public static void deleteAngajat (int idAngajat) throws SQLException {
		Connection con=DBHelper.getConnection();
		String deleteString= "DELETE FROM angajat WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1,idAngajat);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
				
	}

}
