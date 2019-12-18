/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.LoginDAL;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.SocketThread;

/**
 *
 * @author Dat Ngo
 */
public class LoginBLL {

    public static void checkLogin(String user, String pass) {
        try {
            ResultSet rs = LoginDAL.checkLogin();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (user.equals(username) && pass.equals(password)) {
                    SocketThread.dos.writeUTF(rs.getString("managerID") + ";" + rs.getString("managerName") + ";" + username + ";" + password);
                    return;
                }
            }
            SocketThread.dos.writeUTF("fail");
        } catch (SQLException ex) {
            Logger.getLogger(LoginBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
