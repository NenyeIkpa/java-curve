package org.example.cradlehigh.model.users;

public class Applicant extends User{

    private static int index;

    private final String classApplied;

    public Applicant(String firstName, String lastName, int age, char gender, String email, String phoneNumber, String classApplied) {
        super(firstName, lastName, age, gender, email, phoneNumber);
        this.classApplied = classApplied;
        this.id = setId();
    }

    public String getClassApplied() {
        return this.classApplied;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age='" + getAge() + '\'' +
                ", gender=" + getGender() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", createdAt='" + getCreatedAt() + '\'' +
                '}';
    }

    @Override
    protected String setId() {
        ++index;
        return "APCN-" + index;
    }
}
