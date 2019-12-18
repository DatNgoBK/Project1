/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.MatchDetailsDAL;
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
public class MatchDetailsBLL {
    
    public static void updatePlayerInGame(String...data){
        try {
            ResultSet rs = MatchDetailsDAL.queryPlayerInGame(data);
            StringBuffer buffer = new StringBuffer();
            int j = 1;
            while (rs.next()) {
                buffer.append(j+";");
                for (int i = 1; i < 4; i++) {
                    
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                j++;
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(MatchDetailsBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchDetailsBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addPlayerInGame(String...data){
        MatchDetailsDAL.addPlayerInGame(data);
    }
    
    public static void deletePlayerInGame(String...data){
        MatchDetailsDAL.deletePlayerInGame(data);
    }
}
