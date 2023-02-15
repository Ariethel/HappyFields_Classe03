package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.*;
import persistenza.persistenzaService;
import persistenza.persistenzaServiceImpl;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "creaEventoServlet", value = "/creaEventoServlet")
public class creaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("titolo");
        Sport sport = new Sport(request.getParameter("sport"));
        CampoDAO service = new CampoDAO();
        String nome_c = request.getParameter("campo");
        Campo campo = service.doRetrieveByNome(nome_c);
        Date data = Date.valueOf(request.getParameter("data"));
        //Ormai solo dio sa come funziona questa conversione da tempo a double
        double ora = Double.parseDouble((request.getParameter("ora")).replaceAll(":", "."));
        persistenzaService service2 = new persistenzaServiceImpl();
        Evento e = new Evento(nome, sport, campo, data, ora);
        Boolean b = service2.doAddEventoAttesa(e);
        String page;
        if (!b)
            page = "resources/view/CreaEvento/CreaEventoErrore.html";
        else
            page = "resources/view/eventoCreatoCorrettamente.jsp";

        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
