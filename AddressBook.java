package com.bridgelabz.AddressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
    static List<Contact> addressBook;

    public static String FILE_PATH = ("C:\\Users\\ULLASKUMAR K\\AddressBook.txt");


    public static void main(String[] args) {
        addressBook = new LinkedList<Contact>();

        boolean isExit = false;

        System.out.println("Welcome to the Address book, Manage your contacts " + "with the Address book");
        Scanner scanner = new Scanner(System.in);
        while (!isExit) {
            System.out.println("Select the option from below");
            if (addressBook.isEmpty()) {
                System.out.println("1. Add Contact" + "\n5. Exit");
            } else {
                System.out.println(
                        "1. Add Contact" + "\n2. Display Contact\n3. Edit Contact" + "\n4. Delete Contact\n5. Exit");
            }
            String option = scanner.nextLine();
            AddressBook addressBookService = new AddressBook();
            addressBookService.writeEmployeePayrollData();

            switch (option) {
                case "1":
                    addContact(scanner);
                    break;

                case "2":
                    showContacts();
                    break;

                case "3":
                    editContact(scanner);
                    break;

                case "4":
                    deleteContact(scanner);
                    break;

                case "5":
                    isExit = true;
                    showContacts();
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }

    public void writeEmployeePayrollData() {
        checkFile();
        StringBuffer empBuffer = new StringBuffer();
        addressBook.forEach(person -> {
            String contactdetails = person.toString().concat("\n");
            empBuffer.append(contactdetails);
        });
        try {
            Files.write(Paths.get(FILE_PATH), empBuffer.toString().getBytes());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void checkFile() {
        File file = new File(FILE_PATH);
        try {

            if (!file.exists()) {

                file.createNewFile();
                System.out.println("Created a file at " + FILE_PATH);
            }
        } catch (IOException e1) {
            System.err.println("Problem encountered while creating a file");
        }
    }

    private static void addContact(Scanner scanner) {
        Contact contact = new Contact();

        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        contact.setFirstName(validateFirstName(firstName, scanner));

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        contact.setLastName(validateLastName(lastName, scanner));

        System.out.println("Enter Your Email: ");
        String email = scanner.nextLine();
        contact.setEmail(validateEmail(email, scanner));

        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        contact.setPhoneNumber(validatePhone(phoneNumber, scanner));

        System.out.println("Enter Your City Name : ");
        String city = scanner.nextLine();
        contact.setCity(validateCity(city, scanner));

        System.out.println("Enter Zip Code: ");
        String zip = scanner.nextLine();
        contact.setZip(validateZip(zip, scanner));

        System.out.println("Enter Your State Name: ");
        String state = scanner.nextLine();
        contact.setState(validateState(state, scanner));

        addressBook.add(contact);
        System.out.println("Contact has been saved.");
    }

    private static void editContact(Scanner scanner) {
        System.out.println("Which contact you want to Edit? (Enter the First name)");
        String firstName = scanner.nextLine();

        Contact editContact = null;
        for (int i = 0; i < addressBook.size(); i++) {
            if (firstName.equals(addressBook.get(i).getFirstName())) {
                editContact = addressBook.get(i);
            }
        }

        if (editContact == null) {
            System.out.println("No contact found with name " + firstName + ".");
        } else {
            editContactDetails(editContact, scanner);
        }
    }

    private static void editContactDetails(Contact editContact, Scanner scanner) {
        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        editContact.setFirstName(validateFirstName(firstName, scanner));

        System.out.println("Enter Your Email: ");
        String email = scanner.nextLine();
        editContact.setEmail(validateEmail(email, scanner));

        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        editContact.setPhoneNumber(validatePhone(phoneNumber, scanner));

        System.out.println("Contact has been edited.");
    }

    private static void deleteContact(Scanner scanner) {
        System.out.println("Which contact you want to Delete? (Enter the First name)");
        String firstName = scanner.nextLine();

        Contact deleteContact = null;
        for (int i = 0; i < addressBook.size(); i++) {
            if (firstName.equals(addressBook.get(i).getFirstName())) {
                deleteContact = addressBook.remove(i);
            }
        }

        if (deleteContact == null) {
            System.out.println("No contact found with name " + firstName + ".");
        } else {
            System.out.println(deleteContact.getFirstName() + "'s contact has been removed from your Address Book.");
        }
    }

    private static void showContacts() {
        if (addressBook.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            for (Contact contact : addressBook) {
                System.out.println(contact);
            }
        }
    }

    public static String validateFirstName(String firstName, Scanner scanner) {
        String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(firstName);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid first name, please try again");
            System.out.println("length must not exceeds 10 (Exa: Azhar)");
            firstName = scanner.nextLine();
            inputMatcher = regex.matcher(firstName);
        }
        return firstName;
    }

    public static String validateLastName(String lastName, Scanner scanner) {
        String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(lastName);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid first name, please try again");
            System.out.println("length must not exceeds 10 (Exa: Darpan)");
            lastName = scanner.nextLine();
            inputMatcher = regex.matcher(lastName);
        }
        return lastName;
    }

    public static String validatePhone(String phone, Scanner scanner) {
        String resultPattern = "^[+]{0,1}[0-9]{0,2}[0-9]{10}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(phone);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid Phone number, please try again");
            phone = scanner.nextLine();
            inputMatcher = regex.matcher(phone);
        }
        return phone;
    }

    public static String validateEmail(String email, Scanner scanner) {
        String resultPattern = "^[a-z1-9.]{2,30}@{1}[a-z]{3,10}.[a-z]{3}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(email);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid Email, please try again");
            email = scanner.nextLine();
            inputMatcher = regex.matcher(email);
        }
        return email;
    }

    public static String validateCity(String city, Scanner scanner) {
        String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(city);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid City name, please try again");
            System.out.println("length must not exceeds 10 (Exa: Tokyo)");
            city = scanner.nextLine();
            inputMatcher = regex.matcher(city);
        }
        return city;
    }

    public static String validateZip(String zip, Scanner scanner) {
        String resultPattern = "^[0-9]{6}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(zip);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid Zip Code, please try again");
            zip = scanner.nextLine();
            inputMatcher = regex.matcher(zip);
        }
        return zip;
    }

    public static String validateState(String state, Scanner scanner) {
        String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(state);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid City name, please try again");
            System.out.println("length must not exceeds 10 (Exa: Goa)");
            state = scanner.nextLine();
            inputMatcher = regex.matcher(state);
        }
        return state;
    }
}