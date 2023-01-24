package controller;

import gestioneDatiGestore.gestioneGestoreImpl;
import gestioneDatiGestore.gestioneGestoreService;
import gestioneDatiUtente.gestioneUtenteImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "modificaDatiUtenteServlet", value = "/modificaDatiUtenteServlet")
public class modificaDatiUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        gestioneUtenteImpl service = new gestioneUtenteImpl();
        if(request.getParameter("username") != null){
            service.doChangeEmail(request.getParameter("username"), id);
        }
        if (request.getParameter("password") != null && request.getParameter("password").equals(request.getParameter("Cpassword"))){
            service.doChangePassword(request.getParameter("password"), id);
        }

        response.sendRedirect("home/indexUtente.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
