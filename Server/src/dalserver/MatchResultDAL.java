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
import javax.swing.JTable;

/**
 *
 * @author Dat Ngo
 */
public class MatchResultDAL {

    public static Connection cnn = ConnectDatabase.getConnect();

    public static void updateResult(String... data) {
        try {
            PreparedStatement ps = cnn.prepareStatement("insert into MatchResult(scheduleID, homeTeamGoal, visitorTeamGoal) values(?, ?, ?)");
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatchResultDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet queryReceiveScoreChart() {
        try {
            String sql = "  select c.clubName as TenCLB,"
                    + "  (select count(*) from Schedule s, MatchResult mr where s.scheduleID = mr.scheduleID and (c.clubID = s.homeTeamID ) ) +  ( select count(*) from Schedule s, MatchResult mr where s.scheduleID = mr.scheduleID  and (c.clubID = s.visitorTeamID )) as SoTran,"
                    + "  (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal > mr.visitorTeamGoal) and (c.clubID = s.homeTeamID )) + (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal < mr.visitorTeamGoal) and (c.clubID = s.visitorTeamID )) as Thang,"
                    + "  (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal < mr.visitorTeamGoal) and (c.clubID = s.homeTeamID )) + (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal > mr.visitorTeamGoal) and (c.clubID = s.visitorTeamID )) as Thua,"
                    + "  (select sum(mr.homeTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.homeTeamID )) + (select sum(mr.visitorTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.visitorTeamID )) as BT,"
                    + "  (select sum(mr.visitorTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.homeTeamID )) + (select sum(mr.homeTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.visitorTeamID )) as SBT"
                    + "  from Club c Order by Thang desc";
            PreparedStatement ps = cnn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MatchResultDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
