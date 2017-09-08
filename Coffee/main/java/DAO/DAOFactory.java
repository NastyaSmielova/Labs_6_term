/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author pc
 */
public class DAOFactory {

    private static final DrinkDAO drinkDAO = new DrinkDAO();
    private static final IngridientDAO ingridientDAO = new IngridientDAO();
    private static final UserDAO userDAO = new UserDAO();


    public static DrinkDAO getDrinkDAO() {
        return drinkDAO;
    }

    public static IngridientDAO getIngridientDAO() {
        return ingridientDAO;
    }

    public static UserDAO getUserDAO() {
        return userDAO;
    }
}
