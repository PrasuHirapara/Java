import java.io.*;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

//@WebServlet("/sumOfNum") // configured in web.xml
public class A_SumOfNum extends HttpServlet {

//    if the req is of GET then url -> http://localhost:8080/Servlet-JSP/add?num1=123&num2=456
//    if the req is of POST then url -> http://localhost:8080/Servlet-JSP/add

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {
            // Parsing input numbers
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));

            // Calculating sum safely
            Optional<Integer> sum = Optional.of(Math.addExact(num1, num2)); // This will throw ArithmeticException if overflow occurs

            // Displaying the result
            out.println("<h1>Sum: " + sum.get() + "</h1>");
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}