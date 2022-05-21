package com.example.springaddressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private long zip;
    private String email;
    private long contact;

    public AddressBook(int id, AddressBook addressBook) {
        this.firstName = addressBook.firstName;
        this.lastName = addressBook.lastName;
        this.address = addressBook.address;
        this.city = addressBook.city;
        this.zip = addressBook.zip;
        this.email = addressBook.email;
        this.contact = addressBook.contact;
    }

    public AddressBook(AddressBook addressBook) {
        this.id = addressBook.id;
        this.firstName = addressBook.firstName;
        this.lastName = addressBook.lastName;
        this.address = addressBook.address;
        this.city = addressBook.city;
        this.zip = addressBook.zip;
        this.email = addressBook.email;
        this.contact = addressBook.contact;
    }

    public AddressBook() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                '}';
    }
}
