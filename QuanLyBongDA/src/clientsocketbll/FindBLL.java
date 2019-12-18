/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.FindDAL;

/**
 *
 * @author Dat Ngo
 */
public class FindBLL {

    public static void showResultFindPlayerID(JTable table, String par) {
        String data = FindDAL.requestFindPlayerID(par);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Vị trí");
        dtm.addColumn("Chiều cao");
        dtm.addColumn("Cân nặng");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Quốc tịch");
        dtm.addColumn("CLB");
        String[] playerList = data.split("%");
        for (int i = 0; i < playerList.length; i++) {
            String[] arr = playerList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public static void showResultFindPlayerName(JTable table, String par) {
        String data = FindDAL.requestFindPlayerName(par);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Vị trí");
        dtm.addColumn("Chiều cao");
        dtm.addColumn("Cân nặng");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Quốc tịch");
        dtm.addColumn("CLB");
        String[] playerList = data.split("%");
        for (int i = 0; i < playerList.length; i++) {
            String[] arr = playerList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public static void showResultFindCoachID(JTable table, String par) {
        String data = FindDAL.requestFindCoachID(par);
        DefaultTableModel dtm = new DefaultTableModel();
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

    public static void showResultFindCoachName(JTable table, String par) {
        String data = FindDAL.requestFindCoachName(par);
        DefaultTableModel dtm = new DefaultTableModel();
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

    public static void showResultFindStadiumID(JTable table, String par) {
        String data = FindDAL.requestFindStadiumID(par);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Năm thành lập");
        dtm.addColumn("Sức chứa");
        dtm.addColumn("Ghi chú");
        String[] stadiumList = data.split("%");
        for (int i = 0; i < stadiumList.length; i++) {
            String[] arr = stadiumList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
    }

    public static void showResultFindStadiumName(JTable table, String par) {
        String data = FindDAL.requestFindStadiumName(par);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Năm thành lập");
        dtm.addColumn("Sức chứa");
        dtm.addColumn("Ghi chú");
        String[] stadiumList = data.split("%");
        for (int i = 0; i < stadiumList.length; i++) {
            String[] arr = stadiumList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
    }

    public static void showResultFindClubID(JTable table, String par) {
        String data = FindDAL.requestFindClubID(par);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Website");
        dtm.addColumn("Mã SVĐ");
        String[] clubList = data.split("%");
        for (int i = 0; i < clubList.length; i++) {
            String[] arr = clubList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
    }

    public static void showResultFindClubName(JTable table, String par) {
        String data = FindDAL.requestFindClubName(par);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Website");
        dtm.addColumn("Mã SVĐ");
        String[] clubList = data.split("%");
        for (int i = 0; i < clubList.length; i++) {
            String[] arr = clubList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
    }

    public static void showResultFindScheduleDate(JTable table, String par) {
        String data = FindDAL.requestFindScheduleDate(par);
        DefaultTableModel dtm = new DefaultTableModel();
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
}
