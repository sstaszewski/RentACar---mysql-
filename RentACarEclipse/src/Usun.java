import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Usun")
public class Usun extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Usun() {
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
        String lastName = request.getParameter("lastName");
        if (lastName.length()!=0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                String zapytanie = "delete from customers where CustomerLastName='"+lastName+"'";
                st.executeUpdate(zapytanie);
                System.out.println("ok");
                response.sendRedirect("usunietoKlienta.jsp");
                conn.close();
            } catch (Exception exc) {
                exc.printStackTrace();
                System.out.println("cos nie pyklo");
            }
        } if (lastName.length()==0){
            String id = request.getParameter("numerek");
            int nr = Integer.parseInt(id);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                String zapytanie = "delete from customers where CustomerID= " + nr;
                st.executeUpdate(zapytanie);
                System.out.println("ok");
                response.sendRedirect("usunietoKlienta.jsp");
                conn.close();
            } catch (Exception exc) {
                exc.printStackTrace();
                System.out.println("cos nie pyklo");
            }
        }
    }

}
