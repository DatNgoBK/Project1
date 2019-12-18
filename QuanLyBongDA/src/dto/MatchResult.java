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
public class MatchResult {
    private String scheduleID;
    private int homeTeamGoal;
    private int visitorTeamGoal;

    public MatchResult() {
    }

    public MatchResult(String scheduleID, int homeTeamGoal, int visitorTeamGoal) {
        this.scheduleID = scheduleID;
        this.homeTeamGoal = homeTeamGoal;
        this.visitorTeamGoal = visitorTeamGoal;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getHomeTeamGoal() {
        return homeTeamGoal;
    }

    public void setHomeTeamGoal(int homeTeamGoal) {
        this.homeTeamGoal = homeTeamGoal;
    }

    public int getVisitorTeamGoal() {
        return visitorTeamGoal;
    }

    public void setVisitorTeamGoal(int visitorTeamGoal) {
        this.visitorTeamGoal = visitorTeamGoal;
    }

    public String getInformation() {
        return scheduleID+";"+homeTeamGoal+";"+visitorTeamGoal+";";
    }
    
}
