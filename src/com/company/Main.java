package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

/**
 *  In Main, text file is read in from the location stated by the user. File is read line by line and each line creates a
 * "Person" object. Persons over 18 are inserted in to a list of people in alphabetical order and displayed in the console
 * Also displayed in the console is each unique address and how many occupants live at said address.
 *
 * @author Jackson Peppin
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter the file path of the text file containing input data.");
        Scanner filePath = new Scanner(System.in);

        HashMap<String, Integer> households = new HashMap<>();
        ArrayList<Person> people = new ArrayList<>();

	    File file = new File(filePath.nextLine());

	    try {
            Scanner textFile = new Scanner(file);
	        //Each line will look like: "First name","Last Name","Address","Apartment" *possibly*, "City","State","Age"
	        while(textFile.hasNextLine()) {
	            String line = textFile.nextLine();
	            String[] data = line.split(",");
	            String first = "";
	            String last = "";
                String address = "";
                String apartment = "";
                String city = "";
                String state = "";
                int age = 0;
	            try {
	                if(data.length == 6) {
                        //if person resides in an apartment, data will have a length of 6 if apartment is separated by comma
                        first = data[0].replace("\"", "").trim();
                        last = data[1].replace("\"", "").trim();
                        address = data[2].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim();
                        apartment = "";
                        city = data[3].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim();
                        state = data[4].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim();
                        age = Integer.valueOf(data[5].replaceAll("[^0-9]", ""));

                    } else {
                        //apartment number has caused data array to be length of 7
	                    first = data[0].replace("\"", "").trim();
	                    last = data[1].replace("\"", "").trim();
	                    address = data[2].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim() + " " +
                                data[3].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim();
	                    city = data[4].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim();
	                    state = data[5].toLowerCase().replaceAll("[^a-z0-9\\s]", "").trim();
	                    age = Integer.valueOf(data[6].replaceAll("[^0-9]", ""));
                    }
                    Person person = new Person(first, last, address, city, state, age);
                    String fullAddress = person.getAddress() +
                            " " + person.getCity() +
                            " " + person.getState();
                    //add to households if address is not in the hashmap, if already in hashmap increment count of occupants
                    if (households.containsKey(fullAddress)) {
                        households.replace(fullAddress, households.get(fullAddress), households.get(fullAddress) + 1);
                    } else {
                        households.put(fullAddress, 1);
                    }
                    //add person to list of people in alphabetical older if older than 18
                    insertPerson(person, people);
                } catch(NumberFormatException e) {
                    System.out.println("Text file contains a non integer value as an age");
                }

            }

        } catch(FileNotFoundException e) {
	        System.out.println("Please enter a valid file path");
        }

	    //Print households and size of household
	    ArrayList<String> keys = new ArrayList<>(households.keySet());
	    ArrayList<Integer> values = new ArrayList<>(households.values());
	    for(int j = 0; j < keys.size(); j++) {
            System.out.println("Address: " + keys.get(j) + " Occupants: " + values.get(j));
        }

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();

	    //Print occupants over the age of 18 in alphabetical order
	    for(int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).toString());
        }



    }

    /**
     * This method inserts a person in to the list of people. People are inserted in to the array list in alphabetical
     * order. Only people over the age of 18 are inserted in to the list.
     *
     * @param person Person to be inserted in to list of people
     * @param people Array list of people sorted in alphabetic order
     */
    private static void insertPerson(Person person, ArrayList<Person> people) {
        //only display people older than 18
        if (person.getAge() >= 18) {
            //binary search for insert position
            int left = 0;
            int right = people.size() - 1;
            int mid = (left + right) / 2;

            while(left <= right) {
                mid = (left + right) / 2;

                //first and last names are the same, insert here
                if (people.get(mid).compareTo(person) == 0) {
                    people.add(mid, person);
                    return;
                }

                //position will be left of mid
                else if (people.get(mid).compareTo(person) > 0) {
                    right = mid - 1;
                }
                //position will be right of mid
                else if (people.get(mid).compareTo(person) < 0) {
                    left = mid + 1;
                }
            }
            people.add(right + 1, person);
            return;
        }
    }
}
