//package org.example.cradlehigh.users.staff.academic;
//
//import org.example.cradlehigh.db.Db;
//import org.example.cradlehigh.model.users.Applicant;
//import org.example.cradlehigh.model.users.Student;
//import org.example.cradlehigh.model.users.staff.academic.Principal;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class PrincipalTest {
//        Db db = new Db();
//        Principal principal = new Principal("Daisy", "Young", 42, 'F', "daisy.young@gmail.com", "+2348038889292");
//
//        Applicant a1 = new Applicant("Mary", "Newman", 12, 'F', "mary.newman@gmail.com", "+2348037772525", "JSS2");
//        Applicant a2 = new Applicant("Hauwa", "Decker", 16, 'M', "hauwa.deckern@gmail.com", "+234803777210105", "SSS2");
//        Applicant a3 = new Applicant("Uche", "Wu", 9, 'M', "uche.wu@gmail.com", "+2348037772525", "JSS1");
//        List<Applicant> applicantList = List.of(a1, a2, a3);;
//
//
//    @Test
//    public void acceptApplicant() {
//        String result = principal.acceptApplication(applicantList.get(0));
//        assertNotNull(result);
//    }
//
//    @Test
//    public void getPassword() {
//        assertEquals(principal.getPassword(), "I'm admin");
//    }
//
//    @Test
//    public void getId() {
//        assertNotNull(principal.getId());
//    }
//
//
//    @Test
//    public void admitStudent() {
//        int count = principal.admitStudent(applicantList);
//        assertEquals(count, 3);
//    }
//
//    @Test
//    public void expelStudent() {
//
//
//    }
//
//    @Test
//    public void getStudents() {
//        List<Student> s = principal.getStudents();
//        assertEquals(s.size(), 3);
//    }
//
//    @Test
//    public void getStudent() {
//    }
//
//    @Test
//    public void getTeachers() {
//    }
//
//    @Test
//    public void getApplicants() {
//    }
//
//    @Test
//    public void printApplicants() {
//    }
//
//    @Test
//    public void getRejectedApplicants() {
//    }
//
//    @Test
//    public void getTeacher() {
//    }
//
//    @Test
//    public void assignTeacherToClass() {
//    }
//
//    @Test
//    public void assignHeadTeacher() {
//    }
//
//    @Test
//    public void addCourse() {
//        assertEquals(db.getCourses().size(), 10);
//    }
//}
