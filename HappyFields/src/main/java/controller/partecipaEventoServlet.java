package controller;

import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "partecipaEventoServlet", value = "/partecipaEventoServlet")
public class partecipaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession();
        gestioneEventiService service = new gestioneEventiServiceImpl();
        service.doAddPlayer((String)ssn.getAttribute("id"), (String)request.getParameter("nome_e"));
        response.sendRedirect("home/indexUtente.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
