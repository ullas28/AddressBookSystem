package com.bridgelabz.AddressBook;

public class Contact {
    private String fName;
    private String lName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public Contact(String fName, String lName, String address, String city, String state, String zip, String phone,
                   String email) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return fName + "\t" + lName + "\t" + address + "\t" + city + "\t" + state + "\t" + zip + "\t" + phone + "\t"
                + email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
