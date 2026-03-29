package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AddressBookService {

    private Map<Integer, AddressBookModel> addressBook = new HashMap<>();
    private int idCounter = 1;

    // CREATE
    public AddressBookModel create(AddressBookDTO dto) {
        log.info("Creating new address: {}", dto);

        AddressBookModel model = new AddressBookModel();
        model.setId(idCounter++);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        addressBook.put(model.getId(), model);

        log.info("Created address with ID: {}", model.getId());
        return model;
    }

    // GET ALL
    public Map<Integer, AddressBookModel> getAll() {
        log.info("Fetching all addresses");
        return addressBook;
    }

    // GET BY ID
    public AddressBookModel getById(int id) {
        log.info("Fetching address with id: {}", id);

        if (!addressBook.containsKey(id)) {
            log.error("Address not found with id: {}", id);
            throw new RuntimeException("Address not found with id: " + id);
        }

        return addressBook.get(id);
    }

    // UPDATE
    public AddressBookModel update(int id, AddressBookDTO dto) {
        log.info("Updating address with id: {}", id);

        if (!addressBook.containsKey(id)) {
            log.error("Cannot update. Address not found with id: {}", id);
            throw new RuntimeException("Cannot update. Address not found with id: " + id);
        }

        AddressBookModel model = addressBook.get(id);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        log.info("Updated address with id: {}", id);
        return model;
    }

    // DELETE
    public void delete(int id) {
        log.info("Deleting address with id: {}", id);

        if (!addressBook.containsKey(id)) {
            log.error("Cannot delete. Address not found with id: {}", id);
            throw new RuntimeException("Cannot delete. Address not found with id: " + id);
        }

        addressBook.remove(id);

        log.info("Deleted address with id: {}", id);
    }
}