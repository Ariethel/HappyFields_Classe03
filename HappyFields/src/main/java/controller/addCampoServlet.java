package controller;

import gestioneDatiGestore.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Campo;

import java.io.IOException;

@WebServlet(name = "addCampoServlet", value = "/addCampoServlet")
public class addCampoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestioneGestoreService service = new gestioneGestoreImpl();
        Campo c = new Campo(request.getParameter("nome"), request.getParameter("provincia"), request.getParameter("citta"), request.getParameter("via"), Double.parseDouble(request.getParameter("costo")) , Double.parseDouble(request.getParameter("lunghezza")), Double.parseDouble(request.getParameter("larghezza")), Integer.parseInt(request.getParameter("num_giocatori")));
        service.doAddCampo(c);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/ModificaDati/ModificaCampi.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
