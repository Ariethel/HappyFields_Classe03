package controller;

import gestioneEventi.gestioneEventiService;
import gestioneEventi.gestioneEventiServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CampoDAO;

import java.io.IOException;

@WebServlet(name = "fillCampoSportServlet", value = "/fillCampoSportServlet")
public class fillCampoSportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        gestioneEventiService service = new gestioneEventiServiceImpl();
        context.setAttribute("sport", service.doRetriveSportsName());
        CampoDAO service2 = new CampoDAO();
        context.setAttribute("campo", service2.doRetriveFieldsName());
        response.sendRedirect("resources/view/Registrazione/RegistrazioneUtente.jsp");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/creaEvento.jsp");
        //dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
