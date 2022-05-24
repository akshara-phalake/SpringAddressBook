package com.example.springaddressbook.repository;

import com.example.springaddressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressBookRepository extends JpaRepository<AddressBook, Integer> {
    @Query(value = "select * FROM address_book a,address_city ac WHERE a.id = ac.id AND ac.city= :city", nativeQuery = true) List<AddressBook> findByCity(@Param("city") String city);
}
