package com.cursera.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Course {
    private String name;
    private String description;
    private String duration;
    private LocalDate date;
    private Date startDate;
    private Date finishDate;
    private String state;
    private User[] students;
    private int maxStudentsPerCourse;
    private static final int MAX_STUDENTS = 50;
    public List<Course> allCourses;


    // region GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // endregion

   // create a course
    public Course(String name, String description, String duration) {
        this.date = LocalDate.now();
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.students = new User[MAX_STUDENTS];
    }

    // making a list of courses with their respective creators
    public void listOfCourses (User user, Course course){
        allCourses.add(user.getmId(), course);
    }

    public void enrollIntoAcourse (String nameCourse, User user){
        try{
            for (Course whatCourse: allCourses) {
                if (nameCourse == whatCourse.getName()) {
                    user.addCourse(whatCourse);
                    whatCourse.students[maxStudentsPerCourse++] = user;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException error){
                System.out.println("|NON-EXISTENT| course");
            }
    }


}