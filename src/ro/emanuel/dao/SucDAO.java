package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Suc;

public class SucDAO {

	//create
	public static void insert(Suc suc) throws SQLException {

		Connection con=DBHelper.getConnection();
		String insertString="INSERT INTO suc(nume,descriere,pret,imagine)"
				+ " VALUES(?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(insertString);
		stmt.setString(1, suc.getNume());
		stmt.setString(2, suc.getDescriere());
		stmt.setInt(3, suc.getPret());
		stmt.setString(4, suc.getImagine());
		stmt.executeUpdate();		
		
		DBHelper.closeConnection(con);
		
	}

	//read
	public static ArrayList<Suc> getAllSuc() throws SQLException {		
		Connection con=DBHelper.getConnection();

		String query="SELECT * FROM suc";
		Statement stmt= con.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		ArrayList<Suc> results= new ArrayList<Suc>();
		while(rs.next()) {
			int id=rs.getInt("id");
			String nume=rs.getString("nume");
			String descriere=rs.getString("descriere");
			int pret=rs.getInt("pret");
			String imagine=rs.getString("imagine");
			
			Suc suc = new Suc(id, nume, descriere, pret, imagine);
			results.add(suc);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static Suc getSucById( int id) throws SQLException
	{
		Connection con = DBHelper.getConnection();
		String query ="SELECT * FROM suc WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		 Suc suc = null;
		 if(rs.next()) { int idSuc=rs.getInt("id");
			String nume=rs.getString("nume");
			String descriere=rs.getString("descriere");
			int pret =rs.getInt("pret");
			String imagine = rs.getString("imagine");
			suc = new Suc(idSuc, nume, descriere, pret, imagine);
			 
		 }
		 DBHelper.closeConnection(con);
		 return suc;
		}
 
	// update
	public static void updateSuc(Suc suc) throws SQLException
	{
		Connection con=DBHelper.getConnection();
		
		String updateString="UPDATE suc SET nume = ?, descriere = ?, pret = ?, imagine = ? WHERE id = ? ";
		PreparedStatement stmt=con.prepareStatement(updateString);
		stmt.setString(1, suc.getNume());
		stmt.setString(2, suc.getDescriere());
		stmt.setInt(3, suc.getPret());
		stmt.setString(4, suc.getImagine());
		
		stmt.setInt(5, suc.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	// delete
	
	public static void deleteSuc(int idSuc) throws SQLException {
		Connection con=DBHelper.getConnection();
		String deleteString= "DELETE FROM suc WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1,idSuc);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
				
	}

}
