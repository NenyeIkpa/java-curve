package org.example.cradlehigh.model.users.staff.academic;

import org.example.cradlehigh.model.Course;
import org.example.cradlehigh.model.users.Applicant;
import org.example.cradlehigh.model.users.Student;
import org.example.cradlehigh.model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.cradlehigh.Main.db;

public class Principal extends User {

    private final String password;
    private final List<Applicant> rejectedApplicants = new ArrayList<>();
//    Db db = new Db();

    public Principal(String firstName, String lastName, int age, char gender, String email, String phoneNumber) {
        super(firstName, lastName, age, gender, email, phoneNumber);
        password = "I'm admin";

    }

    public String getPassword() {
        return this.password;
    }

    @Override
    protected String setId() {
//        Random rand = new Random();
        return "PRCP-1";
    }

    public void getRejectedApplicants() {
        for (Applicant a: rejectedApplicants) {
            System.out.println(a);
        }
    }

    public boolean admitStudent(Applicant a) {
        boolean admissionStatus;
            if (a.getAge() < 10) {
                admissionStatus = false;
                rejectedApplicants.add(a);
            }
            else {
                Student newStudent = new Student(
                        a.getFirstName(),
                        a.getLastName(),
                        a.getAge(),
                        a.getGender(),
                        a.getEmail(),
                        a.getPhoneNumber(),
                        a.getClassApplied()
                );
                db.setStudent(newStudent);
                admissionStatus = true;
            }
            return admissionStatus;
    }

    public boolean expelStudent(String studentId) {
//        db.getStudents().removeIf(s -> Objects.equals(s.getId(), studentId));
        for (Student s: db.getStudents()) {
            if (Objects.equals(s.getId(), studentId)) {
                db.getStudents().remove(s);
                System.out.println("Student expelled!");
                return  true;
            }
        }
        return false;
    }

    public boolean assignTeacherToCourse(String teacherId, String courseName) {
        for (Teacher t: db.getTeachers()) {
            if(Objects.equals(t.getId(), teacherId)) {
                t.setCourseTaught(courseName);
                return true;
            }
        }
        return false;
    }

    public boolean assignHeadTeacher(String teacherId, String classLevelName) {
        for (Teacher t: db.getTeachers()) {
            if(Objects.equals(t.getId(), teacherId)) {
                t.setClassHeaded(classLevelName);
                t.setHeadTeacher(true);
                return true;
            }
        }
        return false;
    }

    public void addCourse(String course, String classLevel) {
        Course c = new Course(course, classLevel);
        db.setCourse(c);
    }
}
