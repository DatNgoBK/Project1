/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.PlayerDAL;
import dto.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dat Ngo
 */
public class PlayerBLL {

    public static DefaultTableModel dtm;
    public static DefaultTableModel dtm1;
    public static DefaultListModel<String> dlm;
    public static void showPlayerInformation(JTable table){
        try {
            ResultSet rs = PlayerDAL.queryPlayerInformation();
            dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("Position");
            dtm.addColumn("Height");
            dtm.addColumn("Weight");
            dtm.addColumn("Date Of Birth");
            dtm.addColumn("Sex");
            dtm.addColumn("Country");
            dtm.addColumn("Club");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("playerID");
                player[1] = rs.getString("playerName");
                player[2] = rs.getString("position");
                player[3] = rs.getString("height");
                player[4] = rs.getString("weight");
                player[5] = rs.getString("dateOfBirth");
                player[6] = rs.getString("sex");
                player[7] = rs.getString("country");
                player[8] = rs.getString("clubName");
                dtm.addRow(player);
            }
            table.setModel(dtm);
//            table.getColumnModel().getColumn(0).setPreferredWidth(50);
//            table.getColumnModel().getColumn(1).setPreferredWidth(150);
//            table.getColumnModel().getColumn(2).setPreferredWidth(100);
//            table.getColumnModel().getColumn(3).setPreferredWidth(30);
//            table.getColumnModel().getColumn(4).setPreferredWidth(30);
//            table.getColumnModel().getColumn(5).setPreferredWidth(100);
//            table.getColumnModel().getColumn(6).setPreferredWidth(40);
//            table.getColumnModel().getColumn(7).setPreferredWidth(50);
//            table.getColumnModel().getColumn(8).setPreferredWidth(100);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addPlayer(Player player){
        PlayerDAL.queryAddPlayer(player.getPlayerID(), player.getPlayerName(), player.getPosition(), player.getHeight()+"", player.getWeight()+"", player.getDateOfBirth(), player.getSex(),  player.getCountry(), player.getClubID());
    }

    public static void updatePlayer(Player player){
        PlayerDAL.queryUpdatePlayer(player.getPlayerName(), player.getPosition(), player.getHeight()+"", player.getWeight()+"", player.getDateOfBirth(), player.getSex(),  player.getCountry(), player.getClubID(), player.getPlayerID());
    }

    public static void deletePlayer(Player player){
        PlayerDAL.queryDeletePlayer(player.getPlayerID());
    }
    
    public static void addPlayerNameInList(JList<String> list, String data){
        try {
            ResultSet rs = PlayerDAL.queryPlayerNameInAClub(data);
            dlm = new DefaultListModel<String>();
            while(rs.next()){
                dlm.addElement(rs.getString("playerName"));
            }
            list.setModel(dlm);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showResultPlayerNameSearch(JTable table, String playerName){
        ResultSet rs = PlayerDAL.queryPlayerNameSearch(playerName);
        try {
            dtm1 = new DefaultTableModel();
            dtm1.addColumn("ID");
            dtm1.addColumn("Name");
            dtm1.addColumn("Position");
            dtm1.addColumn("Height");
            dtm1.addColumn("Weight");
            dtm1.addColumn("Date Of Birth");
            dtm1.addColumn("Sex");
            dtm1.addColumn("Country");
            dtm1.addColumn("ClubID");
            while (rs.next()) {
                Object[] player = new Object[9];
                player[0] = rs.getString("playerID");
                player[1] = rs.getString("playerName");
                player[2] = rs.getString("position");
                player[3] = rs.getString("height");
                player[4] = rs.getString("weight");
                player[5] = rs.getString("dateOfBirth");
                player[6] = rs.getString("sex");
                player[7] = rs.getString("country");
                player[8] = rs.getString("clubID");
                dtm1.addRow(player);
            }
            table.setModel(dtm1);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void thongKePlayer(String data, JTextField txtKQ){
        try {
            ResultSet rs = PlayerDAL.queryCountPlayerInClub(data);
            while(rs.next())
                txtKQ.setText(rs.getString("soluong")+ ""); 
        } catch (SQLException ex) {
            Logger.getLogger(PlayerBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
