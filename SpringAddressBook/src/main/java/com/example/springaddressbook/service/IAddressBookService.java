package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressBookService {
        AddressBook addAddressBook(AddressBook addressBook);
        AddressBook getById(int id);
        List<AddressBook> getAll();
        String editData(int id, AddressBookDTO addressBookDTO);
        String removeById(int id);
        List<AddressBook> getDataByCity(String city);
}
