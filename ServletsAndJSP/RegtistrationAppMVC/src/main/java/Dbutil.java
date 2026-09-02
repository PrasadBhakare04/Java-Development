import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dbutil {
	static {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//enter your url and password
	public static Connection getConnection() {
		Connection conn = null;
		String username = "root";
		String url = "";
		String password = "";
		try{
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeResources(Connection conn, PreparedStatement pstmnt) {
		try {
			conn.close();
			pstmnt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
