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
public class CoachDAL {
    public static String getCoachInformation(){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("2#4&");
            String data = ConnectServer.dis.readUTF();
            socket.close();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void requestAddCoach(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("2#1&"+data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void requestUpdateCoach(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("2#2&"+data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void requestDeleteCoach(String data){
        try {
            Socket socket = ConnectServer.getConnect();
            ConnectServer.dos.writeUTF("2#3&"+data);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
