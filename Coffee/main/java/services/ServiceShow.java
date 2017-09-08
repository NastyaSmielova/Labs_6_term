/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import DAO.DrinkDAO;
import DTO.DrinkDTO;
import DTO.IgredientDTO;
import java.util.List;

/**
 *
 * @author pc
 */
public class ServiceShow {

    public List<DrinkDTO> showAllDrinks(){
        TransactionHelper helper = null;
        while (helper == null) helper = TransactionHelper.getHelper();
        List<DrinkDTO> list =  DAOFactory.getDrinkDAO().getAll(helper);
        helper.closeHelper();
        return list;
    }

    public List<IgredientDTO> showAllIngridients(){
        TransactionHelper helper = null;
        while (helper == null) helper = TransactionHelper.getHelper();
         List<IgredientDTO> list =  DAOFactory.getIngridientDAO().getAll(helper);
         helper.closeHelper();
         return list;
    }
}
