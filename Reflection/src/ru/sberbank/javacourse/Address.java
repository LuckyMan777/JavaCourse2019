package ru.sberbank.javacourse;

public class Address {
    private final String city;
    private final int postalCode;

    public Address(String city, int postalCode) {
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
