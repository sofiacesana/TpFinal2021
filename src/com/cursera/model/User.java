package com.cursera.model;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static com.cursera.model.StudentNtrainer.MAX_ENROLL;
import static com.cursera.model.StudentNtrainer.MAX_SUBMIT;

public class User {
    private static int mId;
    private int id;
    private String name;
    private String surname;
    private String username;
    private String psw;
    private String DNI;
    private String telephone;
    private String location;
    private String province;
    private String country;
    private Work[] works;
    private int worksIndex;
    private Study[] studies;
    private int studiesIndex;
    private String interests;
    private int firm;
    public Course[] courses = new Course[MAX_SUBMIT];
    public Course[] enrolled = new Course[MAX_ENROLL];
    private static int coursesIndex;
    public Degree[] degrees = new Degree[MAX_DEGREES];
    private static int degreesIndex;
    private static final int MAX_W_S = 6;
    public static final int MAX_DEGREES = 12;

    // region CONSTRUCTORS

    public User() {
        id = ++mId;

    }

    public User(String name, String surname, String username, String psw, String DNI, String telephone,
                String location, String province, String country) {
        this.id = ++mId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.psw = psw;
        this.DNI = DNI;
        this.telephone = telephone;
        this.location = location;
        this.province = province;
        this.country = country;
        this.studies = new Study[MAX_W_S];
        this.works = new Work[MAX_W_S];
        this.degrees = new Degree[MAX_DEGREES];
    }

    public User(String name, String surname, String username, String psw, String DNI, String telephone,
                String location, String province, String country, String interests) {
        this(name, surname, username, psw, DNI, telephone, location, province, country);
        this.interests = interests;
    }

    public User(String name, String surname, String username, String psw, String DNI, String telephone,
                String location, String province, String country, int firm) {
        this(name, surname, username, psw, DNI, telephone, location, province, country);
        this.firm = firm;
    }

    public User(String name, String surname, String username, String psw, String DNI, String telephone,
                String location, String province, String country, String interests, int firm) {
        this(name, surname, username, psw, DNI, telephone, location, province, country, interests);
        this.firm = firm;
    }
    // endregion

    // region GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getFirm() {
        return firm;
    }

    public void setFirm(int firm) {
        this.firm = firm;
    }


    // endregion

    // OTHER METHODS

    public void addWork (Work work){
        this.works[worksIndex++] = work;
    }

    public void addCourse (Course course) {
        if (courses != null) {
            for (coursesIndex = 0; coursesIndex < courses.length; coursesIndex++) {
                courses[coursesIndex] = course;
            }
        }
    }


    public void addDegree (Degree degree){
            this.degrees[degreesIndex++] = degree;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                ", DNI='" + DNI + '\'' +
                ", telephone='" + telephone + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", works=" + Arrays.toString(works) +
                ", studies= " + Arrays.toString(studies) +
                ", interests= " + interests + '\'' +
                ", firm= " + firm +
                ", degrees= " + Arrays.toString(degrees) +
                '}';
    }
}