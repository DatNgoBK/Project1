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
public class MatchDetailsDAL {

    public static String queryPlayerInGame(String...data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("9#1&"+data[0]+";"+data[1]+";");
            String list = ConnectServer.dis.readUTF();
            socket.close();
            return list;
        } catch (IOException ex) {
            Logger.getLogger(MatchDetailsDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void addPlayerInGame(String...data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("9#2&"+data[0]+";"+data[1]+";");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(MatchDetailsDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deletePlayerInGame(String...data) {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("9#3&"+data[0]+";"+data[1]+";");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(MatchDetailsDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
