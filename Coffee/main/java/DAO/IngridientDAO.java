/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.IgredientDTO;
import DataBase.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import services.TransactionHelper;

/**
 *
 * @author pc
 */
public class IngridientDAO {
    public static final Logger log = Logger.getLogger(IngridientDAO.class);

    public Boolean receiveProducts(ArrayList<Integer> ingIDs,TransactionHelper helper){
        Boolean ans = true;
        Connection con = null;

        try{
            con = helper.getConnection();
            for (int i = 0; i < ingIDs.size();i++){
                String sql = "UPDATE ingredient SET numPortionsING = numPortionsING + 1 WHERE ( ID_ING = ? )" ;
                PreparedStatement prepStatemant = con.prepareStatement(sql);
                prepStatemant.setInt(1,ingIDs.get(i) );
                int resultSet = prepStatemant.executeUpdate();
                if (resultSet <= 0) {
                    helper.notOK();
                    return false;
                }
            }

        }catch (SQLException ex) {
            log.error(ex);
        }
        
        return ans;
    }
    
    
    
    public Boolean buyProducts(ArrayList<Integer> ingIDs,TransactionHelper helper){
        Boolean ans = true;
        Connection con = null;
        try{
            con = helper.getConnection();
            for (int i = 0; i < ingIDs.size();i++){
                String sql = "UPDATE ingredient SET numPortionsING = numPortionsING - 1 WHERE (numPortionsING > 0 AND ID_ING = ? )" ;
                
                PreparedStatement prepStatemant = con.prepareStatement(sql);
                prepStatemant.setInt(1,ingIDs.get(i) );
                int resultSet = prepStatemant.executeUpdate();
                if (resultSet <= 0) ans = false;
            }
            if (ans){
                return true;
            }
            else {
                helper.notOK();
                return false;
            }
        }catch (SQLException ex) {
            
            log.error(ex);
        }
        return false;
    }
    
    public List<IgredientDTO> getAll(TransactionHelper helper) {
        Connection con = null;
    try {
        List<IgredientDTO> resultList = new ArrayList<IgredientDTO>();
        con = helper.getConnection();
        String sql = "SELECT * FROM ingredient;";
        PreparedStatement prepStatemant = con.prepareStatement(sql);
        ResultSet resultSet = prepStatemant.executeQuery();
        while(resultSet.next()) {
            IgredientDTO igredientDTO = new IgredientDTO(resultSet.getString("nameING"), resultSet.getInt("numPortionsING"),resultSet.getInt("ID_ING"),resultSet.getInt("priceING"));
            resultList.add(igredientDTO);
            
        } 
        return resultList;                 

    }catch (SQLException ex) {
        log.error(ex);
    }
        return null;

    
    }
    
}
