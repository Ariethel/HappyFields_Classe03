package controller;

import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Evento;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "visualizzaEventiUtenteServlet", value = "/visualizzaEventiUtenteServlet")
public class visualizzaEventiUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gestioneEventiService service = new gestioneEventiServiceImpl();
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        ArrayList<Evento> eventi = service.doFetchUserMatch(id);
        getServletContext().setAttribute("eventi", eventi);
        response.sendRedirect("resources/view/BachecaEventi/VisualizzaEventiUtente.jsp");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/BachecaEventi/VisualizzaEventiUtente.jsp");
        //dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
