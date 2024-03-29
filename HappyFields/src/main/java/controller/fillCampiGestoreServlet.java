package controller;

import confermaEventoGestore.confermaEventoGestoreImpl;
import gestioneDatiGestore.gestioneGestoreImpl;
import gestioneDatiGestore.gestioneGestoreService;
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
        gestioneGestoreService service = new gestioneGestoreImpl();
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        ArrayList<Campo> campi = service.doFetchCampiById(id);
        ServletContext context = getServletContext();
        context.setAttribute("campi", campi);
        response.sendRedirect("resources/view/ModificaDati/ModificaCampi.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
