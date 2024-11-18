import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/checkPrime")
public class D_CheckPrime extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        String num = req.getParameter("num");

        Cookie cookie = new Cookie("num", num);
        res.addCookie(cookie);

        RequestDispatcher rd = req.getRequestDispatcher("/prime");
        rd.forward(req, res);
    }
}
