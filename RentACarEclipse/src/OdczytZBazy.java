import model.Car;

import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OdczytZBazy")
public class OdczytZBazy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OdczytZBazy() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String url = "jdbc:mysql://localhost:3307/newrentacardb";
			String user = "java";
			String password = "java";
//			String orderBy = request.getParameter("orderBy");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, user, password);
				Statement st = conn.createStatement();
				String zapytanie;
				ArrayList<Car> cars = new ArrayList<Car>();
//				if (orderBy.equals("ascending")) {
				zapytanie = "select * from cars order by price asc";
//				} else {
//				zapytanie = "select * from cars order by price desc";
//				}
				ResultSet rs = st.executeQuery(zapytanie);
				while (rs.next()) {
					String carName = rs.getString("CarName");
					double price = rs.getDouble("Price");
					cars.add(new Car(carName, price));
				}
				request.setAttribute("carsNprice", cars);
				RequestDispatcher rd = request.getRequestDispatcher("rentACar.jsp");
				rd.forward(request, response);

			} catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("cos nie pyklo");
			}
		}

	}
}