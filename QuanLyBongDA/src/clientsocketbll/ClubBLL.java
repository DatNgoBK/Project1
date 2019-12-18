/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Club;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.ClubDAL;

/**
 *
 * @author Dat Ngo
 */
public class ClubBLL {

    public static DefaultComboBoxModel<Club> dcb;

    public static void showClubInformation(JComboBox<Club> cbo) {
        String data = ClubDAL.requestClubInformation();
        dcb = new DefaultComboBoxModel<Club>();
        
        String[] clubList = data.split("%");
        for (int i = 0; i < clubList.length; i++) {
            String[] arr = clubList[i].split(";");
            Club club = new Club(arr[0], arr[1], arr[2], arr[3], arr[4]);
            dcb.addElement(club);
        }
        cbo.setModel(dcb);
    }
    
    public static void showNumberOfPlayerOfClub(JTable table){
        String data = ClubDAL.requestNumberOfPlayerOfClub();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Tên CLB");
        dtm.addColumn("Số Lượng Cầu Thủ");
        String[] dataList = data.split("%");
        for(int i = 0; i < dataList.length; i++){
            String[] arr = dataList[i].split(";");
            dtm.addRow(arr);
        }
        table.setModel(dtm);
    }

    public static void addClub(Club club) {
        ClubDAL.requestAddClub(club.getInformation());
    }

    public static void updateClub(Club club) {
        ClubDAL.requestUpdateClub(club.getInformation());
    }

    public static void deleteClub(Club club) {
        ClubDAL.requestDeleteClub(club.getClubID());
    }
}
