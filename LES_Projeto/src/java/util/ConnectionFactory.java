
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	public static void main(String args[]) throws Exception {
		try {
			if(getConnectionMysql() !=null)
				System.out.println("CONECTADO!!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnectionMysql() throws Exception {
            
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/ecommerce";
		user = "root";
		password = "root";
		Class.forName(driver);//carregamento explícito da classe org.postgresql.Driver ( driver )
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
                
	}
}