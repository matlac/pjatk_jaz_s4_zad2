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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/show_users_list")
public class UserListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Connection connection = DriverManager.getConnection(""
                    + "jdbc:hsqldb:hsql://localhost/workdb");

            IRepositoryCatalog catalogOf = new RepositoryCatalog(connection);

            List<User> users = catalogOf.users().listUsers();

            request.setAttribute("users", users);
            RequestDispatcher view = request.getRequestDispatcher("show_users_list.jsp");
            view.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
