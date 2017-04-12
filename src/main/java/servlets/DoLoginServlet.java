package servlets;

import domain.User;
import org.apache.commons.codec.binary.Hex;
import repositories.IRepositoryCatalog;
import repositories.RepositoryCatalog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/do_login")
public class DoLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (!checkData(request)) {
            session.setAttribute("LoginFormError", true);

            response.sendRedirect("/show_login.jsp");
        } else {
            try {
                Connection connection = DriverManager.getConnection(""
                        + "jdbc:hsqldb:hsql://localhost/workdb");

                IRepositoryCatalog catalogOf = new RepositoryCatalog(connection);

                User user_in_db = catalogOf.users().withLoginAndPassword(request.getParameter("login"), request.getParameter("password"));

                if(user_in_db == null) {
                    session.setAttribute("LoginFormError", true);
                    response.sendRedirect("/show_login.jsp");
                } else {
                    session.setAttribute("LoggedIn", true);
                    session.setAttribute("LoggedRole", user_in_db.getRole());
                    session.setAttribute("LoggedUser", user_in_db);

                    response.sendRedirect("/show_user_profile");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkData(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        return !(login == null || login.equals("") || password == null || password.equals(""));
    }
}
