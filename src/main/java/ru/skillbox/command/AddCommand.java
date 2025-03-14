package ru.skillbox.command;

import ru.skillbox.exceptions.AddCommandException;
import ru.skillbox.model.Contact;
import ru.skillbox.services.CommandService;

import java.util.*;

public class AddCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = "Команда в работе";

    public AddCommand(CommandService commandService) {
        super(commandService);
    }

    private List<String> getContactData(String contactLine) {
        String[] contactArray = contactLine.split(";");
        if (contactArray.length < 3) {
            throw new AddCommandException("Данные о контакте должны быть в виде \"ФИО;телефон;email\"");
        }
        return Arrays.asList(contactArray);
    }

    @Override
    public void execute(List<String> params) {
//        System.out.println("params: " + params.toString());
        validateInputInfo(params);
        String inputLine = commandService.getInputLine();
        String contactLine = inputLine.substring(inputLine.indexOf(params.get(1)));
//        System.out.println("contactLine: " + contactLine);
//        if (contactLine.isBlank()) {
//            throw new AddCommandException("Укажите информацию контакта");
//        }
        List<String> contactData = getContactData(contactLine);
        try {
            Contact contact = new Contact.Builder()
                .name(contactData.get(0))
                .phone(contactData.get(1))
                .email(contactData.get(2))
                .build();
            commandService.addContact(contact);
        } catch (AddCommandException exp) {
            commandService.showText(exp.getMessage());
        }

    }

    private void validateInputInfo(List<String> params) throws AddCommandException {
        if (params.size() < 2) {
            throw new AddCommandException("Укажите информацию контакта");
        }
    }
}
