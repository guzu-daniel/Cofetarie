package ro.emanuel.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	
	public static final String DB_USER="root";
	public static final String DB_PASS="root";
	public static final String DB_URL="jdbc:mysql://localhost:3306/cofetarie";
	
	public static Connection getConnection() throws SQLException {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		Properties props= new Properties();
		
		props.put("user", DB_USER);
		props.put("password", DB_PASS);
		
		Connection con=DriverManager.getConnection(DB_URL, props);
		System.out.println("Connected to database");
		return con;
	}
	
	public static void closeConnection(Connection con) throws SQLException{
		con.close();
		System.out.println("Conexiunea a fost inchisa");
	}

}
