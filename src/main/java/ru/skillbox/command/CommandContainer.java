package ru.skillbox.command;

import ru.skillbox.services.CommandServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.skillbox.command.CommandName.*;
import static ru.skillbox.command.CommandName.LOAD;

public class CommandContainer {

    private Map<String, AbstractCommand> commandMap;
    private Command unknownCommand;

    public CommandContainer(CommandServiceImpl commandService) {
        this.commandMap = new HashMap<>();
        this.unknownCommand = new UnknownCommand(commandService);
        commandMap.put(HELP.getCommandName(), new HelpCommand(commandService));
        commandMap.put(EXIT.getCommandName(), new ExitCommand(commandService));
        commandMap.put(LIST.getCommandName(), new ListCommand(commandService));
        commandMap.put(ADD.getCommandName(), new AddCommand(commandService));
        commandMap.put(REMOVE.getCommandName(), new RemoveCommand(commandService));
        commandMap.put(SAVE.getCommandName(), new SaveCommand(commandService));
        commandMap.put(PROFILE.getCommandName(), new ProfileCommand(commandService));
        commandMap.put(LOAD.getCommandName(), new LoadCommand(commandService));
    }

    public Command getCommand(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            return unknownCommand;
        } else {
            return command;
        }
    }
}
