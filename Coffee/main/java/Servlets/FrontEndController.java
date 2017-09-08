/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import actions.Action;
import actions.ActionFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class FrontEndController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Action action = ActionFactory.getAction(request.getParameter("command"));
        String view = action.handleRequest(request, response);
        dispatch(request, response, view);        
    }
    
    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view)
            throws ServletException, IOException {
        String path = "/pages/";
        String extension = ".jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path+view+extension);
        rd.forward(request, response);

     
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                                       throws ServletException, java.io.IOException {
        processRequest(request, response);

    }


     @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
                                       throws ServletException, java.io.IOException {   
        processRequest(request, response);
    }   
}
