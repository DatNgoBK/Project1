/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.MatchResultDAL;
import dto.MatchResult;
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
public class MatchResultBLL {
    public static DefaultTableModel dtm;
    
    public static void updateResult(MatchResult matchResult){
        MatchResultDAL.updateResult(matchResult.getScheduleID(), matchResult.getHomeTeamGoal()+"", matchResult.getVisitorTeamGoal()+"");
    }
    
    public static void showChart(JTable table){
        try {
            ResultSet rs = MatchResultDAL.queryReceiveScoreChart();
            dtm = new DefaultTableModel();
            dtm.addColumn("TT");
            dtm.addColumn("Tên Đội");
            dtm.addColumn("Số Trận");
            dtm.addColumn("Thắng");
            dtm.addColumn("Thua");
            dtm.addColumn("Hòa");
            dtm.addColumn("BT");
            dtm.addColumn("SBT");
            dtm.addColumn("HS");
            dtm.addColumn("Điểm");
            int i= 1;
            while(rs.next()){
                Object[] inf = new Object[10];
                inf[0] = i;
                inf[1] = rs.getString("TenCLB");
                int temp1 = rs.getInt("SoTran");
                int temp2 = rs.getInt("Thang");
                int temp3 = rs.getInt("Thua");
                int temp4 = temp1 - temp2 - temp3;
                int temp5 = rs.getInt("BT");
                int temp6 = rs.getInt("SBT");
                inf[2] = temp1;
                inf[3] = temp2;
                inf[4] = temp3;
                inf[5] = temp4;
                inf[6] = temp5;
                inf[7] = temp6;
                inf[8] = temp5 - temp6;
                inf[9] = temp2 * 3 + temp4;
                i++;
                dtm.addRow(inf);
            }
            table.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(MatchResultBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
