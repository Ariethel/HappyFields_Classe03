package controller;

import autenticazione.autenticazioneService;
import autenticazione.autenticazioneServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Gestore;
import model.Utente;
import registrazione.registrazioneService;
import registrazione.registrazioneServiceImpl;

import java.io.IOException;

@WebServlet(name = "registerGestoreServlet", value = "/registerGestoreServlet")
public class registerGestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registrazioneService serviceRegister = new registrazioneServiceImpl();
        autenticazioneService service = new autenticazioneServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String provincia = request.getParameter("provincia");
        String citta = request.getParameter("citta");
        String via = request.getParameter("via");
        String iban = request.getParameter("iban");
        long telefono = Long.parseLong(request.getParameter("telefono"));
        Gestore g = new Gestore(username,password, nome, cognome, provincia, citta, via, iban, telefono);
        if (!service.doCheckUsernameManagerAlredyUsed(g)){
            serviceRegister.doAddManager(g);
            response.sendRedirect("home/indexGestore.html");
        } else response.sendRedirect("resources/view/usernameAlredyInUse.jsp");

    }
}
