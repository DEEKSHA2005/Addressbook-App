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

    // GET BY ID
    public AddressBookModel getById(int id) {
        return addressBook.get(id);
    }

    // UPDATE
    public AddressBookModel update(int id, AddressBookDTO dto) {
        AddressBookModel model = addressBook.get(id);
        model.setName(dto.getName());
        model.setCity(dto.getCity());
        return model;
    }

    // DELETE
    public void delete(int id) {
        addressBook.remove(id);
    }
}