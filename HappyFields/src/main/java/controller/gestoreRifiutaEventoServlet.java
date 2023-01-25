package controller;

import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Campo;
import model.Evento;
import model.Sport;
import persistenza.persistenzaServiceImpl;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "gestoreRifiutaEventoServlet", value = "/gestoreRifiutaEventoServlet")
public class gestoreRifiutaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("titolo");
        persistenzaServiceImpl service2 = new persistenzaServiceImpl();
        service2.doDropEvento(nome);
        response.sendRedirect("home/indexGestore.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
