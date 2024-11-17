import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/squareOfNum")
public class SquareOfNum extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        calling a servlet from another servlet
//        1) using RequestDispatcher
        request.setAttribute("name", "Prasu"); // adding attributes to send to another request

        RequestDispatcher rd = request.getRequestDispatcher("square");
        rd.forward(request, response);

//        2) using sendRedirect
//        response.sendRedirect("/Servlet-JSP/square?num="+request.getParameter("num")+"&name=Prasu");
    }
}
