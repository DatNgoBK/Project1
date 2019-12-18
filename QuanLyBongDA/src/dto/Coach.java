/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author Dat Ngo
 */
public class Coach {
    private String coachID;
    private String coachName;
    private String position;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String sex;
    private String country;
    private String clubID;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Coach() {
    }

    public Coach(String coachID, String coachName, String position, String email, String phone, Date dateOfBirth, String sex, String country, String clubID) {
        this.coachID = coachID;
        this.coachName = coachName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.country = country;
        this.clubID = clubID;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getInformation(){
        return coachID+";"+coachName+";"+position+";"+email+";"+phone+";"+sdf.format(dateOfBirth).toString()+";"+sex+";"+country+";"+clubID+";";
    }

}
