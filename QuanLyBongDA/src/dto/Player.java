/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import static dto.Coach.sdf;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Dat Ngo
 */
public class Player {
    private String playerID;
    private String playerName;
    private String position;
    private int height;
    private int weight;
    private Date dateOfBirth;
    private String sex;
    private String country;
    private String clubID;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Player() {
    }

    public Player(String playerID, String playerName, String position, int height, int weight, Date dateOfBirth, String sex, String country, String clubID) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.country = country;
        this.clubID = clubID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getInformation() {
        return playerID+";"+playerName+";"+position+";"+height+";"+weight+";"+sdf.format(dateOfBirth).toString()+";"+sex+";"+country+";"+clubID+";";
    }

    @Override
    public String toString() {
        return playerName;
    }

    
    
}
