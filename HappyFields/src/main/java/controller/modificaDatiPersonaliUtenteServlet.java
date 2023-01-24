package controller;

import gestioneDatiGestore.gestioneGestoreImpl;
import gestioneDatiGestore.gestioneGestoreService;
import gestioneDatiUtente.gestioneUtenteImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "modificaDatiPersonaliUtenteServlet", value = "/modificaDatiPersonaliUtenteServlet")
public class modificaDatiPersonaliUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        gestioneUtenteImpl service = new gestioneUtenteImpl();
        if(request.getParameter("provincia") != null){
            service.doChangeProvincia(request.getParameter("provincia"), id);
        }
        if(request.getParameter("citta") != null){
            service.doChangeCitta(request.getParameter("citta"), id);
        }
        if(request.getParameter("via") != null){
            service.doChangeVia(request.getParameter("via"), id);
        }
        if(request.getParameter("telefono") != null){
            service.doChangeTelefono(request.getParameter("telefono"), id);
        }
        if(request.getParameter("iban") != null){
            service.doChangeIban(request.getParameter("iban"), id);
        }
        if(request.getParameter("preferenza") != null){
            service.doChangeSport(request.getParameter("preferenza"), id);
        }
        response.sendRedirect("home/indexUtente.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
