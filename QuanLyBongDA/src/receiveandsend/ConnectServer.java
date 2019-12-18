package receiveandsend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ConnectServer {
	public static DataInputStream dis;
	public static DataOutputStream dos;
	public static Socket getConnect(){
		try {
			Socket socket = new Socket("localhost", 1985);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			return socket;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kết nối tới Server thất bại !");
		}
		return null;
	}
}
