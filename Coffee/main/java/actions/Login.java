/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DTO.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServiceFactory;
import services.ServiceUser;

public class Login implements Action{

    public String loginAdmin(HttpServletRequest req, HttpServletResponse res) {
        ServiceUser serviceUser = ServiceFactory.getServiceUser(); 
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        UserDTO user = serviceUser.verifyUser(name, password);
        if(user == null || user.getIsAdmin() == 0) {
            return "LoginPage";
        }
        req.getSession().setAttribute("user", user);
        return "adminPage";
    }
    
    
    
    public String loginClient(HttpServletRequest req, HttpServletResponse res){
        ServiceUser serviceUser = ServiceFactory.getServiceUser(); 
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        UserDTO user = serviceUser.verifyUser(name, password);
        if(user == null) {
            return "LoginPage";
        }
        req.getSession().setAttribute("user", user);
        return "userPage";
    }
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ( (request.getParameter("chechBox")!=null) )return loginAdmin(request,response);
        else return loginClient(request,response);
    }
    
}