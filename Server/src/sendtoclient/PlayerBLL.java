/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendtoclient;

import dalserver.PlayerDAL;
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
public class PlayerBLL {

    public static void sendPlayerInformation() {
        try {
            ResultSet rs = PlayerDAL.queryPlayerInformation();
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
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addPlayer(String... data) {
            PlayerDAL.queryAddPlayer(data);
    }

    public static void updatePlayer(String... data) {
        PlayerDAL.queryUpdatePlayer(data);
    }

    public static void deletePlayer(String data) {
        PlayerDAL.queryDeletePlayer(data);
    }

    public static void addPlayerNameInList(String data) {
        try {
            ResultSet rs = PlayerDAL.queryPlayerNameInAClub(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                buffer.append(rs.getString(1));
                buffer.append(";");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendResultPlayerNameSearch(String data) {
        try {
            ResultSet rs = PlayerDAL.queryPlayerNameSearch(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 10; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void thongKePlayer(String data) {
        try {
            ResultSet rs = PlayerDAL.queryPlayerNameSearch(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 2; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void receivePlayerInformation(String data) {
        try {
            ResultSet rs = PlayerDAL.queryPlayerInAClub(data);
            StringBuffer buffer = new StringBuffer();
            while (rs.next()) {
                for (int i = 1; i < 10; i++) {
                    buffer.append(rs.getString(i));
                    buffer.append(";");
                }
                buffer.append("%");
            }
            SocketThread.dos.writeUTF(buffer.toString());
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
