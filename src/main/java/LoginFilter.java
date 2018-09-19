import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = { "/homepage" },
        servletNames = { "LoginServlet" }
)
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String loginURL = req.getContextPath() + "/login";

        if( (session != null && session.getAttribute("username") != null)
                ||  req.getRequestURI().equals(loginURL))
        {
            try{
                filterChain.doFilter(servletRequest,servletResponse);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            try{
                resp.sendRedirect("index.jsp");
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
