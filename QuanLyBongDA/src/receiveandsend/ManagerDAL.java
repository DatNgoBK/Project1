/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiveandsend;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat Ngo
 */
public class ManagerDAL {

    public static String requestManagerInformation() {
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("8#1&");
            String data = ConnectServer.dis.readUTF();
            socket.close();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
