package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Tort;

public class TortDAO {

	//create
	public static void insert(Tort tort) throws SQLException {

		Connection con=DBHelper.getConnection();
		String insertString="INSERT INTO tort(nume,descriere,pret,imagine)"
				+ " VALUES(?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(insertString);
		stmt.setString(1, tort.getNume());
		stmt.setString(2, tort.getDescriere());
		stmt.setInt(3, tort.getPret());
		stmt.setString(4, tort.getImagine());
		stmt.executeUpdate();		
		
		DBHelper.closeConnection(con);
		
	}

	//read
	public static ArrayList<Tort> getAllTort() throws SQLException {		
		Connection con=DBHelper.getConnection();

		String query="SELECT * FROM tort";
		Statement stmt= con.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		ArrayList<Tort> results= new ArrayList<Tort>();
		while(rs.next()) {
			int id=rs.getInt("id");
			String nume=rs.getString("nume");
			String descriere=rs.getString("descriere");
			int pret=rs.getInt("pret");
			String imagine=rs.getString("imagine");
			
			Tort tort = new Tort(id, nume, descriere, pret, imagine);
			results.add(tort);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static Tort getTortById( int id) throws SQLException
	{
		Connection con = DBHelper.getConnection();
		String query ="SELECT * FROM tort WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		 Tort tort = null;
		 if(rs.next()) { int idTort=rs.getInt("id");
			String nume=rs.getString("nume");
			String descriere=rs.getString("descriere");
			int pret =rs.getInt("pret");
			String imagine = rs.getString("imagine");
			tort = new Tort(idTort, nume, descriere, pret, imagine);
			 
		 }
		 DBHelper.closeConnection(con);
		 return tort;
		}
 
	// update
	public static void updateTort(Tort tort) throws SQLException
	{
		Connection con=DBHelper.getConnection();
		
		String updateString="UPDATE tort SET nume = ?, descriere = ?, pret = ?, imagine = ? WHERE id = ? ";
		PreparedStatement stmt=con.prepareStatement(updateString);
		stmt.setString(1, tort.getNume());
		stmt.setString(2, tort.getDescriere());
		stmt.setInt(3, tort.getPret());
		stmt.setString(4, tort.getImagine());
		
		stmt.setInt(5, tort.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	// delete
	
	public static void deleteTort(int idTort) throws SQLException {
		Connection con=DBHelper.getConnection();
		String deleteString= "DELETE FROM tort WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1,idTort);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
				
	}

}
