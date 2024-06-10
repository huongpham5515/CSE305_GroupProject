/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.Duty;
import Model.Place;
import Model.User;
import Model.UserType;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.EncryptPassword;

/**
 *
 * @author Asus
 */
public class User_Manager {

    private static List<User> listStaff = UserDAO.readStaffrListAsChar();
    private static List<User> listManager = UserDAO.readManagerListAsChar();
    private static Map<String, List<Duty>> listDuty = UserDAO.readDutyList();

    public static Map<String, List<Duty>> getListDuty() {
        return listDuty;
    }

    public static void setListDuty(Map<String, List<Duty>> listDuty) {
        User_Manager.listDuty = listDuty;
    }

    public static int countStaff() {
        return listStaff.size();
    }

    public static int countManager() {
        return listManager.size();
    }

    public static List<User> getListStaff() {
        return listStaff;
    }

    public static List<User> getListManager() {
        return listManager;
    }

    public static User findUser_byName_Password(String userName, String password, UserType userType) {
        List<User> listUser = new ArrayList<User>();
        if (userType == UserType.Manager) {
            listUser = listManager;
        } else {
            listUser = listManager;
        }
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getName().equalsIgnoreCase(userName)) {
                if (listUser.get(i).getPassword().equals(password)) {
                    return listUser.get(i);
                }
            }
        }
        return null;
    }

    public static User findUser_byID(String ID) {
        List<User> listUser = listStaff;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getID().equals(ID)) {
                return listUser.get(i);
            }
        }
        return null;
    }

    public static boolean checkValid(User user, List<User> listUser) {
        for (User currentUser : listUser) {
            if (currentUser.getName().equals(user.getName()) || currentUser.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public static boolean addUser(User user) {
        if (user.getUserType() == UserType.Manager) {
            boolean checkValid = checkValid(user, listManager);
            if (checkValid == true) {
                listManager.add(user);
                return true;
            } else {
                return false;
            }
        } else {
            boolean checkValid = checkValid(user, listStaff);
            if (checkValid == true) {
                listStaff.add(user);
                return true;
            } else {
                return false;
            }
        }
    }

    public static void deleteUser(User user) {
        if (user.getUserType() == UserType.Manager) {
            listManager.remove(user);
        } else {
            listStaff.remove(user);
        }
    }

    public static boolean addDuty(User user, Duty duty) {
        List<Duty> userDuties = listDuty.get(user.getName());
        if (userDuties != null) {
            userDuties.add(duty);
            UserDAO.saveDutyListAsChar(listDuty); // Uncomment this line to save the updated duty list
            return true;
        } else {
            // User not found in the map, create a new entry
            List<Duty> newDutyList = new ArrayList<>();
            newDutyList.add(duty);
            listDuty.put(user.getName(), newDutyList);
            UserDAO.saveDutyListAsChar(listDuty); // Uncomment this line to save the updated duty list
            return true;
        }
    }

    public static boolean editDuty(User user, Duty duty) {
        List<Duty> userDuties = listDuty.get(user.getID());
        int count = 0;
        if (userDuties != null) {
            for (Duty userDuty : userDuties) {
                if (userDuty.getDate().equals(duty.getDate())) {
                    userDuty.setEndTime(duty.getEndTime());
                    userDuty.setStartTime(duty.getStartTime());
                    userDuty.setPlace(duty.getPlace());
                    UserDAO.saveDutyListAsChar(listDuty);
                    return true;
                }
            }
            userDuties.add(duty);
            UserDAO.saveDutyListAsChar(listDuty);
            return true;
        } else {
            return false;
        }

    }

}
