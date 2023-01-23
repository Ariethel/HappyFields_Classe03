package controller;

import gestioneDatiGestore.gestioneGestoreImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import gestioneDatiGestore.gestioneGestoreService;

@WebServlet(name = "modificaDatiGestoreServlet", value = "/modificaDatiGestoreServlet")
public class modificaDatiGestoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        gestioneGestoreService service = new gestioneGestoreImpl();
        if(request.getParameter("email") != null){
            service.doChangeEmail(request.getParameter("email"), id);
        }
        if (request.getParameter("password") != null && request.getParameter("password").equals(request.getParameter("Cpassword"))){
            service.doChangePassword(request.getParameter("password"), id);
        }

        response.sendRedirect("resources/view/AreaUtenteGestore/AreaGestore.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
