/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.ClubDAL;
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
public class ClubBLL {
    public static void sendClubInformation(){
        try {
            ResultSet rs = ClubDAL.queryClubInformation();
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
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public static void sendNumberOfPlayerOfClub(){
        try {
            ResultSet rs = ClubDAL.queryNumberOfPlayerOfClub();
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 3; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addClub(String... data) {
        ClubDAL.queryAddClub(data);
    }
    
    public static void updateClub(String... data) {
        ClubDAL.queryUpdateClub(data);
    }

    public static void deleteClub(String data) {
        ClubDAL.queryDeleteClub(data);
    }
   
}
