/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gaetan
 */

 /**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/index")
public class Connect extends HttpServlet {
 
    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        ServletContext context = getServletContext();
        //retrieval of the corresponding user, if exists
        User storedUser = (User)context.getAttribute(login);
 
        /* ** FORM CHECK-OUT ** */
        //user doesn't exist or bad password
        if(storedUser==null || !password.equals(storedUser.getPassword())) {
            session.setAttribute("hasErrors", true);
            session.setAttribute("isConnected", false);
            //redirect to login page
            response.sendRedirect("login.jsp");
        }
        else if(password.equals(storedUser.getPassword())){
            session.setAttribute("isConnected", true);
            int hc = storedUser.getId().hashCode();
            session.setAttribute(login, hc);
            //redirect to the member welcome page
            response.sendRedirect("member.jsp?id="+hc);
        }
    }
 
    /** 
    * Returns a short description of the servlet.
     * @return 
    */
    @Override
    public String getServletInfo() {
        return "Servlet dedicated to user connection";
    }
 
}