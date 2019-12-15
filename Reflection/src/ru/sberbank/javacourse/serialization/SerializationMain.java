package ru.sberbank.javacourse.serialization;

import ru.sberbank.javacourse.person.Address;
import ru.sberbank.javacourse.person.Person;

import java.util.Arrays;

public class SerializationMain {
    public static void main(String[] args) {
        Person p = new Person("Blahblah", null, new Address("City", 125),
                Arrays.asList("123", "345", "7894561230"));
        System.out.println(Serialization.serialize(p));
    }
}
