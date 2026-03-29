package com.bridgelabz.addressbook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Temporary in-memory storage
    private Map<Integer, String> addressBook = new HashMap<>();
    private int idCounter = 1;

    // GET ALL
    @GetMapping
    public ResponseEntity<Map<Integer, String>> getAll() {
        return ResponseEntity.ok(addressBook);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressBook.get(id));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> create(@RequestBody String name) {
        addressBook.put(idCounter, name);
        idCounter++;
        return ResponseEntity.ok("Created Successfully");
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                                         @RequestBody String name) {
        addressBook.put(id, name);
        return ResponseEntity.ok("Updated Successfully");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        addressBook.remove(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}