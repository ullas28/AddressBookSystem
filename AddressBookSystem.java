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
        Contacts.editContact();
    }


    class Contacts {
        /**creating contact using Arraylist
         * taking input from console
         * **/
       static ArrayList<String> contacts = new ArrayList<String>(7);

        static void createContact() {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the contact details  : ");
            System.out.println("Name Address City State Zipcode PhoneNo EmailId  : ");
            for (int i = 0; i < 7; i++) {
                String k = s.nextLine();
                contacts.add(k);
            }
            System.out.println(" -------------------------------------------");
            System.out.println("contact details added :");
            System.out.println(contacts);
        }
        static void editContact() {
            Scanner sc = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Enter which detail you have to edit  : ");
            System.out.println("name or address or city or state or zip or phone or email  : ");

            /** editing specific detail which user want **/
            String detailToEdit = sc.nextLine();

            switch (detailToEdit) {
                case "name" :
                    System.out.println("Enter the name to edit  : ");
                    String n = sc.nextLine();
                    contacts.set(0, n);
                    break;
                case "address" :
                    System.out.println("Enter the address to edit  : ");
                    String a = sc.nextLine();
                    contacts.set(1, a);
                    break;
                case "city" :
                    System.out.println("Enter the name to edit  : ");
                    String city = sc.nextLine();
                    contacts.set(2, city);
                    break;
                case "state" :
                    System.out.println("Enter the name to edit  : ");
                    String state = sc.nextLine();
                    contacts.set(3, state);
                    break;
                case "zip" :
                    System.out.println("Enter the name to edit  : ");
                    String zip = sc.nextLine();
                    contacts.set(4, zip);
                    break;
                case "phone" :
                    System.out.println("Enter the name to edit  : ");
                    String phone = sc.nextLine();
                    contacts.set(5, phone);
                    break;
                case "email" :
                    System.out.println("Enter the name to edit  : ");
                    String email = sc.nextLine();
                    contacts.set(6, email);
                    break;
                default :
                    System.out.println("no edit match  : ");

            }

            System.out.println("----------------------------------------------------- ");
            System.out.println("edited contact details are :");
            System.out.println(contacts);

        }
    }
}
