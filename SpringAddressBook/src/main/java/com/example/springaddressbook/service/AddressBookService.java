package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.exceptionhandling.AddressBookException;
import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.repository.IAddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private IAddressBookRepository iAddressBookRepository;

    public AddressBook addAddressBook(AddressBook addressBook) {
        AddressBook newAddressBook = new AddressBook(addressBook);
        iAddressBookRepository.save(newAddressBook);
        return newAddressBook;

    }

    public AddressBook getById(int id) {
        return iAddressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Contact id doesn't exists!"));
    }

    public List<AddressBook> getAll() {
        return iAddressBookRepository.findAll();
    }

    public String editData(int id, AddressBookDTO addressBookDTO) {
        if (iAddressBookRepository.findById(id).isPresent()) {
            AddressBook newAddressBook = new AddressBook(id, addressBookDTO);
            AddressBook search = iAddressBookRepository.save(newAddressBook);
            return "Done " + search;
        } else throw (new AddressBookException("Wrong input"));
    }

    public String removeById(int id) {
        Optional<AddressBook> newAddressBook = iAddressBookRepository.findById(id);
        if (newAddressBook.isPresent()) {
           iAddressBookRepository.delete(newAddressBook.get());
            return "Record is deleted with id " + id;
        } else throw (new AddressBookException("Record not Found"));
    }
    public List<AddressBook> getDataByCity(String city) {
        return iAddressBookRepository.findByCity(city);
    }
}
