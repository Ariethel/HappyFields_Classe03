package controller;

import confermaEventoGestore.confermaEventoGestoreImpl;
import gestioneDatiGestore.gestioneGestoreImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Campo;
import model.Evento;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "fillCampiGestoreServlet", value = "/fillCampiGestoreServlet")
public class fillCampiGestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestioneGestoreImpl service = new gestioneGestoreImpl();
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        ArrayList<Campo> campi = service.doFetchCampiById(id);
        ServletContext context = getServletContext();
        context.setAttribute("campi", campi);
        response.sendRedirect("resources/view/ModificaDati/ModificaCampi.jsp");
        /*request.setAttribute("campi", campi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/ModificaDati/ModificaCampi.jsp");
        dispatcher.forward(request, response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
