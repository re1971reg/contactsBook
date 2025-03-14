package ru.skillbox.command;

import ru.skillbox.services.CommandService;

import java.util.List;

public class ProfileCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = "Команда в работе";

    public ProfileCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(List<String> params) {
        commandService.showText(OUTPUT_INFO);
    }

}
