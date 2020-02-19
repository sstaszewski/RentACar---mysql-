import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;
import java.io.File;

@WebServlet("/OdczytZPliku")
public class OdczytZPliku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public OdczytZPliku() {
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
		File plik = new File("myfile");
		Scanner odczyt = new Scanner(plik);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			
			while (odczyt.hasNextLine()) {
				String carName = odczyt.nextLine();
				String priceS = odczyt.nextLine();
				double price = Double.parseDouble(priceS);
				String zapytanie = "insert into cars (CarName, Price) values('" + carName + "', " + price + "); ";
				st.executeUpdate(zapytanie);
			}
			response.sendRedirect("carAdded.jsp");
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
		odczyt.close();
	}
}