/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DataBase.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author pc
 */
public class TransactionHelper {
        private static final Logger log = Logger.getLogger(TransactionHelper.class);
        private static Connection con =  DataBase.getConnection();
        private Boolean isOK = true; 
        private static Boolean isInUse = false;
        private static  TransactionHelper helper = new TransactionHelper();
        public static TransactionHelper getHelper(){
            if (!isInUse)   {
                isInUse = true;
                return helper;
            }
            return null;
        }
        public  Connection getConnection(){
            try {
                con.setAutoCommit(false);
            } catch (SQLException ex) {
                log.error(ex);
            }
            return con;
        }
        public  void closeHelper(){
            try {
                if (isOK) con.commit();
                else con.rollback();
                isInUse = false;
            } catch (SQLException ex) {
                log.error(ex);
            }
        }
        public void notOK(){
            isOK = false;
        }
        
        
        
}
