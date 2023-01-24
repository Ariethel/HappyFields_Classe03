package controller;

import gestioneDatiGestore.gestioneGestoreImpl;
import gestioneDatiGestore.gestioneGestoreService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "modificaDatiPersonaliGestoreServlet", value = "/modificaDatiPersonaliGestoreServlet")
public class modificaDatiPersonaliGestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        gestioneGestoreService service = new gestioneGestoreImpl();
        if(request.getParameter("nome") != null){
            service.doChangeNome(request.getParameter("nome"), id);
        }
        if(request.getParameter("cognome") != null){
            service.doChangeCognome(request.getParameter("cognome"), id);
        }
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
        response.sendRedirect("home/indexGestore.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
