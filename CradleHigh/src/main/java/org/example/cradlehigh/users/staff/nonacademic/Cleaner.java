package org.example.cradlehigh.users.staff.nonacademic;

import org.example.cradlehigh.users.UserType;
import org.example.cradlehigh.users.User;

public class Cleaner extends User {

    private int index;

    public Cleaner(String firstName, String lastName, int age, char gender, String email, String phoneNumber, UserType category) {
        super(firstName, lastName, age, gender, email, phoneNumber, category);
    }

    @Override
    protected String setId(UserType category) {
        index++;
        return "CLNR-" + index;
    }
}
