package ru.skillbox.command;

public enum CommandName {

    ADD("add"),
    EXIT("exit"),
    HELP("help"),
    REMOVE("remove"),
    SAVE("save"),
    PROFILE("profile"),
    LOAD("load"),
    LIST("list");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName.toLowerCase();
    }
}
