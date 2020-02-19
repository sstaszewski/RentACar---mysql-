import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Rejestracja")
public class Rejestracja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Rejestracja() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String url = "jdbc:mysql://localhost:3307/newrentacardb";
		String user = "java";
		String password = "java";
		String login = request.getParameter("login");
		String haselo = request.getParameter("haselo");
		String haselo2 = request.getParameter("haselo2");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			
			if(haselo.equals(haselo2)){
			String zapytanie = "CREATE USER '"+login+"'@'localhost' IDENTIFIED BY '"+haselo+"';";
			String zap2 =  "GRANT ALL PRIVILEGES ON *.* TO '"+login+"'@'localhost';";
			st.executeUpdate(zapytanie);
			st.execute(zap2);
			System.out.println("ok");
			response.sendRedirect("dodanoUzytkownika.jsp");
			conn.close();
			} else{
				response.sendRedirect("haslaNiezgodne.jsp");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
	}

}