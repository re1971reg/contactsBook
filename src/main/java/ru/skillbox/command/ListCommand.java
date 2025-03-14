package ru.skillbox.command;

import ru.skillbox.services.CommandService;

import java.util.List;

public class ListCommand extends AbstractCommand {

    public ListCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(List<String> params) {
        commandService.showAllContacts();
    }

}
