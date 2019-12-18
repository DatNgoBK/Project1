/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiveandsend;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Dat Ngo
 */
public class LoginDAL {
    public static String requestLogin(String...data) {
        String list = null;
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("10#1&"+data[0]+";"+data[1]+";");
            list = ConnectServer.dis.readUTF();
            socket.close();
        } catch (IOException ex) {
        }
        return list;
    }
}
