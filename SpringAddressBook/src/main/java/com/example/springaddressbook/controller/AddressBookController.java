package com.example.springaddressbook.controller;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.dto.ResponseDTO;
import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    IAddressBookService iAddressBookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newAddressBook = new AddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Adding the data", iAddressBookService.addAddressBook(newAddressBook));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("searching the id", iAddressBookService.getById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/show")
    public ResponseEntity<ResponseDTO> getAll() {
        ResponseDTO responseDTO = new ResponseDTO("Show the data", iAddressBookService.getAll());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> editData(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Edit the data", iAddressBookService.editData(id, addressBookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> removeById(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Remove the data", iAddressBookService.removeById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO> getAddressByCity(@PathVariable String city) {
        List<AddressBook> addressBookList = null;
        addressBookList = iAddressBookService.getDataByCity(city);
        ResponseDTO response = new ResponseDTO("Get data by city", addressBookList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}




