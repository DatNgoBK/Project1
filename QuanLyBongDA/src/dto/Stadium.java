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
public class Stadium {
    private String stadiumID;
    private String stadiumName;
    private String foundedYear;
    private int capacity;
    private String note;

    public Stadium() {
    }

    public Stadium(String stadiumID, String stadiumName, String foundedYear, int capacity, String note) {
        this.stadiumID = stadiumID;
        this.stadiumName = stadiumName;
        this.foundedYear = foundedYear;
        this.capacity = capacity;
        this.note = note;
    }

    public String getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(String stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return this.stadiumName;
    }
    
    public String getInformation(){
        return stadiumID+";"+stadiumName+";"+foundedYear+";"+capacity+";"+note+";";
    }
}
