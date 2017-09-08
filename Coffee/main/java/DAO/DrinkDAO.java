/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DrinkDTO;
import DataBase.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import services.TransactionHelper;

/**
 *
 * @author pc
 */
public class DrinkDAO {
            public static final Logger log = Logger.getLogger(DrinkDAO.class);

    public Boolean receiveProducts( ArrayList<Integer> drinkIDs,TransactionHelper helper ){
        Boolean ans = true;
        Connection con = null;
        try{
            con = helper.getConnection();
            for (int i = 0; i < drinkIDs.size();i++){
                String sql = "UPDATE drink SET numPortionsDR = numPortionsDR + 1 WHERE ID_DR = ? ;" ;
                PreparedStatement prepStatemant = con.prepareStatement(sql);
                prepStatemant.setInt(1, drinkIDs.get(i));
                int resultSet = prepStatemant.executeUpdate();
                if (resultSet <= 0) {
                    helper.notOK();
                    return false;
                }
        }

        }catch (SQLException ex) {
           log.equals(ex);
        }
        return ans;
    }
    
    
    public Boolean buyProducts(ArrayList<Integer> drinkIDs,TransactionHelper helper){
        Boolean ans = true;
        Connection con = helper.getConnection();
        for (int i = 0; i < drinkIDs.size() && ans;i++){
            try {
                String sql = "UPDATE drink SET numPortionsDR = numPortionsDR - 1 WHERE (numPortionsDR > 0 AND ID_DR = ? )" ;
                PreparedStatement prepStatemant = con.prepareStatement(sql);
                prepStatemant.setInt(1,drinkIDs.get(i) );
                int resultSet = prepStatemant.executeUpdate();
                if (resultSet <= 0) ans =  false;
            } catch (SQLException ex) {
                log.error(ex);
            }
        }
        if (ans){
            return true;
        }
        else {
            helper.notOK();
            return false;
        }
        

    }
    
    
    public List<DrinkDTO> getAll(TransactionHelper helper) {
        Connection con = null;
    try {
        List<DrinkDTO> resultList = new ArrayList<DrinkDTO>();
        con = helper.getConnection();
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        String sql = "SELECT * FROM drink;";
        ResultSet resultSet = stmt.executeQuery(sql);
        while(resultSet.next()) {
            DrinkDTO drinkDTO = new DrinkDTO(resultSet.getString("nameDR"), resultSet.getInt("numPortionsDR"),resultSet.getInt("ID_DR"),resultSet.getInt("priceDR"));
            resultList.add(drinkDTO);
        } 
         return resultList;                 
    }catch (SQLException ex) {
        log.error(ex);
    } 
        return null;

    
    }
}
