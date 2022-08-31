package faust.telegrambot.messageSender;

import org.springframework.stereotype.Service;
import faust.telegrambot.CampusBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private CampusBot campusBot;
    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            campusBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    public void setCampusBot(CampusBot campusBot) {
        this.campusBot = campusBot;
    }
}
