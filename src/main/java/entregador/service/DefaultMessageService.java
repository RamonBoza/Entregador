package entregador.service;

import entregador.telegram.TelegramHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultMessageService implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMessageService.class);

    private final TelegramHandler messageBot;

    public DefaultMessageService(TelegramHandler handler) {
        this.messageBot = handler;
    }

    @Override public void sendMessage(String message) {
        if(!this.messageBot.getBot().sendMessage(message)){
            LOGGER.error("Imposible to send message to the bot");
        }
    }
}
