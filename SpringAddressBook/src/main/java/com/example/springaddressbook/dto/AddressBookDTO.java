package com.example.springaddressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
        public String firstName;
        public String lastName;
        public String address;
        public String city;
        public String email;
        public long zip;
        public long contact;
    }

