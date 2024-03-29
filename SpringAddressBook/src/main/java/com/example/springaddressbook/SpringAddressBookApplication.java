package com.example.springaddressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringAddressBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAddressBookApplication.class, args);
        System.out.println("Address Book project");
        log.info("Logger is Activated..!");
    }
}
