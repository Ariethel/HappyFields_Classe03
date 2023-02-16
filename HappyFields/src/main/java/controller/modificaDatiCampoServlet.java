package controller;

import gestioneDatiGestore.gestioneGestoreImpl;
import gestioneDatiGestore.gestioneGestoreService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "modificaDatiCampoServlet", value = "/modificaDatiCampoServlet")
public class modificaDatiCampoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestioneGestoreService service = new gestioneGestoreImpl();
        boolean b = service.doModificaCampo(request.getParameter("idC"), request.getParameter("nome"), Integer.parseInt(request.getParameter("num_giocatori")), request.getParameter("provincia"), request.getParameter("citta"), request.getParameter("via"), Double.parseDouble(request.getParameter("costo")), Double.parseDouble(request.getParameter("lunghezza")), Double.parseDouble(request.getParameter("larghezza")));
        String page;
        if (!b)
            page = "resources/view/ModificaDati/ModificaDatiErrore.html";
        else
            page = "resources/view/AreaUtenteGestore/AreaGestore.jsp";
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
