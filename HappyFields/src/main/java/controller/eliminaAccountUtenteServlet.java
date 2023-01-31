package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import persistenza.persistenzaServiceImpl;

import java.io.IOException;

@WebServlet(name = "eliminaAccountUtenteServlet", value = "/eliminaAccountUtenteServlet")
public class eliminaAccountUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession();
        persistenzaServiceImpl service = new persistenzaServiceImpl();
        service.doDropUser((String) ssn.getAttribute("id"));
        response.sendRedirect("home/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
