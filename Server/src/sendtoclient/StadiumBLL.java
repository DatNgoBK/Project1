/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.StadiumDAL;
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
public class StadiumBLL {

    public static void sendStadiumInformation() {
        try {
            ResultSet rs = StadiumDAL.queryStadiumInformation();
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 6; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(StadiumBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StadiumBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addStadium(String... data) {
        StadiumDAL.queryAddStadium(data);
    }

    public static void updateStadium(String... data) {
        StadiumDAL.queryUpdateStadium(data);
    }

    public static void deleteStadium(String data) {
        StadiumDAL.queryDeleteStadium(data);
    }
}
