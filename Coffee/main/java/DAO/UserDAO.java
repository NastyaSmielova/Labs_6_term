/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UserDTO;
import DataBase.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import services.TransactionHelper;

/**
 *
 * @author pc
 */
public class UserDAO {
    
    public static final Logger log = Logger.getLogger(UserDAO.class);

    
    public Boolean buyProducts(Integer id, Integer amount, TransactionHelper helper){
        Boolean ans = true;
        Connection con = null;
        try{
            con = helper.getConnection();
                String sql = "UPDATE user SET money = money + ? WHERE ( ID_US = ? )" ;
                PreparedStatement prepStatemant = con.prepareStatement(sql);
                prepStatemant.setInt(1,amount);
                prepStatemant.setInt(2,id );
                int resultSet = prepStatemant.executeUpdate();
                if (resultSet <= 0){
                    helper.notOK();
                    return false;
                }
            

        }catch (SQLException ex) {
            helper.notOK();
            log.error(ex);
         }

        return ans;
    }
    
    public UserDTO verifyUser(String name, String password){
        String query = "SELECT * FROM user WHERE name = ? AND password = ?";

        Connection conn = null;
        try {
            conn = DataBase.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet res = statement.executeQuery();

            UserDTO user = null;
            while (res.next())
                user = new UserDTO(res.getInt("ID_US"), res.getString("name"),res.getInt("money"),res.getInt("isAdmin"));
            return user;
        } catch (SQLException ex) {
            log.error(ex);
        }  finally {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error(e);
            }
        }
        return null;
    }
}
