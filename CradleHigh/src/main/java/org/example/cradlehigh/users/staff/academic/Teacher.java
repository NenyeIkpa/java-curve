package org.example.cradlehigh.users.staff.academic;

import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.users.Student;
import org.example.cradlehigh.users.TakeCourse;
import org.example.cradlehigh.users.User;
import org.example.cradlehigh.users.UserType;

import java.util.List;

public class Teacher extends User implements TakeCourse {

    private int index;
    private String courseTaught;
    private String classAssigned;
    private boolean isHeadTeacher;
    private String classHeaded;

    private List<Student> students;

    public String getCourseTaught() {
        return courseTaught;
    }

    public void setCourseTaught(String courseTaught) {
        this.courseTaught = courseTaught;
    }

    public boolean isHeadTeacher() {
        return isHeadTeacher;
    }

    public void setHeadTeacher(boolean headTeacher) {
        isHeadTeacher = headTeacher;
    }

    public String getClassHeaded() {
        return classHeaded;
    }


    public Teacher(String firstName, String lastName, int age, char gender, String email, String phoneNumber, UserType category) {
        super(firstName, lastName, age, gender, email, phoneNumber, category);
    }

    @Override
    protected String setId(UserType category) {
        index++;
        return "TCHR-" + index;
    }

    public void setClassHeaded(String classHeaded) {
        this.classHeaded = classHeaded;
    }

    public String getClassAssigned() {
        return classAssigned;
    }

//    public void setClassAssigned(String classAssigned) {
//        this.classAssigned = classAssigned;
//    }

    @Override
    public void takeCourse() {
        System.out.println("I, " + getFirstName() + getLastName() + " have picked a course!");
    }

    public void printTeacher() {
        System.out.println(super.toString() + this);
    }

    public void getStudentsInMyClass() {
        Db db = new Db();
        for (Student s: db.getStudents()) {
            if (s.getClassLevel() == this.classHeaded) {
                System.out.println(s);
            }
        }

    }
}
