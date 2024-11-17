import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/square")
public class SquareServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        try{
            Optional<Integer> num = Optional.of(Integer.parseInt(req.getParameter("num")));
            Optional<Integer> square = Optional.of(num.get() * num.get());
            String name = req.getAttribute("name").toString(); // from RequestDispatcher
//            String name = req.getParameter("name"); // from sendRedirect

            out.println("<h1> Name = " + name + "</h1>");
            out.println("<h1>Square of " + num.get() + " = " + square.get() + "</h1>");
        } catch (Exception e){
            out.println("<h1>" + e.getMessage() + "</h1>");
        }
    }
}
