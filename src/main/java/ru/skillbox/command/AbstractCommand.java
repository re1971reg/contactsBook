package ru.skillbox.command;

import ru.skillbox.services.CommandService;

public abstract class AbstractCommand implements Command {

//    private List<String> params; // список параметров к текущей команде
    CommandService commandService; // сервис-слой между командой и интерфейсом


    public AbstractCommand(CommandService commandService) {
        this.commandService = commandService;
    }

}
