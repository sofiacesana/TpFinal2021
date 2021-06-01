package com.cursera.model;


import java.util.Date;

public class Work {
    private Date initDate;
    private Date finishDate;
    private String position;
    private String place;
    private String location;

    // region GETTERS & SETTERS
    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
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

    // endregion


    public Work(Date initDate, Date finishDate, String position, String place, String location) {
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.position = position;
        this.place = place;
        this.location = location;
    }
}
