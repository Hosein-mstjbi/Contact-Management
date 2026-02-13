package com.contactmagement.service;

import com.contactmagement.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "contacts.txt";

    @Override
    public void addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("این مخاطب از قبل وجود دارد!");
            return;
        }
        contacts.add(contact);
        System.out.println("مخاطب اضافه شد");
    }

    @Override
    public void removeContact(String phone) {
        Contact temp = new Contact("", phone);
        if (contacts.contains(temp)) {
            contacts.remove(temp);
            System.out.println("مخاطب حذف شد");
        } else {
            System.out.println("مخاطب پیدا نشد.");
        }
    }

    @Override
    public List<Contact> getAllContact() {
        return contacts;
    }

    @Override
    public Contact searchByPhone(String phone) {
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Contact> searchByName(String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new PrintWriter(FILE_NAME))) {
            for (Contact c : contacts) {
                writer.println(c.getName() + "," + c.getPhone());
            }
            System.out.println("سیو شد.");
        } catch (IOException e) {
            System.out.println("خطای فایل.");
        }
    }

    @Override
    public void loadFromFile() {
        contacts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Contact contact = new Contact(parts[0], parts[1]);
            }
            System.out.println("فایل بارگذاری شد.");
        } catch (IOException e) {
            System.out.println("هیچ فایلی یافت نشد.");
        }
    }
}
