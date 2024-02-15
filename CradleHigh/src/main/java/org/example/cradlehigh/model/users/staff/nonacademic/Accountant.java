package org.example.cradlehigh.model.users.staff.nonacademic;

import org.example.cradlehigh.model.users.User;

public class Accountant extends User {

    private int index;

    public Accountant(String firstName, String lastName, int age, char gender, String email, String phoneNumber) {
        super(firstName, lastName, age, gender, email, phoneNumber);
    }

    @Override
    protected String setId() {
        index++;
        return "ACCN-" + index;
    }
}
