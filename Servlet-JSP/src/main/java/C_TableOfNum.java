import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/tableOfNum")
public class C_TableOfNum extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int num = Integer.parseInt(req.getParameter("num"));

        HttpSession session = req.getSession();
        session.setAttribute("num", num);

        RequestDispatcher rd = req.getRequestDispatcher("/table");
        rd.forward(req, res);
    }
}
