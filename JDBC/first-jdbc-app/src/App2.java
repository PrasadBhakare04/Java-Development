import java.sql.*;

public class App2 {
    public static void main(String[] args) throws Exception {

        //Load and Register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the Connection
        String url = "";
        String user = "";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);

        //Create the Statement
        Statement statement = connection.createStatement();
        
        ResultSet set = statement.executeQuery("select * from studentInfo");
        while(set.next()){
            System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3) + " " + set.getString(4));
        }

        set.close();
        statement.close();
        connection.close();
    }
}