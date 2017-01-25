package entregador.telegram;

import entregador.telegram.security.Bot;
import org.springframework.stereotype.Component;

@Component
public class TelegramHandler {

    private final Bot bot;

    public TelegramHandler(Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return bot;
    }


}
