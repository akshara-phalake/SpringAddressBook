package com.example.springaddressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public @ToString class  AddressBookDTO {
        @Pattern(regexp = "^[A-Z]{1}[a-zAZ\\s]{2,}$", message = "firstName is Invalid")
        public String firstName;
        @Pattern(regexp = "^[A-Z]{1}[a-zAZ\\s]{2,}$", message = "lastName is Invalid")
        public String lastName;
        @NotNull(message = "address should not be null")
        public String address;
        @NotNull(message = "city should not be null")
        public List<String> city;
        @NotNull(message = "email should not be null")
        public String email;
        @NotNull(message = "zip should not be null")
        public long zip;
        @NotNull(message = "contact should not be null")
        public long contact;
}

