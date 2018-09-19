import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String name = (String) req.getParameter("username");
        String pass = (String) req.getParameter("pass");

        User current = new User(name, pass);

        String html = "";

        System.out.println(UserData.users.get(0));
        if(UserData.users.contains(current))
        {
            session.setAttribute("username", name);
            resp.sendRedirect("/homepage");
        }
        // incorect User name pass word
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        PrintWriter out= resp.getWriter();
        out.println("<font color=red>Either user name or password is wrong.</font>");
        rd.include(req, resp);
    }
}
