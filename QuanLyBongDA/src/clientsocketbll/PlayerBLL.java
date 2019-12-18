/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Player;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import receiveandsend.PlayerDAL;

/**
 *
 * @author Dat Ngo
 */
public class PlayerBLL {

    public static DefaultTableModel dtm;
    public static DefaultListModel<String> dlm;

    public static void showPlayerInformation(JTable table) {
        String data = PlayerDAL.getPlayerInformation();
        dtm = new DefaultTableModel();
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

    public static void addPlayer(Player player) {
        PlayerDAL.requestAddPlayer(player.getInformation());
    }

    public static void updatePlayer(Player player) {
        PlayerDAL.requestUpdatePlayer(player.getInformation());
    }

    public static void deletePlayer(Player player) {
        PlayerDAL.requestDeletePlayer(player.getPlayerID());
    }

    public static void addPlayerNameInList(JList<String> list, String clubID) {
        String data = PlayerDAL.requestPlayerNameInAClub(clubID);
        dlm = new DefaultListModel<>();
        String[] nameList = data.split(";");
        for (int i = 0; i < nameList.length; i++) {
            dlm.addElement(nameList[i]);
        }
        list.setModel(dlm);
    }

    public static void receivePlayerInformation(String teamID, JComboBox<Player> cbo) {
        String data = PlayerDAL.requestPlayerInAClub(teamID);
        DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        String[] playerList = data.split("%");
        for (int i = 0; i < playerList.length; i++) {
            String[] arr = playerList[i].split(";");
            Player player = new Player(arr[0], arr[1], arr[2], Integer.valueOf(arr[3]), Integer.valueOf(arr[4]), Date.valueOf(arr[5]), arr[6], arr[7], arr[8]);
            dcb.addElement(player);
        }
        cbo.setModel(dcb);
    }

}
