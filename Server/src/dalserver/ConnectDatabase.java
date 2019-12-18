package dalserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDatabase {
	public static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url = "jdbc:sqlserver://localhost:1433; databaseName = QuanLyBongDa";
	public static String user = "sa";
	public static String password = "ngotiendat97";
	
	public static Connection getConnect(){
            try {
                Class.forName(driver);
                Connection cnn = DriverManager.getConnection(url, user, password);
                return cnn;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}
}
