package com.bridgelabz.AddressBook;

import java.util.*;
public class AddressBookSystem {

    private static final List<AddressBookService> library = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    private static int locateIndex(String name) {
        for (int i = 0; i < library.size(); i++)
            if (library.get(i).getBookName().equals(name))
                return i;
        return -1;
    }

    private static int welcomePrompt() {
        System.out.println("\n\nWelcome to Address Book Program");
        System.out.println("1. New Address Book");
        System.out.println("2. Select Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Search");
        System.out.println("5. Quit");
        System.out.print("Your choice: ");
        int choice = AddressBookSystem.sc.nextInt();
        AddressBookSystem.sc.nextLine();
        return choice;
    }

    private static void searchByPrompt() {
        System.out.println("1. By name");
        System.out.println("2. By city");
        System.out.println("3. By state");
        System.out.println("4. Back");
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                library.forEach(book -> book.searchByName(name).forEach(System.out::println));
                break;
            case 2:
                System.out.println("Enter city: ");
                String city = sc.nextLine();
                library.forEach(book -> book.searchByCity(city).forEach(System.out::println));
                break;
            case 3:
                System.out.println("Enter state: ");
                String state = sc.nextLine();
                library.forEach(book -> book.searchByState(state).forEach(System.out::println));
                break;
            case 4:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }

    }

    private static void addBook(String bookName) {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.setBookName(bookName);
        library.add(addressBookService);
        AddressBook.run(addressBookService, sc);
    }

    public static void main(String[] args) {
        while (true) {
            switch (welcomePrompt()) {
                case 1: //add
                    System.out.println("Name of new address book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    addBook(bookName);
                    break;
                case 2: //select
                    System.out.println("Available books are: ");
                    library.forEach(book -> System.out.println(book.getBookName() + " ,"));
                    System.out.println("Open Book: ");
                    String name = sc.nextLine();
                    System.out.println("Current: " + name);
                    AddressBook.run(library.get(locateIndex(name)), sc);
                    break;
                case 3: //delete
                    System.out.println("Enter name to delete: ");
                    name = sc.nextLine();
                    library.remove(locateIndex(name));
                    break;
                case 4:
                    searchByPrompt();
                    break;
                case 5: //quit
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    private static class AddressBook {
        private static int addressPrompt(Scanner sc) {
            System.out.println("\n\nWelcome to Address Book Program");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Print Address Book");
            System.out.println("5. Back");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            return choice;
        }

        private static void deleteContact(AddressBookService book, Scanner sc, String name) {
            List<Contact> sameName = book.searchByName(name);

            if (sameName.isEmpty())
                System.out.println("NOT FOUND!");
            else if (sameName.size() == 1) {
                book.deleteContact(sameName.get(0));
                System.out.println("Contact Deleted!");
            } else {
                sameName.forEach(x -> System.out.println(sameName.indexOf(x) + "  " + x.toString()));
                System.out.println("Enter an index to delete: ");
                book.deleteContact(sameName.get(sc.nextInt()));
                System.out.println("Contact Deleted!");
            }
        }

        private static void editContact(AddressBookService book, Scanner sc, String name) {
            List<Contact> sameName = book.searchByName(name);
            if (sameName.isEmpty())
                System.out.println("NOT FOUND!");
            else if (sameName.size() == 1) {
                book.editContact(sameName.get(0), Utility.readContact(sc));
                System.out.println("Contact Modified!");
            } else {
                sameName.forEach(x -> System.out.println(sameName.indexOf(x) + "  " + x.toString()));
                System.out.println("Enter an index to edit: ");
                int index = sc.nextInt();
                sc.nextLine();
                book.editContact(sameName.get(index), Utility.readContact(sc));
                System.out.println("Contact Modified!");
            }
        }

        public static void run(AddressBookService book, Scanner sc) {
            while (true) {
                switch (addressPrompt(sc)) {
                    case 1: //Add
                        if (book.addContact(Utility.readContact(sc)))
                            System.out.println("Contact Added!");
                        else System.out.println("Contact already exists");
                        break;

                    case 2: //Edit
                        System.out.println("Enter name to edit: ");
                        editContact(book, sc, sc.nextLine());
                        break;

                    case 3: //Delete
                        System.out.println("Enter name to delete: ");
                        deleteContact(book, sc, sc.nextLine());
                        break;

                    case 4: //Print
                        System.out.println(book.toString());
                        break;

                    case 5: //Quit
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                        break;
                }
            }

        }
    }
}