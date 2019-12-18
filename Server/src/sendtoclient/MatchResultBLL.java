/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.MatchResultDAL;
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
public class MatchResultBLL {

    public static void sendScoreChart() {
        try {
            ResultSet rs = MatchResultDAL.queryReceiveScoreChart();
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 7; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateResult(String...data){
        MatchResultDAL.updateResult(data);
    }
    
}
