package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import app.General;
public class ConnectionDB {
	public static int nConnection=0;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	public Connection conn = null;
	public boolean connect(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = (Connection)DriverManager.getConnection(
					"jdbc:mysql://" + General.DB_HOST + ":" + General.DB_PORT + "/" + General.DB_NAME + "?useSSL=false",
					General.DB_USER,
					General.DB_PWD
			);
			 if(conn != null){
				 nConnection++;
				 System.out.println("Success, connection No: "+nConnection+" ok :)");
				 return true;
			 }
		}catch(SQLException e){
			System.out.println("has not been conected");
			return false;
		}
		catch(ClassNotFoundException e){
			System.err.println("has not been conected");
			return false;
		}
		return false;
	} 
}
