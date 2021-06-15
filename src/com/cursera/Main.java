package com.cursera;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.cursera.repository.list.*;
import static com.cursera.menus.MainMenu.firstScreen;


public class Main {

    public static void main(String[] args) {
        // Repositories
        All<User> repoUser = new UserRepository();
        All<Course> repoCourse = new CourseRepository();
        All<Degree> repoDegree = new DegreeRepository();


        firstScreen();

    }


}
