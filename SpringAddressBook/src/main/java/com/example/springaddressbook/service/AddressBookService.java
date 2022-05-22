package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.repository.IAddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService{
    @Autowired
    IAddressBookRepository iAddressBookRepository;

    public AddressBook addAddressBook(AddressBook addressBook) {
        AddressBook newAddressBook = new AddressBook(addressBook);
        iAddressBookRepository.save(newAddressBook);
        return newAddressBook;

    }

    public Optional<AddressBook> getById(int id) {
        return iAddressBookRepository.findById(id);
    }

    public List<AddressBook> getAll() {
        return iAddressBookRepository.findAll();
    }

    @Override
    public AddressBook editData(int id, AddressBookDTO addressBookDTO) {
        AddressBook edituser = new AddressBook(id, addressBookDTO);
        iAddressBookRepository.save(edituser);
        return edituser;
    }
    public String removeById(int id) {
        Optional<AddressBook> newAddressBook = iAddressBookRepository.findById(id);
        if (newAddressBook.isPresent()) {
            iAddressBookRepository.delete(newAddressBook.get());
            return "Record is deleted with id " + id;
        }
        return "Record not Found";
    }
}