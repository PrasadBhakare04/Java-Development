

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String city = request.getParameter("city");
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		
		Model model = new Model();
		model.setName(name);
		model.setCity(city);
		model.setMail(mail);
		model.setPwd(pwd);
		
		int rowsAffected = model.register();
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("city", city);
		session.setAttribute("mail", mail);
		
		if(rowsAffected == 0) {
			response.sendRedirect("/RegistrationAppMVC/failure.jsp");
		}
		
		else {
			response.sendRedirect("/RegistrationAppMVC/success.jsp");
		}
	}

}
