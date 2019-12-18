/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.ClubDAL;
import dto.Club;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Dat Ngo
 */
public class ClubBLL {
    
    public static DefaultComboBoxModel<Club> dcb;

    public static void showClubInformation(JComboBox<Club> cbo){
        try {
            ResultSet rs = ClubDAL.queryClubInformation();
            dcb = new DefaultComboBoxModel<Club>();
            while (rs.next()) {
                Club club = new Club(rs.getString("clubID"), rs.getString("clubName"), rs.getString("address"), rs.getString("website"), rs.getString("stadiumID"));
                dcb.addElement(club);
            }
            cbo.setModel(dcb);
        } catch (SQLException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addClub(Club club){
        ClubDAL.queryAddClub(club.getClubID(), club.getClubName(), club.getAddress(), club.getWebsite(), club.getStadiumID());
    }

    public static void updateClub(Club club){
        ClubDAL.queryUpdateClub(club.getClubName(), club.getAddress(), club.getWebsite(), club.getStadiumID(), club.getClubID());
    }

    public static void deleteClub(Club club){
        ClubDAL.queryDeleteClub(club.getClubID());
    }
}
