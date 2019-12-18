/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Dat Ngo
 */
public class MatchDetails {
    private String scheduleID;
    private String playerID;

    public MatchDetails(String scheduleID, String playerID) {
        this.scheduleID = scheduleID;
        this.playerID = playerID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
    public String getInformation(){
        return scheduleID+";"+playerID+";";
    }
}
