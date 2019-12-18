/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.ManagerDAL;
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
public class ManagerBLL {

    public static void sendManagerInformation() {
        try {
            ResultSet rs = ManagerDAL.addManagerInformation();
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 5; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ManagerBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
