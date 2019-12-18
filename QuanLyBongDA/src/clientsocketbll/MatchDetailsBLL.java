/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.MatchDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.MatchDetailsDAL;

/**
 *
 * @author Dat Ngo
 */
public class MatchDetailsBLL {
    public static DefaultTableModel dtm;
    public static void updatePlayerInGame(JTable table, String scheduleID, String clubID){
        String data = MatchDetailsDAL.queryPlayerInGame(scheduleID, clubID);
        dtm = new DefaultTableModel();
        dtm.addColumn("TT");
        dtm.addColumn("Mã cầu thủ");
        dtm.addColumn("Tên Cầu Thủ");
        dtm.addColumn("clubID");
        String[] list = data.split("%");
        for (int i = 0; i < list.length; i++) {
            String[] arr = list[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
    }
    
    public static void addPlayerInGame(MatchDetails matchDetails){
        MatchDetailsDAL.addPlayerInGame(matchDetails.getScheduleID(), matchDetails.getPlayerID());
    }
    
    public static void deletePlayerInGame(MatchDetails matchDetails){
        MatchDetailsDAL.deletePlayerInGame(matchDetails.getScheduleID(), matchDetails.getPlayerID());
    }
}
