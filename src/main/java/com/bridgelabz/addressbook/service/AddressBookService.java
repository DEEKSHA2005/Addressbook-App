package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    // CREATE
    public AddressBookModel create(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        return repository.save(model);
    }

    // GET ALL
    public List<AddressBookModel> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public AddressBookModel getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
    }

    // UPDATE
    public AddressBookModel update(int id, AddressBookDTO dto) {
        AddressBookModel model = getById(id);
        model.setName(dto.getName());
        model.setCity(dto.getCity());

        return repository.save(model);
    }

    // DELETE
    public void delete(int id) {
        AddressBookModel model = getById(id);
        repository.delete(model);
    }
}