package ru.skillbox.command;

import ru.skillbox.MainProvider;
import ru.skillbox.servises.CommandService;

public abstract class AbstractCommand {

    private CommandService messageService;

    public AbstractCommand(MainProvider provider) {
        this.provider = provider;
    }

    public abstract void execute();
}
