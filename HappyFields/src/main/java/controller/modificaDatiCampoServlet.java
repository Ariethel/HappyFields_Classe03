package controller;

import gestioneDatiGestore.gestioneGestoreImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "modificaDatiCampoServlet", value = "/modificaDatiCampoServlet")
public class modificaDatiCampoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestioneGestoreImpl service = new gestioneGestoreImpl();
        service.doModificaCampo(request.getParameter("idC"), request.getParameter("nome"), Integer.parseInt(request.getParameter("num_giocatori")), request.getParameter("provincia"), request.getParameter("citta"), request.getParameter("via"), Double.parseDouble(request.getParameter("costo")), Double.parseDouble(request.getParameter("lunghezza")), Double.parseDouble(request.getParameter("larghezza")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/ModificaDati/ModificaDatiCampo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
