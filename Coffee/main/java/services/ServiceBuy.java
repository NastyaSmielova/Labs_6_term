/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import DAO.DrinkDAO;
import DAO.IngridientDAO;
import DAO.UserDAO;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author pc
 */
public class ServiceBuy {
    
    public static final Logger log = Logger.getLogger(ServiceBuy.class);

    public Boolean buyProducts(ArrayList<Integer> idDrinks,ArrayList<Integer> idIngs,Integer money,Integer id){
        DrinkDAO drinkDAO = DAOFactory.getDrinkDAO();
        IngridientDAO ingridientDAO = DAOFactory.getIngridientDAO();
        UserDAO userDAO = DAOFactory.getUserDAO();
        TransactionHelper helper = null;
        while (helper == null) helper = TransactionHelper.getHelper();
        if (drinkDAO.buyProducts(idDrinks,helper) && ingridientDAO.buyProducts(idIngs,helper)&&userDAO.buyProducts(id,money,helper)) {
            helper.closeHelper();
            return true;
        }
                    
        else{
            helper.closeHelper();
            return  false;
        }
        
    }
}
