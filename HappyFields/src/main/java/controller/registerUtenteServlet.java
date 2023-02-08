package controller;

import autenticazione.autenticazioneService;
import autenticazione.autenticazioneServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Utente;
import registrazione.registrazioneService;
import registrazione.registrazioneServiceImpl;

import java.io.IOException;

@WebServlet(name = "registerUtenteServlet", value = "/registerUtenteServlet")
public class registerUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        autenticazioneService service = new autenticazioneServiceImpl();
        registrazioneService serviceRegister = new registrazioneServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String provincia = request.getParameter("provincia");
        String citta = request.getParameter("citta");
        String via = request.getParameter("via");
        long telefono = Long.parseLong(request.getParameter("telefono"));
        String iban = request.getParameter("iban");
        String preferenza = request.getParameter("preferenza");
        Utente u = new Utente(username,password, provincia, citta, via, iban, preferenza, telefono);
        if (!service.doCheckUsernameAlredyUsed(u)){
            serviceRegister.doAddUser(u);
            response.sendRedirect("home/indexUtente.html");
        } else response.sendRedirect("resources/view/usernameAlredyInUse.jsp");

    }
}
