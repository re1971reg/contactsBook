package ru.skillbox.command;

import ru.skillbox.services.CommandService;

public class RemoveCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = "Команда в работе";

    public RemoveCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(String[] params) {
        commandService.showText(OUTPUT_INFO);
    }

}
