/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Schedule;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.ScheduleDAL;

/**
 *
 * @author Dat Ngo
 */
public class ScheduleBLL {

    public static DefaultTableModel dtm;

    public static void showScheduleInformation(JTable table) {
        String data = ScheduleDAL.requestScheduleInformation();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Vòng");
        dtm.addColumn("Ngày");
        dtm.addColumn("Thời gian");
        dtm.addColumn("Sân");
        dtm.addColumn("Đội nhà");
        dtm.addColumn("Đội khách");
        dtm.addColumn("Người xác nhận");
        String[] scheduleList = data.split("%");
        for (int i = 0; i < scheduleList.length; i++) {
            String[] arr = scheduleList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(6).setPreferredWidth(110);
        table.getColumnModel().getColumn(7).setPreferredWidth(140);
    }

    public static void addSchedule(Schedule schedule) {
        ScheduleDAL.requestAddSchedule(schedule.getInformation());
    }

    public static void updateSchedule(Schedule schedule) {
        ScheduleDAL.requestUpdateSchedule(schedule.getInformation());
    }

    public static void deleteSchedule(Schedule schedule) {
        ScheduleDAL.requestDeleteSchedule(schedule.getScheduleID());
    }
}
