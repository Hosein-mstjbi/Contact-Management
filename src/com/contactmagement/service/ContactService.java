package com.contactmagement.service;

import com.contactmagement.model.Contact;

import java.util.List;

public interface ContactService {

    void addContact(Contact contact);

    void removeContact(String phone);

    List<Contact> getAllContact();

    Contact searchByPhone(String phone);

    List<Contact> searchByName(String name);

    void saveToFile();

    void loadFromFile();
}
