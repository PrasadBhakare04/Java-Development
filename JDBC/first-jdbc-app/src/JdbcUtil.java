import java.sql.*;
public class JdbcUtil {
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){

        }
    }

    public static Connection establish(String url, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
        }
        return conn;
    }

    public static void close(Connection conn, Statement statement){
        try {
            statement.close();
            conn.close();
        } catch (Exception e) {
        }
        
    }
}
