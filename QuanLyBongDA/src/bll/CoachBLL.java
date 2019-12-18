/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.CoachDAL;
import dto.Coach;
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
public class CoachBLL {
    
    public static DefaultTableModel dtm;

    public static void showCoachInformation(JTable table){
        try {
            ResultSet rs = CoachDAL.queryCoachInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("Position");
            dtm.addColumn("Email");
            dtm.addColumn("Phone");
            dtm.addColumn("Date Of Birth");
            dtm.addColumn("Sex");
            dtm.addColumn("Country");
            dtm.addColumn("Club ID");
            while (rs.next()) {
                Object[] coach = new Object[9];
                coach[0] = rs.getString("coachID");
                coach[1] = rs.getString("coachName");
                coach[2] = rs.getString("position");
                coach[3] = rs.getString("email");
                coach[4] = rs.getString("phone");
                coach[5] = rs.getString("dateOfBirth");
                coach[6] = rs.getString("sex");
                coach[7] = rs.getString("country");
                coach[8] = rs.getString("clubID");
                dtm.addRow(coach);
            }
            table.setModel(dtm);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(30);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(40);
            table.getColumnModel().getColumn(7).setPreferredWidth(50);
            table.getColumnModel().getColumn(8).setPreferredWidth(100);
        } catch (SQLException ex) {
            Logger.getLogger(CoachBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addCoach(Coach coach){
        CoachDAL.queryAddCoach(coach.getCoachID(), coach.getCoachName(), coach.getPosition(), coach.getEmail(), coach.getPhone(), coach.getDateOfBirth(),coach.getSex(), coach.getCountry(), coach.getClubID());
    }

    public static void updateCoach(Coach coach){
        CoachDAL.queryUpdateCoach(coach.getCoachName(), coach.getPosition(), coach.getEmail(), coach.getPhone(), coach.getDateOfBirth(),coach.getSex(), coach.getCountry(), coach.getClubID(), coach.getCoachID());
    }

    public static void deleteCoach(Coach coach){
        CoachDAL.queryDeleteCoach(coach.getCoachID());
    }
}
