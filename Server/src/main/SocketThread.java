package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sendtoclient.ClubBLL;
import sendtoclient.CoachBLL;
import sendtoclient.FindBLL;
import sendtoclient.LoginBLL;
import sendtoclient.ManagerBLL;
import sendtoclient.MatchDetailsBLL;
import sendtoclient.MatchResultBLL;
import sendtoclient.PlayerBLL;
import sendtoclient.ScheduleBLL;
import sendtoclient.StadiumBLL;

public class SocketThread extends Thread {

    public Socket socket = null;
    public static DataInputStream dis;
    public static DataOutputStream dos;
    public static String st;
    public static String[] arr;

    public SocketThread(Socket socket) {
        try {
            this.socket = socket;
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
        }
    }

    public void run() {
        try {
            while (true) {
                if (dis.available() == 0) {
                    closeIOStream();
                } else {
                    st = dis.readUTF();
                    String[] info = st.split("#");
                    int n = Integer.parseInt(info[0]);
                    if (socket.isConnected()) {
                        switch (n) {
                            case 1:
                                playerProcess(info[1]);
                                break;
                            case 2:
                                coachProcess(info[1]);
                                break;
                            case 3:
                                scheduleProcess(info[1]);
                                break;
                            case 4:
                                clubProcess(info[1]);
                                break;
                            case 5:
                                stadiumProcess(info[1]);
                                break;
                            case 6:
                                matchResultProcess(info[1]);
                                break;
                            case 7:
                                functionProcess(info[1]);
                                break;
                            case 8:
                                managerProcess(info[1]);
                                break;
                            case 9:
                                MatchDetails(info[1]);
                                break;
                            case 10:
                                LoginProcess(info[1]);
                                break;
                            case 11:
                                findProcess(info[1]);
                                break;
                        }
                    }
                }

            }
        } catch (Exception e) {

        }
    }

    public static void closeIOStream() {
        try {
            dis.close();
            dos.close();
            //socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void playerProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                PlayerBLL.addPlayer(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                break;
            case 2:
                PlayerBLL.updatePlayer(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[0]);
                break;
            case 3:
                PlayerBLL.deletePlayer(data[0]);
                break;
            case 4:
                PlayerBLL.sendPlayerInformation();
                break;
            case 5:
                PlayerBLL.addPlayerNameInList(data[0]);
                break;
            case 6:
                PlayerBLL.sendResultPlayerNameSearch(data[0]);
                break;
            case 7:
                PlayerBLL.thongKePlayer(data[0]);
                break;
            case 8:
                PlayerBLL.receivePlayerInformation(data[0]);
                break;
        }
        //   socket.close();
    }

