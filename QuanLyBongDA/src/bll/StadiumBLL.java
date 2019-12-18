/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.StadiumDAL;
import dto.Stadium;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dat Ngo
 */
public class StadiumBLL {
    
    public static DefaultTableModel dtm;
    private static DefaultComboBoxModel dcb;

    public static void showStadiumInformation(JTable table){
        try {
            ResultSet rs = StadiumDAL.queryStadiumInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("foundedYear");
            dtm.addColumn("capacity");
            dtm.addColumn("note");
            while (rs.next()) {
                Object[] stadium = new Object[9];
                stadium[0] = rs.getString("stadiumID");
                stadium[1] = rs.getString("stadiumName");
                stadium[2] = rs.getString("foundedYear");
                stadium[3] = rs.getString("capacity");
                stadium[4] = rs.getString("note");
                dtm.addRow(stadium);
            }
            table.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(StadiumBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showStadiumInformationCbo(JComboBox<Stadium> cbo){
        try {
            ResultSet rs = StadiumDAL.queryStadiumInformation();
            dcb = new DefaultComboBoxModel();
            while (rs.next()) {
                Stadium stadium = new Stadium(rs.getString("stadiumID"), rs.getString("stadiumName"), rs.getString("foundedYear"), Integer.valueOf(rs.getString("capacity")), rs.getString("note"));
                dcb.addElement(stadium);
            }
            cbo.setModel(dcb);
        } catch (SQLException ex) {
            Logger.getLogger(ClubBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addStadium(Stadium stadium){
        StadiumDAL.queryAddStadium(stadium.getStadiumID(), stadium.getStadiumName(), stadium.getFoundedYear(), stadium.getCapacity()+"", stadium.getNote());
    }

    public static void updateStadium(Stadium stadium){
        StadiumDAL.queryUpdateStadium(stadium.getStadiumName(), stadium.getFoundedYear(), stadium.getCapacity()+"", stadium.getNote(), stadium.getStadiumID());
    }

    public static void deleteStadium(Stadium stadium){
        StadiumDAL.queryDeleteStadium(stadium.getStadiumID());
    }
}
