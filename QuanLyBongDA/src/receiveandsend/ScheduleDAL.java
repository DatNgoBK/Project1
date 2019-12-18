/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiveandsend;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Ngo
 */
public class ScheduleDAL {
    public static String requestScheduleInformation() {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("3#1&");
            String data = ConnectServer.dis.readUTF();
            socket.close();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void requestAddSchedule(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("3#2&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void requestUpdateSchedule(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("3#3&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void requestDeleteSchedule(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("3#4&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
