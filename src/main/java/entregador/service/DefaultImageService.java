package entregador.service;

import entregador.telegram.TelegramHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultImageService implements ImageService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultImageService.class);

    private final TelegramHandler handler;

    public DefaultImageService(final TelegramHandler handler) {
        this.handler = handler;
    }

    @Override public void sendImage(byte[] file) {
        if(!handler.getBot().sendPicture(file)){
            LOGGER.error("Could not send image");
        }
    }
}
