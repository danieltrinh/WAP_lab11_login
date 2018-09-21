import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String name = (String) req.getParameter("username");
        String pass = (String) req.getParameter("pass");
        String remember_me = (String) req.getParameter("remember");

        User current = new User(name, pass);

        String html = "";

        System.out.println(UserData.users.get(0));
        if(UserData.users.contains(current))
        {
            session.setAttribute("username", name);
            resp.sendRedirect("/homepage");
        }
        // incorect User name pass word
        String message = "Either user name or password is wrong.";
        session.setAttribute("message", message);
        resp.sendRedirect("/login");
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
//        PrintWriter out= resp.getWriter();
//        out.println("<font color=red></font>");
//        rd.include(req, resp);
    }
}
