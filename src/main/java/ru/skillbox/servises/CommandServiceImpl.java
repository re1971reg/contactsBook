package ru.skillbox.servises;

import ru.skillbox.MainProvider;

public class CommandServiceImpl implements CommandService {

    private MainProvider mainProvider;

    public CommandServiceImpl(MainProvider mainProvider) {
        this.mainProvider = mainProvider;
    }

    @Override
    public void sendMessage(String message) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chatId);
//        sendMessage.enableHtml(true);
//        sendMessage.setText(message);
//
//        try {
//            javarushBot.execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

}
