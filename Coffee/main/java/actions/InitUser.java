/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DTO.DrinkDTO;
import DTO.IgredientDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServiceFactory;
import services.ServiceShow;

/**
 *
 * @author pc
 */
public class InitUser implements Action{
     
     
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceShow serviceShow = ServiceFactory.getServiceShow();
        List<DrinkDTO> drinks = null;
        drinks = serviceShow.showAllDrinks();
        request.setAttribute("drinks", drinks);
        List<IgredientDTO> ingridients = serviceShow.showAllIngridients();
        request.setAttribute("ingridients", ingridients);
        return "userPage";
    }
    
}
