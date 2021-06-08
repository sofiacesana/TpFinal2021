package com.cursera.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Work {
    private String initDate;
    private String finishDate;
    private String position;
    private String place;
    private String location;

    // region CONSTRUCTORS

    public Work(String initDate, String finishDate, String position, String place, String location) {
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.position = position;
        this.place = place;
        this.location = location;
    }

    public Work(String initDate, String finishDate, String place, String location) {
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.place = place;
        this.location = location;
    }

    // endregion

    // region GETTERS & SETTERS

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {

        this.initDate = parseDate(initDate);

    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {

        this.finishDate = parseDate(finishDate);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static String parseDate(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date dateFormat = null;
        try {
            dateFormat = format.parse(date);
        }
        catch (ParseException ex)
        {
            System.out.println("Wrong format of date. Format required: dd/MM/yyyy");
        }
        return dateFormat.toString();
    }

    // endregion

}
