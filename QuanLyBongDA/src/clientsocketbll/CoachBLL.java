/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Coach;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.CoachDAL;

/**
 *
 * @author Dat Ngo
 */
public class CoachBLL {

    public static DefaultTableModel dtm;

    public static void showCoachInformation(JTable table) {
        String data = CoachDAL.getCoachInformation();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Vị trí");
        dtm.addColumn("Mail");
        dtm.addColumn("Điện thoại");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Quốc tịch");
        dtm.addColumn("CLB");
        String[] coachList = data.split("%");
        for (int i = 0; i < coachList.length; i++) {
            String[] arr = coachList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(80);
    }

    public static void addCoach(Coach coach) {
        CoachDAL.requestAddCoach(coach.getInformation());
    }

    public static void updateCoach(Coach coach) {
        CoachDAL.requestUpdateCoach(coach.getInformation());
    }

    public static void deleteCoach(Coach coach) {
        CoachDAL.requestDeleteCoach(coach.getCoachID());
    }
}
