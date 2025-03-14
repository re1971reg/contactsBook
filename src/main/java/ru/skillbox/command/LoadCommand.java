package ru.skillbox.command;

import ru.skillbox.services.CommandService;

import java.util.List;

public class LoadCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = "Команда в работе";

    public LoadCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(List<String> params) {
        commandService.showText(OUTPUT_INFO);
    }

}
