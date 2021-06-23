package com.cursera.repository.list;

import com.cursera.data.ToFiles;
import com.cursera.model.*;
import com.cursera.util.State;
import com.cursera.repository.AbstractList;
import com.cursera.util.Direction;

import java.util.*;

import static com.cursera.model.Course.*;
import static com.cursera.model.StudentNtrainer.MAX_ENROLL;
import static com.cursera.util.Resources.*;

public class CourseRepository extends AbstractList<Course> {

    @Override
    public Course searchById(int id) {
        Course result = null;
        for (Course whatCourse : dataSource) {
            if (whatCourse != null && whatCourse.getId() == id) {
                result = whatCourse;
                break;
            }
        }
        return result;
    }

    @Override
    public Course edit(Course editCourse) {

        Scanner scan = new Scanner(System.in);
        editInformationCourse();

        int op = optionInput(1, 3);
        switch (op) {
            case 1:
                System.out.print("Introduce your new name: ");
                editCourse.setName(scan.nextLine());
                break;
            case 2:
                System.out.print("Introduce your new course description: ");
                editCourse.setDescription(scan.nextLine());
                break;
            case 3:
                System.out.print("Introduce your new duration: ");
                editCourse.setDuration(scan.next());
                break;
            default:
                System.out.println(" Going to the principal menu... ");
        }
        return editCourse;
    }


    @Override
    public List<Course> list(String field, Direction dir) {
        List<Course> orderedList = new ArrayList<>(this.dataSource);

        orderedList.sort((a, b) -> {
            int result = 0;
            if (dir == Direction.ASC) {
                result = order(field, a, b);
            } else if (dir == Direction.DESC) {
                result = order(field, b, a);
            }
            return result;
        });
        return orderedList;
    }

    private static int order(String field, Course a, Course b) {
        int result = 0;

        if (field == "id")
            result = a.getId() - b.getId();
        if (field == "name")
            result = a.getName().compareTo(b.getName());

        return result;
    }

    public static void enrollIntoAcourse(Integer courseId, User user, List allCourses) {
        List <Course> courses = allCourses;
        Course c = new Course();
        try {
            for (int i = 0; i < allCourses.size(); i++) {
                c = (Course) allCourses.get(i);
                if (courseId == allCourses.get(i))
                    if (c.maxStudentsPerCourse < MAX_STUDENTS
                            && user.courses.length < MAX_ENROLL) {
                        user.addCourse(c);
                        c.addStudent(user);
                        allCourses.set(i, c);
                    }
                System.out.println(" Successful enrollment ");
                break;
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(" course |WITHOUT PLACE| ");
        }
    }

    // update the state of a current course (user == student)
    public static void courseState(User user, Integer id, State state) {

        if (user.courses != null) {
            for (Course whatCourse : user.courses) {
                if (whatCourse.getId() == id)
                    whatCourse.setStartDate();
                whatCourse.setState(state);
                if (whatCourse.getState() == State.FINISHED)
                    whatCourse.setFinishDate();
            }
        }
    }

    public static void dropOutCourse(Integer courseId, User user) {
        try{
            for (Course whatCourse: user.courses) {
                if (courseId == whatCourse.getId())
                    whatCourse.setState(State.DROP_OUT);
                System.out.println(" Successful drop out ");
                break;
            }
        } catch (ArrayIndexOutOfBoundsException error){
            System.out.println(" course |NON-EXISTENT| ");
        }
    }
}
