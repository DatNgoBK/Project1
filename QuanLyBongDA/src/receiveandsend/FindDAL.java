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
public class FindDAL {

    public static String requestFindPlayerID(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#1&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindPlayerName(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#2&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindCoachID(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#5&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindCoachName(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#6&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindStadiumID(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#7&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindStadiumName(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#8&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindClubID(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#3&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String requestFindClubName(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#4&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String requestFindScheduleDate(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("11#9&" + data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
