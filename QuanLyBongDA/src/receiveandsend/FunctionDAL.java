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
public class FunctionDAL {
    public static String requestNumberOfPlayerInAClub(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("7#1&"+data);
            String rs = ConnectServer.dis.readUTF();
            socket.close();
            return rs;
        } catch (IOException ex) {
            Logger.getLogger(FunctionDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
