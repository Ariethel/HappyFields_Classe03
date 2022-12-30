package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Gestore;
import model.GestoreDAO;
import model.Utente;
import model.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "registerGestoreServlet", value = "/registerGestoreServlet")
public class registerGestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestoreDAO service = new GestoreDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String provincia = request.getParameter("provincia");
        String citta = request.getParameter("citta");
        String via = request.getParameter("via");
        String iban = request.getParameter("iban");
        long telefono = Long.parseLong(request.getParameter("telefono"));
        String preferenza = request.getParameter("preferenza");
        Gestore g = new Gestore(username,password, nome, cognome, provincia, citta, via, iban, telefono);
        if (!service.doCheckUsernameAlredyUsed(g)){
            service.doAddManager(g);
            response.sendRedirect("resources/view/registerConfirmation.jsp");
        } else response.sendRedirect("resources/view/usernameAlredyInUse.jsp");

    }
}
