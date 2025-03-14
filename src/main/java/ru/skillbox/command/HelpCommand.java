package ru.skillbox.command;

import ru.skillbox.services.CommandService;

import static ru.skillbox.command.CommandName.*;

public class HelpCommand extends AbstractCommand {

    private static final String OUTPUT_INFO = prepareOutputInfo();

    private static String prepareOutputInfo() {
        StringBuilder sb = new StringBuilder("")
            .append("Список доступных команд:\n\t")
            .append(EXIT.getCommandName()).append(" - выход из модуля, завершение работы приложения;\n\t")
            .append(HELP.getCommandName()).append(" - вывод на экран списка команд;\n\t")
            .append(LIST.getCommandName()).append(" - вывод на экран списка контактов в формате «Ф.И.О. | Номер телефона | Адрес электронной почты»;\n\t")
            .append(ADD.getCommandName()).append(" <fio;phone_number;email>` - добавление нового контакта. идентификация контакта делается по полю \"email\";\n\t")
            .append(REMOVE.getCommandName()).append(" <email> - удаление контакта по имени почтового ящика;\n\t")
            .append(SAVE.getCommandName()).append(" [<file_name>] - сохранение всех контактов в файл \"file_name\", если \"file_name\" отсутсвует, то сохранение " +
                "делается в файл, который указан в переменной contacts.storage.saveFileName;\n\t")
            .append(PROFILE.getCommandName()).append(" - варианты переменных окружения приложения в файле \"application.yaml\" или \"application.properties\";\n\t")
            .append(LOAD.getCommandName()).append(" <file_name> - загрузка новых контактов из файла \"file_name\";");

        return sb.toString();
    }

    public HelpCommand(CommandService commandService) {
        super(commandService);
    }

    @Override
    public void execute(String[] params) {
        commandService.showText(OUTPUT_INFO);
    }
}
