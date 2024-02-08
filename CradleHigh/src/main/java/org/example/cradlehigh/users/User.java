package org.example.cradlehigh.users;

import org.example.cradlehigh.Base;

public abstract class User extends Base {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String email;
    private String phoneNumber;
    private Enum<UserType> category;

    private int tchIndex;

    public User(String firstName, String lastName, int age, char gender, String email, String phoneNumber, UserType category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.id = setId(category);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Enum<UserType> getCategory() {
        return category;
    }


    public void setCategory(int type) {
        switch (type) {
            case 1: {
                this.category = UserType.STUDENT;
            }
            case  2: {
                this.category = UserType.TEACHER;
            }
            case 3: {
                this.category = UserType.APPLICANT;
            }
            default: {
                System.out.println("Wrong choice. Try again.");
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", category=" + category +
                ", id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
