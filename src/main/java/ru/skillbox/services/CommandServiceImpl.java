package ru.skillbox.services;

import ru.skillbox.MainProvider;
import ru.skillbox.model.Contact;
import ru.skillbox.model.ContactList;

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

    @Override
    public void showAllContacts() {
        Map<String, Contact> contacts = mainProvider.getContactList().getContacts();
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
}
