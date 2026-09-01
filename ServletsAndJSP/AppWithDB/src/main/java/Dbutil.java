import java.sql.Connection;
import java.sql.DriverManager;

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
}
