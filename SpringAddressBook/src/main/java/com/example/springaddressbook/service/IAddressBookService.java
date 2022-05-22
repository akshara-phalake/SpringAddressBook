package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IAddressBookService {
        AddressBook addAddressBook(AddressBook addressBook);
        Optional<AddressBook> getById(int id);
        List<AddressBook> getAll();
        AddressBook editData(int id, AddressBookDTO addressBookDTO);
        String removeById(int id);
}
