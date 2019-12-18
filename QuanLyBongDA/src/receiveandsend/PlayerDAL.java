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
import javax.swing.JOptionPane;

/**
 *
 * @author Dat Ngo
 */
public class PlayerDAL {
   // public static Socket socket;
    
    public static String getPlayerInformation(){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("1#4&");
            String data = ConnectServer.dis.readUTF();
            socket.close();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void requestAddPlayer(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("1#1&"+data);
//            String respond = ConnectServer.dis.readUTF();
          //  if(respond.equals("fail")) JOptionPane.showMessageDialog(null, "Thêm thất bại");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void requestUpdatePlayer(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("1#2&"+data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void requestDeletePlayer(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("1#3&"+data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static String requestPlayerNameInAClub(String data){    
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("1#5&"+data);
            String result = ConnectServer.dis.readUTF();
            socket.close();
            return result;
        } catch (IOException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String requestPlayerInAClub(String data){    
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("1#8&"+data);
            String result = ConnectServer.dis.readUTF();
            socket.close();
            return result;
        } catch (IOException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
