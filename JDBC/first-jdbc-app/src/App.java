import java.sql.*;
public class App {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("JdbcUtil");

            conn = JdbcUtil.establish(System.getenv("URL"), System.getenv("USER"), System.getenv("PASSWORD"));
            statement = conn.createStatement();

            ResultSet set = statement.executeQuery("select * from studentInfo");
            while(set.next()){
                System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3) + " " + set.getString(4));
            }
        } catch (Exception e) {

        }
        finally{
            try{
                JdbcUtil.close(conn, statement);
            }
            catch(Exception e){

            }
        }
    }
}