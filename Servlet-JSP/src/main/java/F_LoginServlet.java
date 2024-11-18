// src/F_LoginServlet.java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class F_LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if ("Prasu".equals(username) && "Prasu@123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect(request.getContextPath());
        } else {
            System.out.println("1");
            System.out.println(username);
            System.out.println(password);
            response.sendRedirect("F_Login.jsp");
        }
    }
}
