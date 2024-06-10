/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.Duty;
import Model.Place;
import Model.SalaryInfomation;
import Model.UserType;
import Model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
/// chưa sửa read, xem lại save của đồ án
public class UserDAO {

    private static String pathStr = "E:\\LoginForm\\LoginForm\\Data\\";

    public static void saveManagerListAsChar(List<User> listManager) {
        String fileName_Char = "Manager Data List.txt";
        File fileChar = new File(pathStr + "//" + fileName_Char);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fileChar);
            for (int i = 0; i < listManager.size(); i++) {
                pw.println(listManager.get(i).getID());
                pw.println(listManager.get(i).getName());
                pw.println(listManager.get(i).getYOB());
                pw.println(listManager.get(i).getPassword());
                pw.println(listManager.get(i).getEmail());
                pw.println(listManager.get(i).getUserType());
                pw.println(listManager.get(i).getVerifyCode());
                pw.flush();
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public static void saveStaffListAsChar(List<User> listStaff) {
        String fileName_Char = "Staff Data List.txt";
        File fileChar = new File(pathStr + "//" + fileName_Char);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fileChar);
            for (int i = 0; i < listStaff.size(); i++) {
                pw.println(listStaff.get(i).getID());
                pw.println(listStaff.get(i).getName());
                pw.println(listStaff.get(i).getYOB());
                pw.println(listStaff.get(i).getPassword());
                pw.println(listStaff.get(i).getEmail());
                pw.println(listStaff.get(i).getUserType());
                pw.println(listStaff.get(i).getVerifyCode());
                pw.flush();
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public static void saveSalaryListAsChar(List<SalaryInfomation> listSalary, int month) {
        String fileName_Char = "Salary Data Month " + month + ".txt";
        File fileChar = new File(fileName_Char);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fileChar);
            for (int i = 0; i < listSalary.size(); i++) {
                pw.println(listSalary.get(i).getId());
                pw.println(listSalary.get(i).getName());
                pw.println(listSalary.get(i).getLeaveDays());
                pw.println(listSalary.get(i).getSalary());
                pw.println("$");
                pw.flush();
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public static ArrayList<User> readManagerListAsChar() {
        String fileName_Char = "Manager Data List.txt";
        ArrayList<User> managerList = new ArrayList<User>();
        BufferedReader br = null;
        try {
            String filename = pathStr + "\\" + fileName_Char;
            String line = "";

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String Id = line;
                String name = br.readLine();
                String YOB = br.readLine();
                String pass = br.readLine();
                String email = br.readLine();
                String userType = (br.readLine());
                String verifyCode = br.readLine();
                UserType type = null;
                if (userType.equals("Manager")) {
                    type = UserType.Manager;
                } else {
                    type = UserType.SecurityStaff;
                }
                User manager = new User(pass, name, email, type, YOB);
                manager.setID(Id);
                manager.setVerifyCode(verifyCode);
                managerList.add(manager);

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                br.close();
            } catch (IOException ex) {

            }
        }
        return managerList;
    }

    public static ArrayList<User> readStaffrListAsChar() {
        String fileName_Char = "Staff Data List.txt";
        ArrayList<User> staffList = new ArrayList<User>();
        BufferedReader br = null;
        try {
            String filename = pathStr + "\\" + fileName_Char;
            String line = "";
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String Id = line;
                String name = br.readLine();
                String YOB = br.readLine();
                String pass = br.readLine();
                String email = br.readLine();
                String userType = (br.readLine());
                String verifyCode = br.readLine();
                UserType type = null;
                if (userType.equals("Manager")) {
                    type = UserType.Manager;
                } else {
                    type = UserType.SecurityStaff;
                }
                User staff = new User(pass, name, email, type, YOB);
                staff.setID(Id);
                staff.setVerifyCode(verifyCode);
                staff.setDutyList(UserDAO.readDutyList().get(Id));
                staffList.add(staff);
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                br.close();
            } catch (IOException ex) {

            }
        }
        return staffList;
    }

    public static void saveDutyListAsChar(Map<String, List<Duty>> listDuty) {
        String fileName_Char = "Duty Data List.txt";
        File fileChar = new File(pathStr + "//" + fileName_Char);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fileChar);
            for (Map.Entry<String, List<Duty>> entry : listDuty.entrySet()) {
                String userName = entry.getKey();
                pw.println(userName);
                List<Duty> userDuties = entry.getValue();
                for (Duty duty : userDuties) {
                    pw.println(duty.getDate() + "*" + duty.getPlace() + "*" + duty.getStartTime() + "*"
                            + duty.getEndTime());
                }
                pw.println("$");
                pw.flush();
            }
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public static Map<String, List<Duty>> readDutyList() {
        Map<String, List<Duty>> dutyMap = new HashMap<>();
        String fileName_Char = "Duty Data List.txt";
        File fileChar = new File(pathStr + "\\" + fileName_Char);

        try ( BufferedReader br = new BufferedReader(new FileReader(fileChar))) {
            String line;
            String currentUser = null;
            List<Duty> currentDutyList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (!line.equals("$")) {
                    if (currentUser == null) {
                        currentUser = line;
                    } else {
                        String[] dutyInfo = line.split("\\*");
                        if (dutyInfo.length == 4) {
                            try {
                                LocalDate localDate = LocalDate.parse(dutyInfo[0]);
                                LocalTime startTime;
                                if (dutyInfo[2] == null) {
                                    startTime = null;
                                } else {
                                    startTime = LocalTime.parse(dutyInfo[2]);
                                }
                                LocalTime endTime;
                                if (dutyInfo[3] == null) {
                                    endTime = null;
                                } else {
                                    endTime = LocalTime.parse(dutyInfo[3]);
                                }

                                Duty duty = new Duty(localDate, getPlaceFromString(dutyInfo[1]), startTime, endTime);
                                currentDutyList.add(duty);
                            } catch (DateTimeParseException e) {

                            }
                        } else {
                            System.out.println("Skipping line with invalid format: " + line);
                        }
                    }
                } else {
                    dutyMap.put(currentUser, currentDutyList);
                    currentUser = null;
                    currentDutyList = new ArrayList<>();
                }
            }
            if (currentUser != null) {
                dutyMap.put(currentUser, currentDutyList);
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + fileName_Char);
            ex.printStackTrace();
        }

        return dutyMap;
    }

    public static Place getPlaceFromString(String placeString) {
        switch (placeString.toUpperCase()) {
            case "CANTEEN":
                return Place.Canteen;
            case "MAINGATE":
                return Place.MainGate;
            case "SUBGATE":
                return Place.SubGate;
            case "LIBRARY":
                return Place.Library;
            case "BLOCK1":
                return Place.Block1;
            case "BLOCK2":
                return Place.Block2;
            case "BLOCK3":
                return Place.Block3;
            case "PARKINGLOT":
                return Place.ParkingLot;
            case "NULL":
                return Place.Null;
            case "LEAVE":
                return Place.LEAVE;
            default:
                throw new IllegalArgumentException("Invalid place: " + placeString);
        }
    }

}
