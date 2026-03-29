package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressBookService {

    private Map<Integer, AddressBookModel> addressBook = new HashMap<>();
    private int idCounter = 1;

    // CREATE
    public AddressBookModel create(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setId(idCounter++);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        addressBook.put(model.getId(), model);
        return model;
    }

    // GET ALL
    public Map<Integer, AddressBookModel> getAll() {
        return addressBook;
    }

    // GET BY ID (IMPROVED)
    public AddressBookModel getById(int id) {
        if (!addressBook.containsKey(id)) {
            throw new RuntimeException("Address not found with id: " + id);
        }
        return addressBook.get(id);
    }

    // UPDATE (IMPROVED)
    public AddressBookModel update(int id, AddressBookDTO dto) {
        if (!addressBook.containsKey(id)) {
            throw new RuntimeException("Cannot update. Address not found with id: " + id);
        }

        AddressBookModel model = addressBook.get(id);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        return model;
    }

    // DELETE (IMPROVED)
    public void delete(int id) {
        if (!addressBook.containsKey(id)) {
            throw new RuntimeException("Cannot delete. Address not found with id: " + id);
        }
        addressBook.remove(id);
    }
}