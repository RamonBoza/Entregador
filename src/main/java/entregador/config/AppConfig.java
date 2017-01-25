package entregador.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${bot.id}")
    public String botId;

    @Value("${bot.secret}")
    public String botSecret;

    @Value("${bot.chatId}")
    public String chatId;
}