package servlets;

import domain.User;
import repositories.IRepositoryCatalog;
import repositories.RepositoryCatalog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/do_register")
public class DoRegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (!checkData(request)) {
            session.setAttribute("RegisterFormError", true);

            response.sendRedirect("/show_register.jsp");
        } else {
            try {
                Connection connection = DriverManager.getConnection(""
                        + "jdbc:hsqldb:hsql://localhost/workdb");

                IRepositoryCatalog catalogOf = new RepositoryCatalog(connection);

                User user_in_db = catalogOf.users().withLoginAndEmail(request.getParameter("login"), request.getParameter("email"));

                if(user_in_db != null) {
                    session.setAttribute("RegisterFormErrorUserExists", true);
                    response.sendRedirect("/show_register.jsp");
                } else {

                    User user = new User();
                    user.setLogin(request.getParameter("login"));
                    user.setPassword(request.getParameter("password"));
                    user.setEmail(request.getParameter("email"));
                    catalogOf.users().add(user);
                    catalogOf.saveAndClose();

                    session.setAttribute("LoggedIn", true);
                    session.setAttribute("LoggedRole", User.RoleDefault);
                    session.setAttribute("LoggedUser", user);

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
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");

        return !(login == null || login.equals("") || password == null ||password.equals("") ||
                password2 == null || password2.equals("") || email == null || email.equals("") || !password.equals(password2));
    }
}