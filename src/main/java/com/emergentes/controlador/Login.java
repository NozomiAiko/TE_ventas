package com.emergentes.controlador;

import com.emergentes.utiles.Validate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("loginUser.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        System.out.println("Datos...."+email+" "+password);
        //verificar datos
        Validate v= new Validate();
        if (v.checkUser(email,password)) {
            HttpSession ses= request.getSession();
            ses.setAttribute("loginUser", "ok");
            response.sendRedirect("ClienteControlador");
            
        }else{
             response.sendRedirect("loginUser.jsp");
        }
        
    }

}
