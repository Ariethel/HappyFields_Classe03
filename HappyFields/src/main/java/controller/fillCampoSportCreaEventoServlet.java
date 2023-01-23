package controller;

import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CampoDAO;
import java.io.IOException;

@WebServlet(name = "fillCampoSportServlet", value = "/fillCampoSportServlet")
public class fillCampoSportCreaEventoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        gestioneEventiServiceImpl service = new gestioneEventiServiceImpl();
        context.setAttribute("sport", service.doRetriveSportsName());
        CampoDAO service2 = new CampoDAO();
        context.setAttribute("campo", service2.doRetriveFieldsName());
        response.sendRedirect("resources/view/creaEvento.jsp");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/creaEvento.jsp");
        //dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
