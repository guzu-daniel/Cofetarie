package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Prajitura;

public class PrajituraDAO {

	//create
	public static void insert(Prajitura prajitura) throws SQLException {

		Connection con=DBHelper.getConnection();
		String insertString="INSERT INTO prajitura(nume,descriere,pret,imagine)"
				+ " VALUES(?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(insertString);
		stmt.setString(1, prajitura.getNume());
		stmt.setString(2, prajitura.getDescriere());
		stmt.setInt(3, prajitura.getPret());
		stmt.setString(4, prajitura.getImagine());
		stmt.executeUpdate();		
		
		DBHelper.closeConnection(con);
		
	}

	//read
	public static ArrayList<Prajitura> getAllPrajitura() throws SQLException {		
		Connection con=DBHelper.getConnection();

		String query="SELECT * FROM prajitura";
		Statement stmt= con.createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		ArrayList<Prajitura> results= new ArrayList<Prajitura>();
		while(rs.next()) {
			int id=rs.getInt("id");
			String nume=rs.getString("nume");
			String descriere=rs.getString("descriere");
			int pret=rs.getInt("pret");
			String imagine=rs.getString("imagine");
			
			Prajitura prajitura = new Prajitura(id, nume, descriere, pret, imagine);
			results.add(prajitura);
		}
		DBHelper.closeConnection(con);
		return results;
	}
	
	public static Prajitura getPrajituraById( int id) throws SQLException
	{
		Connection con = DBHelper.getConnection();
		String query ="SELECT * FROM prajitura WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		 Prajitura prajitura = null;
		 if(rs.next()) { int idPrajitura=rs.getInt("id");
			String nume=rs.getString("nume");
			String descriere=rs.getString("descriere");
			int pret =rs.getInt("pret");
			String imagine = rs.getString("imagine");
			 prajitura= new Prajitura(idPrajitura, nume, descriere, pret, imagine);
			 
		 }
		 DBHelper.closeConnection(con);
		 return prajitura;
		}
 
	// update
	public static void updatePrajitura(Prajitura prajitura) throws SQLException
	{
		Connection con=DBHelper.getConnection();
		
		String updateString="UPDATE prajitura SET nume = ?, descriere = ?, pret = ?, imagine = ? WHERE id = ? ";
		PreparedStatement stmt=con.prepareStatement(updateString);
		stmt.setString(1, prajitura.getNume());
		stmt.setString(2, prajitura.getDescriere());
		stmt.setInt(3, prajitura.getPret());
		stmt.setString(4, prajitura.getImagine());
		
		stmt.setInt(5, prajitura.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	// delete
	
	public static void deletePrajitura(int idPrajitura) throws SQLException {
		Connection con=DBHelper.getConnection();
		String deleteString= "DELETE FROM prajitura WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1,idPrajitura);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
				
	}

}
