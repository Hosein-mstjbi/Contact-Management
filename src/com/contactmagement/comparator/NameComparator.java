package com.contactmagement.comparator;

import com.contactmagement.model.Contact;

import java.util.Comparator;

public class NameComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
