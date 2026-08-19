
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {

        //Load and Register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the Connection
        String url = System.getenv("URL");
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        Connection connection = DriverManager.getConnection(url, user, password);

        //Create the Statement
        Statement statement = connection.createStatement();
    
        //Execute the Query
        String sql = "insert into studentInfo values (1, \"Prasad\", 39, \"Pune\")";
        int rowsAffected = statement.executeUpdate(sql);
        
        //Process the result
        if(rowsAffected == 0)
            System.out.println("no data inserted");
        else
            System.out.println("Data inserted successfully");
        //Close the resources
        connection.close();
    }

}
