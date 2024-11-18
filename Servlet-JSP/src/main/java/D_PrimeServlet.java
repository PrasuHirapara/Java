import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/prime")
public class D_PrimeServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int num = 0;
        int count = 0;
        Cookie[] arr = req.getCookies();


        for(Cookie c : arr) {
            if(c.getName().equals("num")) {
                num = Integer.parseInt(c.getValue());
            }
        }

        PrintWriter out = res.getWriter();

        for(int i=1; i<=num; i++) {
            if(num % i == 0) count++;
        }

        if(count == 2) {
            out.println("<h1>" + num + " is Prime. </h1>");
        }else {
            out.println("<h1>" + num + " is Not Prime. </h1>");
        }

        out.close();
    }
}
