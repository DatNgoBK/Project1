/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.ScheduleDAL;
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
public class ScheduleBLL {
    public static void sendScheduleInformation() {
        try {
            ResultSet rs = ScheduleDAL.queryScheduleInformation();
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 9; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScheduleBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addSchedule(String... data) {
        ScheduleDAL.queryAddSchedule(data);
    }

    public static void updateSchedule(String... data) {
        ScheduleDAL.queryUpdateSchedule(data);
    }

    public static void deleteSchedule(String data) {
        ScheduleDAL.queryDeleteSchedule(data);
    }
}
