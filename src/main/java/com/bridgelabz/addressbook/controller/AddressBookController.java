package com.bridgelabz.addressbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Address Book App!";
    }
}