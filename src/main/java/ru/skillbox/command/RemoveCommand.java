package ru.skillbox.command;

import ru.skillbox.exceptions.AddCommandException;
import ru.skillbox.services.CommandService;

import java.util.List;

public class RemoveCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = "Команда в работе";

    public RemoveCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(List<String> params) {
        validateInputInfo(params);
        commandService.removeContact(params.get(1));
    }

    private void validateInputInfo(List<String> params) throws AddCommandException {
        if (params.size() < 2) {
            throw new AddCommandException("Укажите email");
        }
    }

}
