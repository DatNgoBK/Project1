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
public class StadiumDAL {

    public static String requestStadiumInformation() {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("5#1&");
            String data = ConnectServer.dis.readUTF();
            socket.close();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void requestAddStadium(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("5#2&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void requestUpdateStadium(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("5#3&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void requestDeleteStadium(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("5#4&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
