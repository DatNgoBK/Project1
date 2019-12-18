package dalserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoachDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    public static ResultSet queryCoachInformation() {
        try {
            String sql = "select coachID, coachName, position, email, phone, dateOfBirth, sex, country, clubName from Coach, Club where Coach.clubID = Club.clubID";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void queryAddCoach(String... data) {
        try {
            String sql = "insert into Coach(coachID, coachName, position, email, phone, dateOfBirth, sex, country, clubID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setDate(6, Date.valueOf(data[5]));
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.setString(9, data[8]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryUpdateCoach(String... data) {
        try {
            String sql = "Update Coach set coachName = ?, position = ?, email = ?, phone = ?, dateOfBirth = ?, sex = ?, country =?, clubID = ? where coachID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setDate(5, Date.valueOf(data[4]));
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.setString(9, data[8]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryDeleteCoach(String data) {
        try {
            String sql = "Delete Coach where coachID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
