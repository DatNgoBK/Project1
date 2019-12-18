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
public class StadiumDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    public static ResultSet queryStadiumInformation(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Stadium");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void queryAddStadium(String... data) {
        try {
            String sql = "insert into Stadium(stadiumID, stadiumName, foundedYear, capacity, note) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryUpdateStadium(String... data) {
        try {
            String sql = "Update Stadium set stadiumName = ?, foundedYear = ?, capacity = ?, note = ? where stadiumID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void queryDeleteStadium(String data) {
        try {
            String sql = "Delete Stadium where stadiumID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
