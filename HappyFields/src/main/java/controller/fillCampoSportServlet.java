package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.CampoDAO;
import model.SportDAO;

import java.io.IOException;

@WebServlet(name = "fillCampoSportServlet", value = "/fillCampoSportServlet")
public class fillCampoSportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        SportDAO service = new SportDAO();
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
