/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Asus
 */
public class SalaryInfomation {

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getLeaveDays() {
        return LeaveDays;
    }

    public void setLeaveDays(int LeaveDays) {
        this.LeaveDays = LeaveDays;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public SalaryInfomation(String Id, String Name, int LeaveDays, int Salary) {
        this.Id = Id;
        this.Name = Name;
        this.LeaveDays = LeaveDays;
        this.Salary = Salary;
    }
    private String Id;
    private String Name;
    private int LeaveDays;
    private int Salary;
}
