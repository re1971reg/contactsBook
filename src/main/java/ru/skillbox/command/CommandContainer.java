package ru.skillbox.command;

import ru.skillbox.servises.SendMessageService;

import java.util.HashMap;
import java.util.Map;

import static ru.skillbox.command.CommandName.HELP;

public class CommandContainer {

    private Map<String, AbstractCommand> commandMap;
    //private AbstractCommand unknownCommand;

    public CommandContainer(SendMessageService sendMessageService) {
        //this.unknownCommand = new UnknownCommand(sendMessageService);
        this.commandMap = new HashMap<>();
        commandMap.put(HELP.getCommandName(), new HelpCommand(sendMessageService));
    }
}
