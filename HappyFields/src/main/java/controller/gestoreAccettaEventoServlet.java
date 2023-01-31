package controller;

import confermaEventoGestore.confermaEventoGestoreImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Campo;
import model.Evento;
import model.Sport;
import persistenza.persistenzaServiceImpl;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "gestoreAccettaEventoServlet", value = "/gestoreAccettaEventoServlet")
public class gestoreAccettaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confermaEventoGestoreImpl service = new confermaEventoGestoreImpl() {
        };
        String nome = request.getParameter("titolo");
        Sport sport = service.doRetriveSport(request.getParameter("sport"));
        Campo campo = service.doRetriveCampo(request.getParameter("campo"));
        Date data = Date.valueOf(request.getParameter("data"));
        double ora = Double.parseDouble((request.getParameter("ora")).replaceAll(":", "."));
        persistenzaServiceImpl service2 = new persistenzaServiceImpl();
        Evento e = new Evento(nome, sport, campo, data, ora);
        service2.doAddEvento(e);
        service2.doDropEvento(nome);
        response.sendRedirect("home/indexGestore.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
