package entregador.telegram.security;

import entregador.config.AppConfig;

public class BotTokenGenerator {

    public static String generateToken(AppConfig appConfig) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(appConfig.botId)
                .append(":")
                .append(appConfig.botSecret)
                .toString();
    }
}
