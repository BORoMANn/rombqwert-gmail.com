import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot {
    private static final Logger LOG = LoggerFactory.getLogger(Bot.class);
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                //LOG.warn("loh");
                e.printStackTrace();
            }
        }

    }



    public void onUpdatesReceived(List<Update> updates) {

    }

    public String getBotUsername() {
        return "MyTestBot";
    }

    public String getBotToken() {
        return "1033867838:AAHCvGYPceslAmjDqdPwZCiGQAgOprzpDNw";
    }
}

