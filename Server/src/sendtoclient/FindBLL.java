/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.FindDAL;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.SocketThread;

/**
 *
 * @author Dat Ngo
 */
public class FindBLL {

    public static void sendResultFindPlayerID(String data) {
        try {
            ResultSet rs = FindDAL.findPlayerID(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 10; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindPlayerName(String data) {
        try {
            ResultSet rs = FindDAL.findPlayerName(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 10; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindClubID(String data) {
        try {
            ResultSet rs = FindDAL.findClubID(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 6; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindClubName(String data) {
        try {
            ResultSet rs = FindDAL.findClubName(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 6; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindStadiumName(String data) {
        try {
            ResultSet rs = FindDAL.findStadiumName(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 6; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindStadiumID(String data) {
        try {
            ResultSet rs = FindDAL.findStadiumID(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 6; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindCoachID(String data) {
        try {
            ResultSet rs = FindDAL.findCoachID(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 10; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultFindCoachName(String data) {
        try {
            ResultSet rs = FindDAL.findCoachName(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 10; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void sendResultFindScheduleDate(String data) {
        try {
            ResultSet rs = FindDAL.findScheduleDate(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 9; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FindBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
