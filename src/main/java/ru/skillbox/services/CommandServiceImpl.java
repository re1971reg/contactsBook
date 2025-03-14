package ru.skillbox.services;

import ru.skillbox.MainProvider;
import ru.skillbox.exceptions.AddCommandException;
import ru.skillbox.model.Contact;

import java.text.MessageFormat;
import java.util.List;
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
        int count = mainProvider.getContactList().getCount();
        if (count == 0) {
            mainProvider.output("Список контактов пустой.");
            return;
        }

        Map<String, Contact> contacts = mainProvider.getContactList().getContacts();

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
        if (mainProvider.getContactList().contactExists(contact.getEmail())) {
            throw new AddCommandException(
                MessageFormat.format("Контакт с email {0} уже существует", contact.getEmail())
            );
        }
        mainProvider.getContactList().putItem(contact);
        mainProvider.output("Контакт добавлен");
    }

    @Override
    public String getInputLine() {
        return mainProvider.getInputLine();
    }

    @Override
    public void removeContact(String email) {
        if (!mainProvider.getContactList().contactExists(email)) {
            throw new AddCommandException(MessageFormat.format("Контакт с email <{0}> отсутствует", email));
        }
        mainProvider.getContactList().removeItem(email);
        mainProvider.output("Контакт удалён");
    }
}
