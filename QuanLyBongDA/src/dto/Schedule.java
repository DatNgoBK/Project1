/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import static dto.Player.sdf;
import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author Dat Ngo
 */
public class Schedule {
    private String scheduleID;
    private int round;
    private Date day;
    private String time;
    private String stadiumID;
    private String homeTeamID;
    private String visitorTeamID;
    private String managerID;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Schedule() {
    }

    public Schedule(String scheduleID, int round, Date day, String time, String stadiumID, String homeTeamID, String visitorTeamID, String managerID) {
        this.scheduleID = scheduleID;
        this.round = round;
        this.day = day;
        this.time = time;
        this.stadiumID = stadiumID;
        this.homeTeamID = homeTeamID;
        this.visitorTeamID = visitorTeamID;
        this.managerID = managerID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(String stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getHomeTeamID() {
        return homeTeamID;
    }

    public void setHomeTeamID(String homeTeamID) {
        this.homeTeamID = homeTeamID;
    }

    public String getVisitorTeamID() {
        return visitorTeamID;
    }

    public void setVisitorTeamID(String visitorTeamID) {
        this.visitorTeamID = visitorTeamID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getInformation(){
        return scheduleID+";"+round+";"+sdf.format(day).toString()+";"+time+";"+stadiumID+";"+homeTeamID+";"+visitorTeamID+";"+managerID+";";
    }

}
