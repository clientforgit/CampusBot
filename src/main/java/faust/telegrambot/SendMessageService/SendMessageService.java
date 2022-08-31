package faust.telegrambot.SendMessageService;

import faust.telegrambot.messageSender.MessageSender;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Service
public class SendMessageService {
    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    public void test1(Message message) {
        SendMessage sm = SendMessage.builder()
                .text("<b>Bold</b> " +
                        "<i>italic</i> " +
                        "<code>mono</code> " +
                        "<a href=\"google.com\">Google</a>")
                .parseMode("HTML")
                .chatId(message.getChatId())
                .build();
        messageSender.sendMessage(sm);
    }
    public void test2(Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add("Button 1");
        row1.add("Button 2");
        row1.add("Button 3");
        row2.add(KeyboardButton.builder()
                .text("Phone number")
                .requestContact(true)
                .build());
        row3.add(KeyboardButton.builder()
                .text("Location")
                .requestLocation(true)
                .build());
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("text");
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyMarkup(markup);
        messageSender.sendMessage(sendMessage);

    }
}
