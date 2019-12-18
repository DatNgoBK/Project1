package dalserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClubDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    public static ResultSet queryClubInformation(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Club");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet queryNumberOfPlayerOfClub(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select c.clubName as TênCLB, count(p.playerID) as SốLượng from Club c, Player p  where c.clubID = p.clubID  group by (c.clubName)");
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void queryAddClub(String... data) {
        try {
            String sql = "insert into Club(clubID, clubName, address, website, stadiumID) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryUpdateClub(String... data) {
        try {
            String sql = "Update Club set clubName = ?, address = ?, website = ?, stadiumID = ? where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryDeleteClub(String data) {
        try {
            String sql = "Delete Club where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
