
import java.sql.*;

public class App {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement = null; 
        try {
            
            //Load and Register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            //Establish the Connection
            String url = System.getenv("URL");
            String user = System.getenv("USER");
            String password = System.getenv("PASSWORD");
            connection = DriverManager.getConnection(url, user, password);
    
            //Create the Statement
            statement = connection.createStatement();
        
            //Execute the Query
            String sql = "insert into studentInfo values (1, \"Prasad\", 39, \"Pune\")";
            int rowsAffected = statement.executeUpdate(sql);
            
            //Process the result
            if(rowsAffected == 0)
                System.out.println("no data inserted");
            else
                System.out.println("Data inserted successfully");
            
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            //Close the resources
            try{
                statement.close();
                connection.close();
                
            }
            catch(SQLException e){

            }
        }
    }

}
