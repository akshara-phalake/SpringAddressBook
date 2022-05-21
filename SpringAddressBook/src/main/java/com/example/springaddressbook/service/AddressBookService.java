package com.example.springaddressbook.service;

import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;

    public List<AddressBook> getAllData() {
        return addressBookRepository.findAll();
    }

    public Optional<AddressBook> getDataById(int id) {
        return addressBookRepository.findById(id);
    }

    public AddressBook editData(int id, AddressBook addressBook) {
        AddressBook search = null;
        if (addressBookRepository.findById(id).isPresent()) {
            AddressBook newAddress = new AddressBook(id, addressBook);
            search = addressBookRepository.save(newAddress);
        }
        return search;
    }

    public AddressBook addData(AddressBook addressBook) {
        AddressBook addToAddressBook = new AddressBook(addressBook);
        addressBookRepository.save(addToAddressBook);
        return addToAddressBook;
    }
}
