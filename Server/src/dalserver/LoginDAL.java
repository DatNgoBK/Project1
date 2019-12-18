/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Ngo
 */
public class LoginDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    public static ResultSet checkLogin(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Manager ");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
