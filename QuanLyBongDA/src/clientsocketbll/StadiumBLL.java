/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Stadium;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.StadiumDAL;

/**
 *
 * @author Dat Ngo
 */
public class StadiumBLL {

    public static DefaultTableModel dtm;
    public static DefaultComboBoxModel<Stadium> dcb;

    public static void showStadiumInformationCbo(JComboBox<Stadium> cbo) {
        String data = StadiumDAL.requestStadiumInformation();
        dcb = new DefaultComboBoxModel<Stadium>();
        String[] stadiumList = data.split("%");
        for (int i = 0; i < stadiumList.length; i++) {
            String[] arr = stadiumList[i].split(";");
            Stadium stadium = new Stadium(arr[0], arr[1], arr[2], Integer.valueOf(arr[3]), arr[4]);
            dcb.addElement(stadium);
        }
        cbo.setModel(dcb);
    }

    public static void showStadiumInformation(JTable table) {
        String data = StadiumDAL.requestStadiumInformation();
        dtm = new DefaultTableModel();
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

    public static void addStadium(Stadium stadium) {
        StadiumDAL.requestAddStadium(stadium.getInformation());
    }

    public static void updateStadium(Stadium stadium) {
        StadiumDAL.requestUpdateStadium(stadium.getInformation());
    }

    public static void deleteStadium(Stadium stadium) {
        StadiumDAL.requestDeleteStadium(stadium.getStadiumID());
    }
}
