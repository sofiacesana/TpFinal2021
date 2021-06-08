package com.cursera.repository.list;

import com.cursera.model.Course;
import com.cursera.util.State;
import com.cursera.model.User;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cursera.model.Course.*;
import static com.cursera.model.StudentNtrainer.MAX_ENROLL;

public class CourseRepository extends AbstractList<Course> {
    public static Map<Integer, Course> listofCourses = new HashMap<>();

    @Override
    public Course searchById(Integer id) {
        Course result = null;
        for (Course whatCourse: dataSource){
            if ( whatCourse.getCourseId() != null && whatCourse.getCourseId().equals(id)){
                result = whatCourse;
                break;
            }
        }
        return result;
    }

    @Override
    public void edit(Course course) {
        Course c = this.searchById(course.getCourseId());

        c.setName(c.getName());
        c.setDescription(c.getDescription());
        c.setDuration(c.getDuration());
    }

    @Override
    public List<Course> list(String field, Direction dir) {
        List<Course> orderedList = new ArrayList<>(this.dataSource);

        orderedList.sort((a,b) ->{
            int result = 0;
            if (dir == Direction.ASC){
                result = order(field, a, b);
            }
            else if (dir == Direction.DESC){
                result = order(field, b, a);
            }
            return result;
        });
        return orderedList;
    }

    private static int order(String field, Course a, Course b) {
        int result = 0;

        if (field == "id")
            result = a.getCourseId().compareTo(b.getCourseId());
        if (field == "name")
            result = a.getName().compareTo(b.getName());

        return result;
    }

    // making a map of every course with their respective id´s creator
    public void listOfCourses (Integer userId, Course course){
        listofCourses.put(userId, course);
    }

    public void enrollIntoAcourse (String nameCourse, User user){
        try{
            for (Course whatCourse: dataSource) {
                if (nameCourse == whatCourse.getName())
                    if (whatCourse.maxStudentsPerCourse < MAX_STUDENTS
                    && user.courses.length < MAX_ENROLL)
                        user.addCourse(whatCourse);
                whatCourse.students[maxStudentsPerCourse++] = user;
                break;
            }
        } catch (ArrayIndexOutOfBoundsException error){
            System.out.println(" course |WITHOUT PLACE| ");
        }
    }

    // update the state of a current course (user == student)
    public void courseState (User user, Course course){
        int search = course.getCourseId();

        for (Course whatCourse: user.courses){
            if (whatCourse.getCourseId().equals(search))
                whatCourse.setStartDate();
            whatCourse.setState(whatCourse.getState());
            if (whatCourse.getState() == State.FINISHED)
                whatCourse.setFinishDate();
        }
    }
}
