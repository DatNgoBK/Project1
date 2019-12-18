package dal;

import dto.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    
    
    public static ResultSet queryPlayerInformation() {
        try {
            String sql = "select playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubName from Player, Club where Player.clubID = Club.clubID";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void queryAddPlayer(String... data) {
        try {
            String sql = "insert into Player(playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setInt(4, Integer.valueOf(data[3]));
            ps.setInt(5, Integer.valueOf(data[4]));
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.setString(9, data[8]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryUpdatePlayer(String... data) {
        try {
            String sql = "Update Player set playerName = ?, position = ?, height = ?, weight = ?, dateOfBirth = ?, sex = ?, country =?, clubID = ? where playerID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setInt(3, Integer.valueOf(data[2]));
            ps.setInt(4, Integer.valueOf(data[3]));
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.setString(9, data[8]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryDeletePlayer(String data) {
        try {
            String sql = "Delete Player where playerID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet queryPlayerNameInAClub(String data) {
        try {
            String sql = "select playerName from Player where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet queryPlayerNameSearch(String data) {
        try {
            String sql = "select * from Player where playerName = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet queryPlayerIDSearch(String data) {
        try {
            String sql = "select playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubID from Player where playerID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet queryCountPlayerInClub(String data) {
        try {
            String sql = "SELECT COUNT(playerID) as soluong FROM Player where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
