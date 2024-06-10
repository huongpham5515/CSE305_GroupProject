/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Duty {

    private LocalDate Date;
    private Place Place;
    private LocalTime StartTime;
    private LocalTime EndTime;

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public Place getPlace() {
        return Place;
    }

    public void setPlace(Place Place) {
        this.Place = Place;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalTime StartTime) {
        this.StartTime = StartTime;
    }

    public LocalTime getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalTime EndTime) {
        this.EndTime = EndTime;
    }

    public Duty(LocalDate Date, Place Place, LocalTime StartTime, LocalTime EndTime) {
        this.Date = Date;
        this.Place = Place;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
    }
}
