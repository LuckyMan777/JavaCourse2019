package ru.sberbank.javacourse.person;

import java.util.List;

public class Person {
    private final String firstName;
    private final String lastName;
    private Address address;
    private List<String> phonenumbers;

    public Person(String firstName, String lastName, Address address, List<String> phonenumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phonenumbers = phonenumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getPhonenumbers() {
        return phonenumbers;
    }
}
