import java.sql.Connection;
import java.sql.PreparedStatement;

public class Model {
	private String name;
	private String city;
	private String mail;
	private String pwd;
	private Connection conn = null;
	private PreparedStatement pstmnt = null;
	private int rowsAffected = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public int register() {
		try {
			conn = Dbutil.getConnection();
			pstmnt = conn.prepareStatement("Insert into mvcapp(name, city, mail, pwd) values(?,?,?,?)");
			pstmnt.setString(1, name);
			pstmnt.setString(2, city);
			pstmnt.setString(3, mail);
			pstmnt.setString(4, pwd);
			
			rowsAffected = pstmnt.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			Dbutil.closeResources(conn, pstmnt);
		}
		
		return rowsAffected;
	}
}
