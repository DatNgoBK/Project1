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
public class MatchResultDAL {

    public static void updateResult(String data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("6#2&" + data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(MatchResultDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String requestReceiveScoreChart() {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("6#1&");
            String data = ConnectServer.dis.readUTF();
            socket.close();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(MatchResultDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
