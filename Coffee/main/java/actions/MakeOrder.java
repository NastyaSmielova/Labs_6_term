/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DTO.UserDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ServiceBuy;
import services.ServiceFactory;

/**
 *
 * @author pc
 */
public class MakeOrder implements Action{
     
    public Boolean makeOrder(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        HttpSession session = req.getSession();
        if ( session != null && session.getAttribute("user") != null){
            ServiceBuy serviceBuy =  ServiceFactory.getServiceBuy();

            String[] strIngridients = req.getParameterValues("textToSendIngridients");
            String[] dataIngridients = strIngridients[0].split(",");
            ArrayList <Integer> ingIds = new ArrayList();
            for (int i = 0; i < dataIngridients.length;i++){
                if (!dataIngridients[i].isEmpty())
                ingIds.add(Integer.parseInt(dataIngridients[i]));
            }
            String[] strDrinks = req.getParameterValues("textToSendDrinks");
            String[] dataDrinks = strDrinks[0].split(",");
            ArrayList <Integer> drinksIds = new ArrayList();
            for (int i = 0; i < dataDrinks.length;i++){
                if (!dataDrinks[i].isEmpty())
                drinksIds.add(Integer.parseInt(dataDrinks[i]));
            }

            Integer money = 0;
            if (!req.getParameter("price").isEmpty()) money = Integer.parseInt(req.getParameter("price"));
            return (serviceBuy.buyProducts(drinksIds,ingIds,money,((UserDTO)session.getAttribute("user")).getID()));
        }else return false;
    } 
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (makeOrder(request,response))   return "success";
        else return "error";
    }
    
}
