package com.example.springaddressbook.repository;

import com.example.springaddressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
