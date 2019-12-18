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
public class Club {
    private String clubID;
    private String clubName;
    private String address;
    private String website;
    private String stadiumID;

    public Club() {
    }

    public Club(String clubID, String clubName, String address, String website, String stadiumID) {
        this.clubID = clubID;
        this.clubName = clubName;
        this.address = address;
        this.website = website;
        this.stadiumID = stadiumID;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(String stadiumID) {
        this.stadiumID = stadiumID;
    }

    @Override
    public String toString() {
        return this.clubName;
    }
    
    public String getInformation(){
        return clubID+";"+clubName+";"+address+";"+website+";"+stadiumID+";";
    }

}
