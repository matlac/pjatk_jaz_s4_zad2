import models.CalculateRowModel;
import org.junit.Test;
import servlets.CalculateServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestCalculateServlet {

    @Test
    public void servlet_redirect_if_invalid_amount() throws IOException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("amount")).thenReturn(null);
        when(request.getParameter("rates_count")).thenReturn("2");
        when(request.getParameter("percent")).thenReturn("2.1");
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_redirect_if_empty_amount() throws IOException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("amount")).thenReturn("");
        when(request.getParameter("rates_count")).thenReturn("2");
        when(request.getParameter("percent")).thenReturn("2.1");
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_redirect_if_invalid_rates_count() throws IOException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("amount")).thenReturn("123");
        when(request.getParameter("rates_count")).thenReturn(null);
        when(request.getParameter("percent")).thenReturn("2.1");
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_redirect_if_empty_rates_count() throws IOException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("amount")).thenReturn("123");
        when(request.getParameter("rates_count")).thenReturn("");
        when(request.getParameter("percent")).thenReturn("2.1");
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_redirect_if_invalid_percent() throws IOException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("amount")).thenReturn("123");
        when(request.getParameter("rates_count")).thenReturn("");
        when(request.getParameter("percent")).thenReturn(null);
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_redirect_if_empty_percent() throws IOException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("amount")).thenReturn("123");
        when(request.getParameter("rates_count")).thenReturn("22");
        when(request.getParameter("percent")).thenReturn("");
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_show_jsp_if_valid_data_provided() throws IOException, ServletException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();
        RequestDispatcher view = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(view);
        when(request.getParameter("amount")).thenReturn("1232");
        when(request.getParameter("rates_count")).thenReturn("22");
        when(request.getParameter("percent")).thenReturn("10.2");
        when(request.getParameter("rates_type")).thenReturn("equal");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(request).getRequestDispatcher(anyString());
        verify(view).forward(request, response);
    }

    @Test
    public void servlet_redirect_if_no_valid_data_in_session() throws IOException, ServletException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();

        when(session.getAttribute("rates_data")).thenReturn(null);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("action")).thenReturn("download_pdf");

        try {
            servlet.doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlet_redirect_if_no_valid_url() throws IOException, ServletException {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CalculateServlet servlet = new CalculateServlet();
        ArrayList ratesData = mock(ArrayList.class);

        when(ratesData.size()).thenReturn(2);
        when(session.getAttribute("rates_data")).thenReturn(ratesData);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("action")).thenReturn(null);

        try {
            servlet.doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        verify(response).sendRedirect("/");
    }

}

