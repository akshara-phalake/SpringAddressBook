package com.example.springaddressbook.model;

import com.example.springaddressbook.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="address_book")
public @Data class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    private String lastName;
    private String address;
    private long zip;
    private String email;
    private long contact;
    @ElementCollection
    @CollectionTable(name = "address_city", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "city")
    private List<String> city;

    public AddressBook(AddressBook addressBook) {
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

    public AddressBook(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.zip = addressBookDTO.zip;
        this.email = addressBookDTO.email;
        this.contact = addressBookDTO.contact;
    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.zip = addressBookDTO.zip;
        this.email = addressBookDTO.email;
        this.contact = addressBookDTO.contact;
    }

    public AddressBook(int id) {
        this.id = id;
    }
}





