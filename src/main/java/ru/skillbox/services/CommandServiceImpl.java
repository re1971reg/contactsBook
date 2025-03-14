package ru.skillbox.services;

import ru.skillbox.MainProvider;
import ru.skillbox.exceptions.AddCommandException;
import ru.skillbox.model.Contact;

import java.text.MessageFormat;
import java.util.Map;

public class CommandServiceImpl implements CommandService {

    private MainProvider mainProvider;

    public CommandServiceImpl(MainProvider mainProvider) {
        this.mainProvider = mainProvider;
    }

    @Override
    public void showText(String text) {
        mainProvider.output(text);
    }

    @Override
    public void exitProgramm() {
        mainProvider.setNextLoop(false);
    }

    private Map<String, Contact> getContactsMap() {
        return mainProvider.getContactList().getContacts();
    }

    @Override
    public void showAllContacts() {
        Map<String, Contact> contacts = getContactsMap();
        if (contacts.isEmpty()) {
            mainProvider.output("Список контактов пустой.");
            return;
        }
        contacts.forEach((key, value) -> {
                StringBuilder sb = new StringBuilder()
                    .append(value.getName()).append("|")
                    .append(value.getPhone()).append("|")
                    .append(value.getEmail());
                mainProvider.output(sb.toString());
            }
        );
    }

    @Override
    public void addContact(Contact contact) {
        Map<String, Contact> contacts = getContactsMap();
        if (contacts.containsKey(contact.getEmail())) {
            throw new AddCommandException(
                MessageFormat.format("Контакт с email {0} уже существует", contact.getEmail())
            );
        }
        contacts.put(contact.getEmail(), contact);
    }

    @Override
    public String getInputLine() {
        return mainProvider.getInputLine();
    }
}
