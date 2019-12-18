/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import dto.Manager;
import receiveandsend.LoginDAL;
import ui.MainFrameUI;

/**
 *
 * @author Dat Ngo
 */
public class LoginBLL {

    public static Manager checkLogin(String user, String pass) throws InterruptedException {
        String data = LoginDAL.requestLogin(user, pass);
        while (data == null) {
            data = LoginDAL.requestLogin(user, pass);
            break;
        }
        if (data != null) {
            String[] arr = data.split(";");
            if (arr.length >= 2) {
                Manager manager = new Manager(arr[0], arr[1], arr[2], arr[3]);
                return manager;
            }
        }
        return null;
    }
}
