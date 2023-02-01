package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "eliminaEventoUtenteServlet", value = "/eliminaEventoUtenteServlet")
public class eliminaEventoUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ssn = request.getSession();
        String id = (String) ssn.getAttribute("id");
        String nomeE = request.getParameter("nomeE");
        gestioneEventi.gestioneEventiService service = new gestioneEventi.gestioneEventiServiceImpl();
        service.doDropEventoUtente(id, nomeE);
        response.sendRedirect("resources/view/AreaUtenteGestore/AreaUtente.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
