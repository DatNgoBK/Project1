/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalserver;

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
public class MatchDetailsDAL {
    public static ResultSet queryPlayerInGame(String...data){
        try {
            Connection cnn = ConnectDatabase.getConnect();
            PreparedStatement ps = cnn.prepareStatement("select p.playerID, p.playerName, p.clubID from Player p, MatchDetails md where md.scheduleID = ? and p.clubID = ? and p.playerID = md.playerID");
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MatchDetailsDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void addPlayerInGame(String...data){
        try {
            Connection cnn = ConnectDatabase.getConnect();
            PreparedStatement ps = cnn.prepareStatement("insert into MatchDetails(scheduleID, playerID) values(?, ?)");
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatchDetailsDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deletePlayerInGame(String...data){
        try {
            Connection cnn = ConnectDatabase.getConnect();
            PreparedStatement ps = cnn.prepareStatement("Delete MatchDetails where scheduleID = ? and playerID = ?");
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatchDetailsDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
