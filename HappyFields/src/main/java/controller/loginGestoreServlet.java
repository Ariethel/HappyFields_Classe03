package controller;

import autenticazione.autenticazioneService;
import autenticazione.autenticazioneServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import registrazione.registrazioneServiceImpl;

import java.io.IOException;

@WebServlet(name = "loginGestoreServlet", value = "/loginGestoreServlet")
public class loginGestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        autenticazioneService service = new autenticazioneServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession ssn = null;
        //Se username e password corrispondono ad un utente li metto nella sessione HTTP e reindirizzo alla home
        if (service.doCheckManagerPassword(username, password)) {
            ssn = request.getSession();
            synchronized (ssn) {
                ssn.setAttribute("id", username);
                ssn.setAttribute("password", password);
            }
            response.sendRedirect("home/indexGestore.html");
        }else{
            response.sendRedirect("resources/view/Login/ErroreLogin.html");
        }
    }
}
