import java.sql.*;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement statement = null;
        PreparedStatement pstmnt = null;
        try {
            Class.forName("JdbcUtil");

            conn = JdbcUtil.establish(System.getenv("URL"), System.getenv("USER"), System.getenv("PASSWORD"));
            statement = conn.createStatement();

            //Prepare statement----------------------------------------------------------------------------------------------------
            String query = "Insert into studentInfo(id, sname, sage, scity) values(?,?,?,?)";
            pstmnt = conn.prepareStatement(query);
            System.out.println("enter id");
            Integer id = sc.nextInt();
            sc.nextLine();

            System.out.println("enter name");
            String name = sc.nextLine();
            
            System.out.println("enter age");
            Integer age = sc.nextInt();
            sc.nextLine();

            System.out.println("enter city");
            String city = sc.nextLine();

            pstmnt.setInt(1, id);
            pstmnt.setString(2, name);
            pstmnt.setInt(3, age);
            pstmnt.setString(4, city);

            int rowsAff = pstmnt.executeUpdate();
            //-------------------------------------------------------------------------------------------------------------------------

            ResultSet set = statement.executeQuery("select * from studentInfo");
            while(set.next()){
                System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3) + " " + set.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                JdbcUtil.close(conn, statement);
                pstmnt.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}