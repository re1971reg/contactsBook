package ru.skillbox.services;

import ru.skillbox.model.Contact;

public interface CommandService {

    //void sendMessage(SendMessage message);

    void showText(String text);

    void exitProgramm();

    void showAllContacts();

    void addContact(Contact contact);

    String getInputLine();

//    void getError();

}
