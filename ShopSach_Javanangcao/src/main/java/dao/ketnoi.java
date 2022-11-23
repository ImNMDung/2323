package dao;
		import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class ketnoi {
public Connection cn;
	public void ketnoi()
	{
		try {
			Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Xong b1");
			
String st = "jdbc:sqlserver://DESKTOP-Q5TJD6D:1433;databaseName=QlSachs;user=sa; password=123456789";
			cn = DriverManager.getConnection(st);
			System.out.println("Xong b3");
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ketnoi kn = new ketnoi();
		kn.ketnoi();
	}

}
