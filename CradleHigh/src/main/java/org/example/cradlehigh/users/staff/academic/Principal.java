package org.example.cradlehigh.users.staff.academic;

import org.example.cradlehigh.articles.Course;
import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.users.Applicant;
import org.example.cradlehigh.users.Student;
import org.example.cradlehigh.users.User;
import org.example.cradlehigh.users.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Principal extends User {

    private final String password;
    private final List<Applicant> rejectedApplicants = new ArrayList<Applicant>();
    Db db = new Db();

    public Principal(String firstName, String lastName, int age, char gender, String email, String phoneNumber, UserType category) {
        super(firstName, lastName, age, gender, email, phoneNumber, category);
        password = "I'm admin";

    }

    public String getPassword() {
        return this.password;
    }

    @Override
    protected String setId(UserType category) {
//        Random rand = new Random();
        return "PRCP-1";
    }

    public String acceptApplication(Applicant applicant) {
        db.setApplicant(applicant);
        System.out.println("Application received!");
        return applicant.getId();
    }

    public int admitStudent(List<Applicant> applicants) {
        int admittedCount = 0;
        for (Applicant a: applicants) {
            if (a.getAge() < 10) {
                rejectedApplicants.add(a);
            }
            else {
                admittedCount++;
                Student newStudent = new Student(
                        a.getFirstName(),
                        a.getLastName(),
                        a.getAge(),
                        a.getGender(),
                        a.getEmail(),
                        a.getPhoneNumber(),
                        a.getClassApplied(),
                        UserType.STUDENT
                );
                db.setStudent(newStudent);
            }
        }
        System.out.println("Admission process complete!");
        return admittedCount;

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

    public List<Student> getStudents() {
        for(Student s: db.getStudents()) {
            System.out.println(s);
        }
        return db.getStudents();
    }

    public String getStudent(String firstName, String lastName) {
        for(Student s: db.getStudents()) {
            if (Objects.equals(s.getFirstName(), firstName) && Objects.equals(s.getLastName(), lastName)) {
                System.out.println(s);
                return s.getId();
            }
        }
        System.out.println("This student does not exist.");
        return null;
    }

    public List<Teacher> getTeachers() {
        return db.getTeachers();
    }
    public void printTeachers() {
        for(Teacher t: db.getTeachers()) {
            System.out.println(t);
        }
    }

    public void printTeacher(String teacherId) {
        for(Teacher t: db.getTeachers()) {
            if (teacherId == t.getId()) {
                System.out.println(t);
            }
        }
    }
    public void printStudent(String studentId) {
        for(Student s: db.getStudents()) {
            if (studentId == s.getId()) {
                System.out.println(s);
            }
        }
    }

    public List<Applicant> getApplicants() {
        return db.getApplicants();
    }

    public void printApplicants() {
        for(Applicant a: db.getApplicants()) {
            System.out.println(a);
        }
    }

    public void getRejectedApplicants() {
        for(Applicant r: rejectedApplicants) {
            System.out.println(r);
        }
    }


    public void getTeacher(String firstName, String lastName) {
        for(Teacher t: db.getTeachers()) {
            if (Objects.equals(t.getFirstName(), firstName) && Objects.equals(t.getLastName(), lastName)) {
                System.out.println(t);
                return;
            }
        }
        System.out.println("This teacher does not exist.");
    }

    public void assignTeacherToCourse(String teacherId, String courseName) {

        db.getTeachers().forEach(teacher -> {
            if (teacher.getId() == teacherId) {
                teacher.setCourseTaught(courseName);
            }
        });;

    }

    public void assignHeadTeacher(String teacherId, String classLevel) {
        Db db = new Db();
        db.getTeachers().forEach(teacher -> {
            if (teacher.getId() == teacherId) {
                teacher.setClassHeaded(classLevel);
                teacher.setHeadTeacher(true);
            }
        });;
    }

    public void addCourse(String course, String classLevel) {
        Course c = new Course(course, classLevel);
        db.setCourse(c);
    }


}
