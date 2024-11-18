import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/*")
public class F_LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        String loginURI = req.getContextPath() + "/F_Login.jsp";
        String loginServletURI = req.getContextPath() + "/login";

        boolean isLoginRequest = req.getRequestURI().equals(loginURI) || req.getRequestURI().equals(loginServletURI);

        if (loggedIn || isLoginRequest) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }
    }

    public void destroy() {}
}
