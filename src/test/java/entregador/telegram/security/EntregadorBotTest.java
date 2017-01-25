package entregador.telegram.security;

import entregador.config.AppConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class EntregadorBotTest {

    private Bot entregadorBot;
    private final static String TEST_FILENAME = "motivation.jpg";

    @Before
    public void before() {
        AppConfig appConfig = getAppConfig();

        entregadorBot = new EntregadorBot(appConfig);
    }

    @Test
    public void sendMessageResponsesWithOk() {
        Assert.assertTrue(entregadorBot.sendMessage("testing private channel"));
    }

    @Test
    public void sendPictureResponsesWithOk() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(TEST_FILENAME).getFile());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(ImageIO.read(file),"jpg",baos);
        Assert.assertTrue(entregadorBot.sendPicture(baos.toByteArray()));
    }


    private AppConfig getAppConfig() {
        AppConfig appConfig = new AppConfig();
        appConfig.botId = "307136580";
        appConfig.botSecret = "AAG4pE_w_XuaTiHhUDed-bCD25u1LEbY0As";
        appConfig.chatId = "-1001073433496"; // HANDICAPS
        //appConfig.chatId = "-1001070649480"; // RB_Test
        //appConfig.chatId = "-1001066672572"; //RB_Others
        return appConfig;
    }
}