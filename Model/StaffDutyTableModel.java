/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utils.UserDAO;
import Utils.User_Manager;
import java.sql.Time;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class StaffDutyTableModel extends AbstractTableModel {

    private User user;
    private Map<String, List<Duty>> dutyMap = new HashMap<>();
    private List<Duty> dutyList;

    public void setValue(String userID) {
        this.user = User_Manager.findUser_byID(userID);
        this.dutyMap = UserDAO.readDutyList();
        for (Map.Entry<String, List<Duty>> entry : dutyMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        this.dutyList = (List<Duty>) dutyMap.get(userID);
        LocalDate now = LocalDate.now();
        dutyList.sort((a, b) -> {
            return a.getDate().compareTo(b.getDate());
        });

        int count = 0;
        for (Duty duty : dutyList) {
            if (now.getDayOfWeek() == DayOfWeek.SUNDAY) {
                now = now.plusDays(1);
            }
            if (duty.getDate().equals(now)) {
                System.out.println(duty.getDate().getDayOfWeek());
                Object[] row = new Object[]{duty.getDate(),
                    duty.getPlace(), duty.getStartTime(),
                    duty.getEndTime()};
                listRow.add(row);
                count++;
                now = now.plusDays(1);
            }

        }
        System.out.println("count "+count);
        if (count < 7) {
            while (count < 7) {
                if (now.getDayOfWeek() != DayOfWeek.SUNDAY) {
                    Object[] row = new Object[]{now,
                        Place.Null, LocalTime.of(0, 0), LocalTime.of(0, 0)};
                    Duty newDuty = new Duty(now, Place.Null, LocalTime.of(0, 0), LocalTime.of(0, 0));
                    this.dutyList.add(newDuty);
                    listRow.add(row);
                    count++;
                    now = now.plusDays(1);
                }else{
                    now = now.plusDays(1);
                }
            }
        }
        this.user.setDutyList(this.dutyList);
        this.dutyMap.put(userID, dutyList);
        UserDAO.saveDutyListAsChar(dutyMap);

    }

    public StaffDutyTableModel() {

    }
    private List<Object[]> listRow = new ArrayList<Object[]>();
    private String[] columnHeader = {"Date", "Place", "Start time", "End time"};

    @Override
    public int getRowCount() {
        return this.listRow.size();
    }

    @Override
    public int getColumnCount() {
        return this.listRow.get(0).length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.listRow.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return this.columnHeader[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.listRow.get(0)[columnIndex].getClass();
    }

    public Duty getUserAtRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < this.user.getDutyList().size()) {
            return this.user.getDutyList().get(rowIndex);
        }
        return null;
    }
}
