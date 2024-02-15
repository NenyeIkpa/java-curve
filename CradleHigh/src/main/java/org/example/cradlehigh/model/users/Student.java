package org.example.cradlehigh.model.users;

import org.example.cradlehigh.model.ClassLevel;
import org.example.cradlehigh.model.Course;
import org.example.cradlehigh.service.TakeCourse;

import java.util.List;

public class Student extends User implements TakeCourse {

    private static int index;
    private static  int courseIndex;
    private String classLevel;
    String[] coursesOffered;


    public Student(String firstName, String lastName, int age, char gender, String email, String phoneNumber, String classLevel) {
        super(firstName, lastName, age, gender, email, phoneNumber);
        this.classLevel = classLevel;
        courseIndex = -1;
        this.id = setId();
    }

    @Override
    protected String setId() {
        index++;
        return "STDN-" + index;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public List<Course> getCoursesOffered(ClassLevel classLevel) {
        if (classLevel.toString() == "JSS1" || classLevel.toString() == "JSS2" || classLevel.toString() == "JSS3") {
            return classLevel.getJssCourses();
        } else {
            return classLevel.getSssCourses();
        }
    }

    public void setCoursesOffered(String course) {
        if (courseIndex == 4) {
            System.out.println("You have selected the maximum number of courses.");
        } else {
            courseIndex++;
            coursesOffered[courseIndex] = course;
        }
    }

    @Override
    public void takeCourse() {
        System.out.println("I, " + getFirstName() + getLastName() + " have picked a course!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
