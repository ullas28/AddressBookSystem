package com.bridgelabz.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
    public static void main(String[] args) {

        /*
        * Starting with displaying welcome to address program
        * */

        System.out.println("Welcome to Address Book Program");
        Contacts.createContact();
    }


    class Contacts {
        /**creating contact using Arraylist
         * taking input from console
         * **/

        static void createContact() {
            ArrayList<String> firstContact = new ArrayList<String>(7);
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the contact details  : ");
            System.out.println("Name Address City State Zipcode PhoneNo EmailId  : ");
            for (int i = 0; i < 7; i++) {
                String k = s.nextLine();
                firstContact.add(k);
            }
            System.out.println(firstContact );
        }
    }
}
