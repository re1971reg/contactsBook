package ru.skillbox.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ContactList {

    private Map<String, Contact> contacts;

    public ContactList() {
        this.contacts = new HashMap<>();
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void putItem(Contact contact) {
        contacts.put(contact.getEmail().toLowerCase(), contact);
    }

    public void removeItem(String email) {
        contacts.remove(email.toLowerCase());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactList={");
        sb.append("contacts=").append(contacts);
        sb.append('}');
        return sb.toString();
    }
}
