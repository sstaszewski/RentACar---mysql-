
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SprLogowania")
public class SprLogowania extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SprLogowania() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("ISO-8859-2");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ((login.equals("java")) && (password.equals("java"))) {
            response.sendRedirect("wybor.jsp");
        } else {
            response.sendRedirect("nieprawidlowe.jsp");
        }
    }
}