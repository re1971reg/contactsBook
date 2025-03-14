package ru.skillbox.command;

import ru.skillbox.services.CommandService;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(String[] params) {
        commandService.exitProgramm();
    }
}
