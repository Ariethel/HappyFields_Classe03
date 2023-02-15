package controller;

import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

@WebServlet(name = "cercaEventoServlet", value = "/cercaEventoServlet")
public class cercaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date data = null;
        try {
            data = Date.valueOf(request.getParameter("date"));
        }catch (IllegalArgumentException e) {
            data = null;
        }
        String provincia = request.getParameter("provincia");
        gestioneEventiService service = new gestioneEventiServiceImpl();
        ServletContext context = getServletContext();
        if (data == null)
            context.setAttribute("eventi", service.doRetriveBySearch(provincia));
        else {
            context.setAttribute("eventi", service.doRetriveBySearch(data, provincia));
        }
        String page;
        if (context.getAttribute("eventi") == null)
            page = "resources/view/BachecaEventi/VisualizzaEventiUtenteErrore.html";
        else
            page = "resources/view/BachecaEventi/EventiTrovati.jsp";
        response.sendRedirect(page);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
