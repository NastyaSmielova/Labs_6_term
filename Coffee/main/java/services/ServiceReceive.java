/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import java.util.ArrayList;
import org.apache.log4j.Logger;
/**
 *
 * @author pc
 */
public class ServiceReceive {
        public static final Logger log = Logger.getLogger(ServiceReceive.class);


    public Boolean receiveProducts(ArrayList<Integer> idDrinks,ArrayList<Integer> idIngs){
        TransactionHelper helper = null;
        while (helper == null) helper = TransactionHelper.getHelper();
        Boolean ans  = DAOFactory.getDrinkDAO().receiveProducts(idDrinks,helper) && DAOFactory.getIngridientDAO().receiveProducts(idIngs,helper);
        helper.closeHelper();
        return ans;
    }
}
