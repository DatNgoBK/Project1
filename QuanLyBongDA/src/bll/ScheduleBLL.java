/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ScheduleDAL;
import dto.Schedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dat Ngo
 */
public class ScheduleBLL {
    
    public static DefaultTableModel dtm;

    public static void showScheduleInformation(JTable table){
        try {
            ResultSet rs = ScheduleDAL.queryScheduleInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("Round");
            dtm.addColumn("Day");
            dtm.addColumn("Time");
            dtm.addColumn("StadiumID");
            dtm.addColumn("HomeTeamID");
            dtm.addColumn("VisitorTeamID");
            while (rs.next()) {
                Object[] schedule = new Object[8];
                schedule[0] = rs.getString("scheduleID");
                schedule[1] = rs.getString("scheduleName");
                schedule[2] = rs.getString("round");
                schedule[3] = rs.getString("day");
                schedule[4] = rs.getString("time");
                schedule[5] = rs.getString("stadiumID");
                schedule[6] = rs.getString("homeTeamID");
                schedule[7] = rs.getString("visitorTeamID");
                dtm.addRow(schedule);
            }
            table.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addSchedule(Schedule schedule){
        ScheduleDAL.queryAddSchedule(schedule.getScheduleID(), schedule.getScheduleName(), schedule.getRound(), schedule.getDay(), schedule.getTime(), schedule.getStadiumID(), schedule.getHomeTeamID(), schedule.getVisitorTeamID());
    }

    public static void updateSchedule(Schedule schedule){
        ScheduleDAL.queryUpdateSchedule(schedule.getScheduleName(), schedule.getRound(), schedule.getDay(), schedule.getTime(), schedule.getStadiumID(), schedule.getHomeTeamID(), schedule.getVisitorTeamID(),schedule.getScheduleID());
    }

    public static void deleteSchedule(Schedule schedule){
        ScheduleDAL.queryDeleteSchedule(schedule.getScheduleID());
    }
}
