package org.example.cradlehigh.model.users.staff.academic;

import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.model.users.Student;
import org.example.cradlehigh.service.TakeCourse;
import org.example.cradlehigh.model.users.User;

import java.util.List;

public class Teacher extends User implements TakeCourse {

    private static int index;
    private List<String> courseTaught;
    private String classAssigned;
    private boolean isHeadTeacher;
    private String classHeaded;

    private List<Student> students;

    public void getCourseTaught() {
        courseTaught.forEach(System.out::println);
    }
    public void setCourseTaught(String courseName) {
        courseTaught.add(courseName);
        this.id = setId();
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


    public Teacher(String firstName, String lastName, int age, char gender, String email, String phoneNumber) {
        super(firstName, lastName, age, gender, email, phoneNumber);
        this.id = setId();
    }

    @Override
    protected String setId() {
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
