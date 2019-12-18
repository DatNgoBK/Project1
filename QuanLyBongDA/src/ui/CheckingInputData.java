/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.Club;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Dat Ngo
 */
public class CheckingInputData {

    /**
     * Phương thức kiểm tra Tên
     *
     * @param n Độ dài tên
     * @return Kết quả kiểm tra true nếu hợp lệ
     */
    public static boolean checkName(String n) {

        if (n == null || n.length() == 0) {
            return false;
        } else {
            String strPattern = "^[a-zA-Z\\sàáạã_-]{3,25}$";

            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     * Phương thức kiểm tra SDT
     *
     * @param n Độ dài SDT
     * @return Kết quả kiểm tra true nếu hợp lệ
     */
    public static boolean checkPhone(String n) {
        if (n == null || n.length() > 13 || n.length() < 7) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    /**
     * Phương thức kiểm tra Kí tự khoảng trắng
     *
     * @param n Độ dài
     * @return Kết quả kiểm tra true nếu hợp lệ
     */
    public static boolean checkSpace(String n) {
        String strPattern = "[^ ]";
        Pattern p;
        Matcher m;
        int flag = Pattern.CASE_INSENSITIVE;
        p = Pattern.compile(strPattern, flag);
        m = p.matcher(n);
        return m.find();

    }

    public static boolean checkDuplicateID(JTable table, String id) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 0).equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkDuplicateID(JComboBox<Club> cbo, String id) {
        for (int i = 0; i < cbo.getItemCount(); i++) {
            if (cbo.getItemAt(i).getClubID().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
