/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.MatchResult;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.MatchResultDAL;

/**
 *
 * @author Dat Ngo
 */
public class MatchResultBLL {

    public static DefaultTableModel dtm;

    public static void updateResult(MatchResult matchResult) {
        MatchResultDAL.updateResult(matchResult.getInformation());
    }
    public static void showChart(JTable table) {
        String data = MatchResultDAL.requestReceiveScoreChart();
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
        String[] list = data.split("%");
        //int i = 1;
        for (int i = 0; i < list.length; i++) {
            String[] arr = list[i].split(";");
            Object[] inf = new Object[10];
            inf[0] = i + 1;
            inf[1] = arr[0];
            int soTran = Integer.valueOf(arr[1]+"");
            int thang = Integer.valueOf(arr[2]+"");
            int thua = Integer.valueOf(arr[3]+"");
            int hoa = soTran - thang - thua;
            int bt;
            int sbt;
            if(arr[4].equalsIgnoreCase("null")) bt = 0;
            else bt = Integer.valueOf(arr[4]);
            if(arr[5].equalsIgnoreCase("null")) sbt = 0;
            else sbt = Integer.valueOf(arr[5]);
            inf[2] = soTran;
            inf[3] = thang;
            inf[4] = thua;
            inf[5] = hoa;
            inf[6] = bt;
            inf[7] = sbt;
            inf[8] = bt - sbt;
            inf[9] = thang * 3 + hoa;
            dtm.addRow(inf);
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
}
