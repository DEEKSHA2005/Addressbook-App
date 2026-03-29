package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    // CREATE
    @PostMapping
    public ResponseEntity<AddressBookModel> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<Map<Integer, AddressBookModel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> update(@PathVariable int id,
                                                   @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}