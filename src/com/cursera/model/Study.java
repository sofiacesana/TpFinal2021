package com.cursera.model;

import java.util.Date;

public class Study {
    private Date initDate;
    private Date finishDate;
    private String place;
    private String location;

    // region SETTERS & GETTERS
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


    public Study (Date initDate, Date finishDate, String place, String location){
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.place = place;
        this.location = location;
    }


}
