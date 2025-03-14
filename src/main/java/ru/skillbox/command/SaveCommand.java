package ru.skillbox.command;

import ru.skillbox.services.CommandService;

public class SaveCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = "Команда в работе";

    public SaveCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(String[] params) {
        commandService.showText(OUTPUT_INFO);
    }

}
