import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/details")
public class E_Details extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        String name = context.getInitParameter("name");
        String phone = context.getInitParameter("phone");

        ServletConfig config = getServletConfig();
        String collage = config.getInitParameter("collage");

        out.println("<h1>" + name + "</h1>");
        out.println("<h1>" + phone + "</h1>");
        out.println("<h1>" + collage + "</h1>");
    }
}
