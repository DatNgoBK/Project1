/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

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
public class ScheduleDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    public static ResultSet queryScheduleInformation() {
        try {
            String sql = "select * from Schedule";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void queryAddSchedule(String... data) {
        try {
            String sql = "insert into Schedule(scheduleID, scheduleName, round, day, time, stadiumID, homeTeamID, visitorTeamID) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryUpdateSchedule(String... data) {
        try {
            String sql = "Update Schedule set scheduleName = ?, round = ?, day = ?, time = ?, stadiumID = ?, homeTeamID = ?, visitorTeamID = ? where scheduleID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setInt(3, Integer.valueOf(data[2]));
            ps.setInt(4, Integer.valueOf(data[3]));
            ps.setString(5, data[4]);
            ps.setString(6, data[5]);
            ps.setString(7, data[6]);
            ps.setString(8, data[7]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryDeleteSchedule(String data){
        try {
            String sql = "Delete Schedule where scheduleID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
