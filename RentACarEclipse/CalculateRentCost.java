import model.Car;
import model.RentedCar;
import java.sql.Statement;
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

@WebServlet("/CalculateRentCost")
public class CalculateRentCost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculateRentCost() {
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
		String carName = request.getParameter("chooseACar");
		String rentL = request.getParameter("rentLength");
		double rentLength = Double.parseDouble(rentL);
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
//		*****************************************    przyda sie pozniej zeby przypisac carID do customerID
//			Statement st = conn.createStatement();
			Statement st1 = conn.createStatement();
			String zapytanieOCene = "SELECT CarName,Price FROM `cars` WHERE CarName='" + carName + "';";
			ResultSet rs = st1.executeQuery(zapytanieOCene);
			while (rs.next()) {
				String carName2 = rs.getString("CarName");
				double rentPrice = rentLength * rs.getDouble("Price");
				System.out.println(carName + " dni: " + rentLength + " = " + rentPrice);

				
				// sposob 2 nie dziala
//				request.setAttribute("rentedCar", rentedCar);
				request.setAttribute("carName2", carName2);
				request.setAttribute("rentPrice", rentPrice);
				request.setAttribute("rentLength", rentLength);
				
				// sposob 1 nie dziala
//				RentedCar rentedCar = new RentedCar(carName, rentPrice, rentLength);
//				rentedCar.setCarName(""+carName+"");
//				rentedCar.setCarPri(rentPrice);
//				rentedCar.setCarLength(rentLength);
				
				//sposob 3 nie dziala
//				request.getSession().setAttribute("rentedCarName", "'"+carName+"'");
				
				// sposob 4 nie dziala
//				getServletContext().setAttribute("rentedCarName",carName);
				
				//sposb 5 dziala tylko dla nazwy...
//				response.sendRedirect("youJustRentACar.jsp?rentedCarName="+carName);
//				response.sendRedirect("youJustRentACar.jsp?rentLength="+rentLen);
//				response.sendRedirect("youJustRentACar.jsp?rentPrice="+rentPrice);
				
				RequestDispatcher rd = request.getRequestDispatcher("youJustRentACar.jsp");
				rd.forward(request, response);
			}
//			response.sendRedirect("youJustRentACar.jsp");
			conn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
	}
}