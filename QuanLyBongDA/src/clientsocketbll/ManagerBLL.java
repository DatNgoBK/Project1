/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Manager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import receiveandsend.ManagerDAL;

/**
 *
 * @author Dat Ngo
 */
public class ManagerBLL {
    public static DefaultComboBoxModel<Manager> dcb;

    public static void showManagerInformation(JComboBox<Manager> cbo) {
        String data = ManagerDAL.requestManagerInformation();
        dcb = new DefaultComboBoxModel<Manager>();
        
        String[] managerList = data.split("%");
        for (int i = 0; i < managerList.length; i++) {
            String[] arr = managerList[i].split(";");
            Manager manager = new Manager(arr[0], arr[1], arr[2], arr[3]);
            dcb.addElement(manager);
        }
        cbo.setModel(dcb);
    }
}
