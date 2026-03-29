package com.bridgelabz.addressbook.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address_book")
public class AddressBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String city;
}