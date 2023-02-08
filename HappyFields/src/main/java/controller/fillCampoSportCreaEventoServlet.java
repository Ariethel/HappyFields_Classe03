package controller;

import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CampoDAO;
import java.io.IOException;

@WebServlet(name = "fillCampoSportCreaEventoServlet", value = "/fillCampoSportCreaEventoServlet")
public class fillCampoSportCreaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        gestioneEventiService service = new gestioneEventiServiceImpl();
        context.setAttribute("sport", service.doRetriveSportsName());
        CampoDAO service2 = new CampoDAO();
        context.setAttribute("campo", service2.doRetriveFieldsName());
        response.sendRedirect("resources/view/CreaEvento/CreaEvento.jsp");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/creaEvento.jsp");
        //dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
