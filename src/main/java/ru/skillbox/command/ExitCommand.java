package ru.skillbox.command;

import ru.skillbox.services.CommandService;

import java.util.List;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(List<String> params) {
        commandService.exitProgramm();
    }
}
