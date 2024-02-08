package org.example.cradlehigh.users;

public class Applicant extends User{

    private int index = 1;

    private final String classApplied;

    public Applicant(String firstName, String lastName, int age, char gender, String email, String phoneNumber, String classApplied, UserType category) {
        super(firstName, lastName, age, gender, email, phoneNumber, category);
        this.classApplied = classApplied;
    }

    public String getClassApplied() {
        return this.classApplied;
    }

    @Override
    protected String setId(UserType category) {
        index++;
        return "APCN-" + index;
    }
}
