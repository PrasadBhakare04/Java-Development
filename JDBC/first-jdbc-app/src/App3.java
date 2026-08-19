import java.sql.*;

public class App3 {
    public static void main(String[] args) throws Exception {

        // Load and Register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the Connection
        String url = " ";
        String user = " ";
        String password = " ";
        Connection connection = DriverManager.getConnection(url, user, password);

        // Create the Statement
        Statement statement = connection.createStatement();

        Boolean status = statement.execute("select * from studentInfo");
        if(status){
            System.out.println("Select query");
            ResultSet set = statement.getResultSet();
            while(set.next()){
                System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3) + " " + set.getString(4));
            }
        }
        else{
            System.out.println("Non select query");
            int rowsAffected = statement.getUpdateCount();
            System.out.println(rowsAffected);
        }

        
        statement.close();
        connection.close();
    }
}
