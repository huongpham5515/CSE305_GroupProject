package Model;

import Utils.User_Manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class User implements Serializable {

    private String Name;
    private String ID;
    private String YOB;
    private String Password;
    private String Email;
    private UserType UserType;
    private String VerifyCode;
    private List<Duty> DutyList;

    public List<Duty> restoreDutyList() {
        for (User user : User_Manager.getListStaff()) {
            if (user.getID().equals(this.Password)) {
                return user.getDutyList();
            }
        }
        return null;
    }

    public List<Duty> getDutyList() {
        return this.DutyList;
    }

    public void setDutyList(List<Duty> DutyList) {
        this.DutyList = DutyList;
    }

    public String getYOB() {
        return YOB;
    }

    public void setYOB(String YOB) {
        this.YOB = YOB;
    }

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String VerifyCode) {
        this.VerifyCode = VerifyCode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public UserType getUserType() {
        return UserType;
    }

    public void setUserType(UserType UserType) {
        this.UserType = UserType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public User(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    public User(String Password, String Name, String Email, UserType Usertype, String YOB) {
        this.ID = UUID.randomUUID().toString();
        this.Password = Password;
        this.YOB = YOB;
        this.Name = Name;
        this.Email = Email;
        this.UserType = Usertype;
        this.VerifyCode = YOB + this.Name.length();
    }
     
}
