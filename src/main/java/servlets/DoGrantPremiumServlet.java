package servlets;

import domain.User;
import repositories.IRepositoryCatalog;
import repositories.RepositoryCatalog;

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


@WebServlet("/do_grant_premium")
public class DoGrantPremiumServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (!checkData(request)) {
            session.setAttribute("GrantPremiumFormError", true);
            response.sendRedirect("/show_grant_premium");
        } else {
            try {
                Connection connection = DriverManager.getConnection(""
                        + "jdbc:hsqldb:hsql://localhost/workdb");

                IRepositoryCatalog catalogOf = new RepositoryCatalog(connection);

                User user_in_db = catalogOf.users().withId(Integer.parseInt(request.getParameter("user_id")));

                if(user_in_db == null) {
                    session.setAttribute("GrantPremiumFormError", true);
                    response.sendRedirect("/show_grant_premium");
                } else {
                    if(request.getParameter("action").equals("add")) {
                        user_in_db.setRole(User.RolePremium);
                    } else {
                        user_in_db.setRole(User.RoleDefault);
                    }

                    catalogOf.users().update(user_in_db);
                    catalogOf.saveAndClose();

                    response.sendRedirect("/show_users_list");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkData(HttpServletRequest request) {
        String user_id = request.getParameter("user_id");
        String action = request.getParameter("action");

        return !(user_id == null || user_id.equals("") || action == null ||action.equals("") ||
                !(action.equals("add") || action.equals("remove")) || user_id.equals("none"));
    }
}