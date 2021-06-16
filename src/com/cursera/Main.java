package com.cursera;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.DegreeRepository;
import com.cursera.repository.list.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static com.cursera.data.ToFiles.*;
import static com.cursera.menus.MainMenu.firstScreen;


public class Main {


    public static void main(String[] args) {
        List<User> users = readJsonUser("users.json");
        /*/for (var user : users){
            System.out.println(user.toString());
        }/*/

        List<Course> courses = new ArrayList();
        courses = readJsonCourse("courses.json");

        List degrees = new ArrayList();
        degrees = readJsonDegree("degrees.json");


        All<User> repoUser = new UserRepository();
        All<Course> repoCourse = new CourseRepository();
        All<Degree> repoDegree = new DegreeRepository();

        firstScreen(repoUser, repoCourse, repoDegree, users, courses, degrees);

    }



}
