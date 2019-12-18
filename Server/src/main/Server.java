package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

public class Server {

    private static ServerSocket server;

    public static void serve() throws ClassNotFoundException, SQLException {
        try {
            System.out.println("Server is ready..");
            server = new ServerSocket(1985);

            while (true) {
                new SocketThread(server.accept()).start();
            }
        } catch (IOException ex) {
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Server.serve();
    }
}
