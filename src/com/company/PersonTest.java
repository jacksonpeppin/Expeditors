package com.company;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    Person bobSmithOne = new Person("Bob", "Smith", "Address", "City", "State", 20);
    Person bobSmithTwo = new Person("Bob", "Smith", "Address", "City", "State", 40);
    Person alexSmith = new Person("Alex", "Smith", "Address", "City", "State", 30);
    Person georgeMiller = new Person("George", "Miller", "Address", "City", "State", 50);

    @Test
    void getAge() {
        assertEquals(bobSmithOne.getAge(), 20);
        assertEquals(bobSmithTwo.getAge(), 40);
        assertEquals(alexSmith.getAge(), 30);
        assertEquals(georgeMiller.getAge(), 50);

    }

    @Test
    void getAddress() {
        assertEquals(bobSmithOne.getAddress(), "Address");
        assertEquals(bobSmithTwo.getAddress(), "Address");
        assertEquals(alexSmith.getAddress(), "Address");
        assertEquals(georgeMiller.getAddress(), "Address");
    }

    @Test
    void getState() {
        assertEquals(bobSmithOne.getState(), "State");
        assertEquals(bobSmithTwo.getState(), "State");
        assertEquals(alexSmith.getState(), "State");
        assertEquals(georgeMiller.getState(), "State");
    }

    @Test
    void getCity() {
        assertEquals(bobSmithOne.getCity(), "City");
        assertEquals(bobSmithTwo.getCity(), "City");
        assertEquals(alexSmith.getCity(), "City");
        assertEquals(georgeMiller.getCity(), "City");
    }

    @Test
    void getFirstName() {
        assertEquals(bobSmithOne.getFirstName(), "Bob");
        assertEquals(bobSmithTwo.getFirstName(), "Bob");
        assertEquals(alexSmith.getFirstName(), "Alex");
        assertEquals(georgeMiller.getFirstName(), "George");
    }

    @Test
    void getLastName() {
        assertEquals(bobSmithOne.getLastName(), "Smith");
        assertEquals(bobSmithTwo.getLastName(), "Smith");
        assertEquals(alexSmith.getLastName(), "Smith");
        assertEquals(georgeMiller.getLastName(), "Miller");
    }

    @Test
    void compareTo() {
        //bob smith one and bob smith two are equal
        assertEquals(bobSmithOne.compareTo(bobSmithTwo), 0);
        //alex smith comes before bob smith alphabetically (can sort by first name)
        assertEquals(bobSmithOne.compareTo(alexSmith), 1);
        //george miller comes before alex smith alphabetically (can sort by last name)
        assertEquals(georgeMiller.compareTo(alexSmith), -1);
    }
}