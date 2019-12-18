/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocketbll;

import javax.swing.JTextField;
import receiveandsend.FunctionDAL;

/**
 *
 * @author Dat Ngo
 */
public class FunctionBLL {
    public static void requestNumberOfPlayer(JTextField txt, String data){
        String rs = FunctionDAL.requestNumberOfPlayerInAClub(data);
        txt.setText(rs);
    }
}
