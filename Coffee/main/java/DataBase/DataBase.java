/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class DataBase {
        private static DataSource ds;
        public static final Logger log = Logger.getLogger(DataBase.class);
    static{
            try {
                Context ct = new javax.naming.InitialContext();
                ds = (DataSource)ct.lookup("jdbc/coffee");
            } catch (NamingException ex) {
                log.error(ex);
            }

}
    synchronized public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = (Connection) ds.getConnection();
        } catch (SQLException e) {
            log.error(e);
        } 
        return conn;
    }
}