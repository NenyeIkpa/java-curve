package org.example.cradlehigh.model.users.staff.nonacademic;

import org.example.cradlehigh.model.users.User;

public class Cleaner extends User {

    private static int index;

    public Cleaner(String firstName, String lastName, int age, char gender, String email, String phoneNumber) {
        super(firstName, lastName, age, gender, email, phoneNumber);
        this.id = setId();
    }

    @Override
    protected String setId() {
        index++;
        return "CLNR-" + index;
    }
}
