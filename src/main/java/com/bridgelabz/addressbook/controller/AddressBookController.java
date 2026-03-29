package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private Map<Integer, AddressBookModel> addressBook = new HashMap<>();
    private int idCounter = 1;

    // CREATE
    @PostMapping
    public ResponseEntity<AddressBookModel> create(@RequestBody AddressBookDTO dto) {

        AddressBookModel model = new AddressBookModel();
        model.setId(idCounter++);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        addressBook.put(model.getId(), model);

        return ResponseEntity.ok(model);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<Map<Integer, AddressBookModel>> getAll() {
        return ResponseEntity.ok(addressBook);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressBook.get(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> update(@PathVariable int id,
                                                   @RequestBody AddressBookDTO dto) {

        AddressBookModel model = addressBook.get(id);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        return ResponseEntity.ok(model);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        addressBook.remove(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}