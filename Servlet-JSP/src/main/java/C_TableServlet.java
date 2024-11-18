import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/table")
public class C_TableServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession session = req.getSession();
        int num = (int) session.getAttribute("num");
        session.removeAttribute("num");

        PrintWriter out = res.getWriter();

        out.println("<table");
        for(int i = 1; i <= 10; i++) {
            out.println("<tr><td>" + num * i + "</td></tr>");
        }
        out.println("</table>");
        out.close();
    }
}
