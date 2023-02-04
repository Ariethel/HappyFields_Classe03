package controller;

import confermaEventoGestore.confermaEventoGestoreImpl;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Evento;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "fillEventiAttesa", value = "/fillEventiAttesa")
public class fillEventiAttesa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        confermaEventoGestoreImpl service = new confermaEventoGestoreImpl();
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        ArrayList<Evento> eventi = service.doFetchWaitingMatch(id);
        for (Evento evento : eventi){
            System.out.println(evento.getNome());
        }
        getServletContext().setAttribute("eventi", eventi);
        response.sendRedirect("resources/view/BachecaEventi/VisualizzaEventiAttesa.jsp");
        /*request.setAttribute("eventi", eventi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/BachecaEventi/VisualizzaEventiAttesa.jsp");
        dispatcher.forward(request, response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
