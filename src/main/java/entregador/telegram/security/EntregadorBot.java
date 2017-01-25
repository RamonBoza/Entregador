package entregador.telegram.security;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import entregador.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EntregadorBot implements Bot {

    private final static Logger LOGGER = LoggerFactory.getLogger(EntregadorBot.class);

    private final TelegramBot bot;
    private final String chatId;

    public EntregadorBot(AppConfig appConfig) {
        this.chatId = appConfig.chatId;
        this.bot = TelegramBotAdapter.build(BotTokenGenerator.generateToken(appConfig));
    }

    public boolean sendPicture(byte[] picture) {
        SendPhoto sendPhotoRequest = new SendPhoto(this.chatId,picture);
        SendResponse response = bot.execute(sendPhotoRequest);
        return response.isOk();
    }

    public boolean sendMessage(String message) {
        SendMessage sendMessage = new SendMessage(this.chatId,message);
        SendResponse response = bot.execute(sendMessage);
        LOGGER.info("Message sent with response: {}",response);
        return response.isOk();
    }

}
