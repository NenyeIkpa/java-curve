package org.example.cradlehigh.model;

import org.example.cradlehigh.db.Db;

import java.util.ArrayList;
import java.util.List;

public class ClassLevel extends Base  {

    private static int index;

    private String classLevel;


    public ClassLevel(String classLevel) {
        this.classLevel= classLevel;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
        this.id = setId();
    }


    public List<Course> getJssCourses() {
        List<Course> jssCourses = new ArrayList<>();
        Db db = new Db();
        for (Course c: db.getCourses()) {
            if (c.getClassLevel() == "JSS") {
                jssCourses.add(c);
            }
        }
        return jssCourses;
    }

    public List<Course> getSssCourses() {
        List<Course> sssCourses = new ArrayList<>();
        Db db = new Db();
        for (Course c: db.getCourses()) {
            if (c.getClassLevel() == "SSS") {
                sssCourses.add(c);
            }
        }
        return sssCourses;
    }


    @Override
    protected String setId() {
        index++;
        return "CLSS-" + index;
    }


}
