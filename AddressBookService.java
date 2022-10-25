package com.bridgelabz.AddressBook;

import java.util.ArrayList;

public class AddressBookService {
    private ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public int searchByName(String name) {
        for (Contact contact : contactList)
            if (contact.getfName().equalsIgnoreCase(name))
                return contactList.indexOf(contact);
        return -1;
    }

    public boolean editContact(String name, Contact modified) {
        int index = searchByName(name);
        if (index == -1)
            return false;
        contactList.set(index, modified);
        return true;
    }

    public boolean deleteContact(String name) {
        int index = searchByName(name);
        if (index == -1)
            return false;
        contactList.remove(index);
        return true;
    }

    @Override
    public String toString() {
        if (contactList.isEmpty())
            return "No contacts found!";

        StringBuilder builder = new StringBuilder();
        for (Contact contacts : contactList)
            builder.append(contacts.toString()).append("\n");

        return builder.toString();
    }

}
