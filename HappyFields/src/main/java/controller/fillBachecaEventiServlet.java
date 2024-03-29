package controller;
import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Evento;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "fillBachecaEventiServlet", value = "/fillBachecaEventiServlet")
public class fillBachecaEventiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestioneEventiService service = new gestioneEventiServiceImpl();
        ArrayList<Evento> eventi = service.doRetriveAllMatch();
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        eventi.removeIf(evento -> service.isPartecipating(id, evento.getNome()));
        ServletContext context = getServletContext();
        context.setAttribute("eventi", eventi);
        response.sendRedirect("resources/view/BachecaEventi/BachecaEventiAttivi.jsp");
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/BachecaEventi/BachecaEventiAttivi.jsp");
        dispatcher.forward(request, response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
