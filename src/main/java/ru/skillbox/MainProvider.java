package ru.skillbox;

import org.springframework.stereotype.Component;
import ru.skillbox.command.CommandContainer;
import ru.skillbox.config.ProviderProperties;
import ru.skillbox.model.Contact;
import ru.skillbox.model.ContactList;
import ru.skillbox.servises.CommandServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Scanner;

@Component
public class MainProvider {

    private ProviderProperties properties;
    private ContactList contactList;
    private final CommandContainer commandContainer;

    public MainProvider(ProviderProperties properties, ContactList contactList) {
        System.out.println("create MainProvider");
        this.properties = properties;
        this.contactList = contactList;
        this.commandContainer = new CommandContainer(new CommandServiceImpl(this));
        System.out.println(MessageFormat.format("MainProvider created with properties: {0}", properties));
    }

    public void run() {
        System.out.println("Приложение запущено. Укажите команду.\nКоманда для выхода: exit; список команд: help;");
        if (properties.getProfile().equalsIgnoreCase("init")) {
            loadContactsFromFile();
        }
        while (true) {
            System.out.print("> ");
            String inputCode = new Scanner(System.in).nextLine();

            if (inputCode.equalsIgnoreCase("exit")) {
                break;
            }
            parseInputCode(inputCode);
        }
    }

    private void parseInputCode(String inputCode) {

    }

    private void loadContactsFromFile() {
        InputStream inputStream = MainProvider.class.getClassLoader().getResourceAsStream(properties.getLoaderFileName());
        if (inputStream == null) {
            return;
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                addContact(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(
                MessageFormat.format("Exception occurred during reading the file: {0}\n{1}", properties.getLoaderFileName(), e.getMessage())
            );

        }
    }

    private void addContact(String line) {
        String[] row = line.split(";");
        Contact contact = new Contact.Builder().name(row[0]).phone(row[1]).email(row[2]).build();
        contactList.putItem(contact);
    }
}
