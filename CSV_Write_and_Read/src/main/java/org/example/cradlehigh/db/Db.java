package org.example.cradlehigh.db;

import org.example.cradlehigh.model.ClassLevel;
import org.example.cradlehigh.model.Course;
import org.example.cradlehigh.model.users.Applicant;
import org.example.cradlehigh.model.users.Student;
import org.example.cradlehigh.model.users.staff.academic.Teacher;

import java.util.ArrayList;
import java.util.List;

 public class  Db {

    protected List<Applicant> applicants;

    protected List<Student> students;

    protected List<Teacher> teachers;

    protected List<Course> courses;

    protected List<ClassLevel> classLevels;

    public Db() {
        applicants = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();

        courses = new ArrayList<>();
        courses.add(new Course("English", "ALL"));
        courses.add(new Course("Mathematics", "ALL"));
        courses.add(new Course("Basic Science & Technology", "JSS"));
        courses.add(new Course("PHE", "JSS"));
        courses.add(new Course("Fine Arts", "ALL"));
        courses.add(new Course("Chemistry", "SSS"));
        courses.add(new Course("Economics", "SSS"));
        courses.add(new Course("Physics", "SSS"));
        courses.add(new Course("Social Studies", "JSS"));
        courses.add(new Course("Literature", "SSS"));

        classLevels = List.of(
                new ClassLevel("JSS1"),
                new ClassLevel("JSS2"),
                new ClassLevel("JSS3"),
                new ClassLevel("SSS1"),
                new ClassLevel("SSS2"),
                new ClassLevel("SSS3")
                );
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

     public void printApplicant(Applicant applicant) {
         System.out.println(applicant);
     }
     public void printApplicants() {
         if (applicants.isEmpty()) {
             System.out.println("No applicants at this time");
             return;
         }

         for (Applicant applicant : applicants) {
             System.out.println(applicant.toString());
         }
     }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) {
        students.add(student);
    }

     public void printStudent(Student student) {
         System.out.println(student);
     }
     public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students at this time");
            return;
        }
         for(Student s: students) {
             System.out.println(s);
         }
     }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

     public void printTeacher(Teacher teacher) {
         System.out.println(teacher);
     }

     public void printTeachers() {

         for(Teacher t: teachers) {
             System.out.println(t);
         }
     }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourse(Course course) {
        courses.add(course);
    }

     public void printCourses() {

         for(Course c: courses) {
             System.out.println(c);
         }
     }

    public List<ClassLevel> getClassLevels() {
        return classLevels;
    }

    public void setClassLevels(ClassLevel classLevel) {
        classLevels.add(classLevel);
    }

     public void printClassLevels() {

         for(ClassLevel c: classLevels) {
             System.out.println(c);
         }
     }
}
