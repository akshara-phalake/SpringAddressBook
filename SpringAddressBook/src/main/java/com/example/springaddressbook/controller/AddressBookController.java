package com.example.springaddressbook.controller;

import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.repository.AddressBookRepository;
import com.example.springaddressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;
    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/show/{id}")
    public Optional<AddressBook> getAddressById (@PathVariable int id){
        Optional<AddressBook> response = addressBookService.getDataById(id);
        return response;
    }

    @GetMapping("/showall")
    public List<AddressBook> allAddressBookData (){
        List<AddressBook> response = addressBookService.getAllData();
        return response;
    }

    @PostMapping("/add")
    public AddressBook addAddress (@RequestBody AddressBook addressBook){
        AddressBook newAddress = addressBookService.addData(addressBook);
        return newAddress;
    }

    @PutMapping("/edit/{id}")
    public AddressBook editContact(@PathVariable int id, @RequestBody AddressBook addressBook){
        AddressBook editAddress = addressBookService.editData(id,addressBook);
        return editAddress;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<AddressBook> newuser =addressBookRepository.findById(id);
        if (newuser.isPresent()){
            addressBookRepository.delete(newuser.get());
            return "Record is deleted with id " +id;
        }
        return "Record not Found";
    }
}
