package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "registerUtenteServlet", value = "/registerUtenteServlet")
public class registerUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDAO service = new UtenteDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Utente u = new Utente(username,password,"registrato");
        if (!service.doCheckUsernameAlredyUsed(u)){
            service.doAddUser(u);
            response.sendRedirect("resources/view/registerConfirmation.jsp");
        } else response.sendRedirect("resources/view/usernameAlredyInUse.jsp");

    }
}
