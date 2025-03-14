package ru.skillbox.command;

import ru.skillbox.services.CommandService;

import java.util.List;

public class UnknownCommand extends AbstractCommand {

    private final String OUTPUT_INFO = "Неизвестная команда. Для просмотра списка доступных команд наберите \"help\"";

    public UnknownCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(List<String> params) {
        commandService.showText(OUTPUT_INFO);
    }
}