    private void coachProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                CoachBLL.addCoach(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                break;
            case 2:
                CoachBLL.updateCoach(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[0]);
                break;
            case 3:
                CoachBLL.deleteCoach(data[0]);
                break;
            case 4:
                CoachBLL.sendCoachInformation();
                break;
            case 5:
                // PlayerBLL.addPlayerNameInList(data[0]);
                break;
            case 6:
                // PlayerBLL.sendResultPlayerNameSearch(data[0]);
                break;
            case 7:
            //PlayerBLL.thongKePlayer(data[0]);
        }
        //   socket.close();
    }

    private void scheduleProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                ScheduleBLL.sendScheduleInformation();
                break;
            case 2:
                ScheduleBLL.addSchedule(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                break;
            case 3:
                ScheduleBLL.updateSchedule(data[1], data[2], data[3], data[4], data[5], data[6], data[0]);
                break;
            case 4:
                ScheduleBLL.deleteSchedule(data[0]);
                break;
            case 5:
                //   PlayerBLL.addPlayerNameInList(data[0]);
                break;
        }
        //  socket.close();
    }

    private void clubProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                ClubBLL.sendClubInformation();
                break;
            case 2:
                ClubBLL.addClub(data[0], data[1], data[2], data[3], data[4]);
                break;
            case 3:
                ClubBLL.updateClub(data[1], data[2], data[3], data[4], data[0]);
                break;
            case 4:
                ClubBLL.deleteClub(data[0]);
                break;
            case 5:
                ClubBLL.sendNumberOfPlayerOfClub();
                break;
        }
        //   socket.close();
    }

    private void stadiumProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                StadiumBLL.sendStadiumInformation();
                break;
            case 2:
                StadiumBLL.addStadium(data[0], data[1], data[2], data[3], data[4]);
                break;
            case 3:
                StadiumBLL.updateStadium(data[1], data[2], data[3], data[4], data[0]);
                break;
            case 4:
                StadiumBLL.deleteStadium(data[0]);
                break;
            case 5:
                //   PlayerBLL.addPlayerNameInList(data[0]);
                break;
        }
        //   socket.close();
    }

    private void matchResultProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                MatchResultBLL.sendScoreChart();
                break;
            case 2:
                MatchResultBLL.updateResult(data[0], data[1], data[2]);
                break;
            case 3:
                // StadiumBLL.updateStadium(data[1], data[2], data[3], data[4], data[0]);
                break;
            case 4:
                // StadiumBLL.deleteStadium(data[0]);
                break;
            case 5:
                //   PlayerBLL.addPlayerNameInList(data[0]);
                break;
        }
        //   socket.close();
    }

    private void functionProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:

                break;
            case 2:
                // MatchResultBLL.updateResult(data[0], data[1], data[2]);
                break;
            case 3:
                // StadiumBLL.updateStadium(data[1], data[2], data[3], data[4], data[0]);
                break;
            case 4:
                // StadiumBLL.deleteStadium(data[0]);
                break;
            case 5:
                //   PlayerBLL.addPlayerNameInList(data[0]);
                break;
        }
        //   socket.close();
    }

    private void managerProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                ManagerBLL.sendManagerInformation();
                break;
            case 2:
                // MatchResultBLL.updateResult(data[0], data[1], data[2]);
                break;
            case 3:
                // StadiumBLL.updateStadium(data[1], data[2], data[3], data[4], data[0]);
                break;
            case 4:
                // StadiumBLL.deleteStadium(data[0]);
                break;
            case 5:
                //   PlayerBLL.addPlayerNameInList(data[0]);
                break;
        }
        //  socket.close();
    }

    private void MatchDetails(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                MatchDetailsBLL.updatePlayerInGame(data[0], data[1]);
                break;
            case 2:
                MatchDetailsBLL.addPlayerInGame(data[0], data[1]);
                break;
            case 3:
                MatchDetailsBLL.deletePlayerInGame(data[0], data[1]);
                break;
        }
        //  socket.close();
    }

    private void LoginProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                LoginBLL.checkLogin(data[0], data[1]);
                break;
        }
        // socket.close();
    }

    private void findProcess(String par) throws IOException {
        String[] info = par.split("&");
        String[] data = null;
        if (info.length >= 2) {
            data = info[1].split(";");
        }
        int n = Integer.parseInt(info[0]);
        switch (n) {
            case 1:
                FindBLL.sendResultFindPlayerID(data[0]);
                break;
            case 2:
                FindBLL.sendResultFindPlayerName(data[0]);
                break;
            case 3:
                FindBLL.sendResultFindClubID(data[0]);
                break;
            case 4:
                FindBLL.sendResultFindClubName(data[0]);
                break;
            case 5:
                FindBLL.sendResultFindCoachID(data[0]);
                break;
            case 6:
                FindBLL.sendResultFindCoachName(data[0]);
                break;
            case 7:
                FindBLL.sendResultFindStadiumID(data[0]);
                break;
            case 8:
                FindBLL.sendResultFindStadiumName(data[0]);
                break;
            case 9:
                FindBLL.sendResultFindScheduleDate(data[0]);
                break;
        }
        //   socket.close();
    }
}
