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
public class FindDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    public static ResultSet findPlayerID(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubName from Player, Club where Player.clubID = Club.clubID and playerID = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ResultSet findPlayerName(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubName from Player, Club where Player.clubID = Club.clubID and playerName = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet findClubID(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Club where clubID = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ResultSet findClubName(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Club where clubName = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet findStadiumID(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Stadium where stadiumID = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ResultSet findStadiumName(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Stadium where stadiumName = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet findCoachID(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select coachID, coachName, position, email, phone, dateOfBirth, sex, country, clubName from Coach, Club where Coach.clubID = Club.clubID and coachID = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ResultSet findCoachName(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select coachID, coachName, position, email, phone, dateOfBirth, sex, country, clubName from Coach, Club where Coach.clubID = Club.clubID and coachName = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet findScheduleDate(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select sc.scheduleID, sc.round, sc.day, sc.time, s.stadiumName, c1.clubName as homeTeamName, c2.clubName as visitorTeamName, m.managerName from Schedule sc, Stadium s, Club c1, Club c2, Manager m where sc.stadiumID = s.stadiumID and c1.clubID = sc.homeTeamID and c2.clubID = visitorTeamID and sc.managerID = m.managerID and sc.day = ?");
            ps.setString(1, data);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FindDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
