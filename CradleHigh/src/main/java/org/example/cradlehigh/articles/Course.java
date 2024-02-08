package org.example.cradlehigh.articles;

import org.example.cradlehigh.Base;
import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.users.UserType;

import java.util.ArrayList;
import java.util.List;

public class Course extends Base {

    private int index;
    private String courseTitle;
    private String classLevel;

    public Course() {

    }
    public Course(String courseTitle, String classLevel) {
        this.courseTitle = courseTitle;
        this.classLevel = classLevel;
    }


    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public List<Course> getMandatory() {
        List<Course> mandatory = new ArrayList<>();
        Db db = new Db();
        for (Course c: db.getCourses()) {
            if (c.classLevel == "ALL") {
                mandatory.add(c);
            }
        }
        return mandatory;
    }

    public List<Course> getOptional() {
        List<Course> optional = new ArrayList<>();
        Db db = new Db();
        for (Course c: db.getCourses()) {
            if (c.classLevel == "JSS" || c.classLevel == "SSS") {
                optional.add(c);
            }
        }
        return optional;
    }

    @Override
    protected String setId(UserType category) {
        index++;
        return "CRSE-" + index;
    }
}
