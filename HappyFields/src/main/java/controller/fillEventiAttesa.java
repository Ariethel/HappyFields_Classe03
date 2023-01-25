package controller;

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
        gestioneEventiServiceImpl service = new gestioneEventiServiceImpl();
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        ArrayList<Evento> eventi = service.doFetchWaitingMatch(id);
        request.setAttribute("eventi", eventi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/BachecaEventi/VisualizzaEventiAttesa.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
