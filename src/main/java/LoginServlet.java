import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.setAttribute("username", req.getParameter("username"));
        session.setAttribute("pass", req.getParameter("pass"));

        String name = (String) session.getAttribute("username");
        String pass = (String) session.getAttribute("pass");

        User current = new User(name, pass);

        String html = "";
        int visitCount = 0;

        for (User dataUser : UserData.users) {
            if(current.equals(dataUser))
            {
                PrintWriter out = resp.getWriter();
                out.print("<html><head><title>Test</title></head><body>");
                out.print("<h1>"+name+"</h1>");
                out.print("<form action='logout' method='post'>");
                out.print("<input type='submit' value='Log out'/>");
                out.print("</form>");
                out.print("</body></html>");

                resp.getWriter().println(html);
                return;
            }
        }

//        resp.getWriter().println("wrong" + name +pass);
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("Logged out");
        out.print("</body></html>");
    }
}
