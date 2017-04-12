package filters;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/show_grant_premium", "/do_grant_premium"})
public class GrantPremiumFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        if(session.getAttribute("LoggedIn") != null && session.getAttribute("LoggedRole") != null && (Boolean) session.getAttribute("LoggedIn") &&
                (Integer)session.getAttribute("LoggedRole") == User.RoleAdmin){
            chain.doFilter(request, response);
        } else {
            session.setAttribute("NoRights", true);
            httpResponse.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
