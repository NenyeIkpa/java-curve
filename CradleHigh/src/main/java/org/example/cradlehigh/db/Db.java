package org.example.cradlehigh.db;

import org.example.cradlehigh.articles.ClassLevel;
import org.example.cradlehigh.articles.Course;
import org.example.cradlehigh.users.Applicant;
import org.example.cradlehigh.users.Student;
import org.example.cradlehigh.users.UserType;
import org.example.cradlehigh.users.staff.academic.Teacher;

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
        Applicant a1 = new Applicant("Mary", "Newman", 12, 'F', "mary.newman@gmail.com", "+2348037772525", "JSS2", UserType.APPLICANT);
        Applicant a2 = new Applicant("Hauwa", "Decker", 16, 'M', "hauwa.deckern@gmail.com", "+234803777210105", "SSS2", UserType.APPLICANT);
        Applicant a3 = new Applicant("Uche", "Wu", 9, 'M', "uche.wu@gmail.com", "+2348037772525", "JSS1", UserType.APPLICANT);
        Applicant a4 = new Applicant("Yemi", "Wu", 18, 'M', "yemi.ade@gmail.com", "+2348037772525", "SS3", UserType.APPLICANT);

        applicants.add(a1);
        applicants.add(a2);
        applicants.add(a3);
        applicants.add(a4);

        students = new ArrayList<>();
        teachers = new ArrayList<>();
//        Teacher t1 = new Teacher("Martha", "Newman",32,'F',"martha.newman@gmail.com", "+2348037772525", UserType.TEACHER);
//        Teacher t2 = new Teacher("John", "Decker",30,'M',"john.deckern@gmail.com", "+234803777210105", UserType.TEACHER);
//        Teacher t3 = new Teacher("Jack", "Wu",34,'M',"jack.wu@gmail.com", "+2348037772525", UserType.TEACHER);
//        Teacher t4 = new Teacher("Andie", "Jones",26,'F',"andie.jones@gmail.com", "+2348037755243", UserType.TEACHER);
//        Teacher t5 = new Teacher("Queen", "Bee",28,'F',"queen.bee@gmail.com", "+2348036662743", UserType.TEACHER);
//        teachers.add(t1);
//        teachers.add(t2);
//        teachers.add(t3);
//        teachers.add(t4);
//        teachers.add(t5);

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) {
        students.add(student);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourse(Course course) {
        courses.add(course);
    }

    public List<ClassLevel> getClassLevels() {
        return classLevels;
    }

    public void setClassLevels(ClassLevel classLevel) {
        classLevels.add(classLevel);
    }
}
