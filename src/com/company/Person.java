package com.company;

/**
 * @author Jackson Peppin
 * @version 1.0
 *
 */
public class Person {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int age;

    /**
     * Construct a Person object with a first name, last name, address, city, state and age.
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param age
     */
    public Person(String firstName, String lastName, String address, String city, String state, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.age = age;
    }

    /**
     * grab the age of this person
     * @return age of this person
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * grab the address of this person
     * @return address of this person
     */
    public String getState() {
        return state;
    }

    /**
     * grab the state this person resides in
     * @return state this person resides in
     */
    public String getCity() {
        return city;
    }

    /**
     * grab the first name of this person
     * @return first name of this person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * grab the last name of this person
     * @return last name of this person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param person
     * @return 0 if the persons to be compared have the same first and last name
     *         1 if the person compared against comes after alphabetically
     *         -1 if the person compared against comes before alphabetically
     */
    public int compareTo(Person person) {
        //Last names are the same
        if (this.lastName.compareToIgnoreCase(person.getLastName()) == 0) {
            //compare first names

            //same first and last
            if (this.firstName.compareToIgnoreCase(person.getFirstName()) == 0) {
                return 0;
            }
            //THIS comes before PERSON alphabetically
            else if (this.firstName.compareToIgnoreCase(person.getFirstName()) < 0) {
                return -1;
            }
            //THIS comes after PERSON alphabetically
            else {
                return 1;
            }
        }
        //THIS comes before PERSON alphabetically
        else if (this.lastName.compareToIgnoreCase(person.getLastName()) < 0) {
            return -1;
        }
        //THIS comes after PERSON alphabetically
        else {
            return 1;
        }
    }

    /**
     * Represent Person object as a string, showing name, address, and age.
     *
     * @return Person represented as a string:
     *         First, Last, Address, City, State, Age
     */
    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName + ", " + this.address + ", " +
                this.city + ", " + this.state + ", " + this.age;
    }
}
