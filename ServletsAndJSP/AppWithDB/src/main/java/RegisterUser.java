
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String city = request.getParameter("city");
		int affectedRows = 0;

		try {
			Class.forName("Dbutil");

			Connection conn = Dbutil.getConnection();
			PreparedStatement pstment = conn.prepareStatement("Insert into registeredusers(uname, ucity) values(?,?)");

			pstment.setString(1, name);
			pstment.setString(2, city);

			affectedRows = pstment.executeUpdate();

			PrintWriter writer = response.getWriter();
			writer.println(affectedRows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
