/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import DTO.UserDTO;

/**
 *
 * @author pc
 */
public class ServiceUser {
    public UserDTO verifyUser(String name, String password){
        return DAOFactory.getUserDAO().verifyUser(name, password);
    }
}
