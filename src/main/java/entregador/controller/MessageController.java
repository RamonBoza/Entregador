package entregador.controller;

import entregador.model.Message;
import entregador.service.ImageService;
import entregador.service.MessageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController public class MessageController {

    private final MessageService messageService;

    private final ImageService imageService;

    public MessageController(final MessageService messageService, final ImageService imageService) {
        this.messageService = messageService;
        this.imageService = imageService;
    }

    @RequestMapping("/message")
    public Message message(@RequestBody(required = true) String message) {
        messageService.sendMessage(message);
        return new Message(1, "");
    }

    @RequestMapping("/image")
    public Message image(@RequestParam("file") MultipartFile image) throws IOException {
        imageService.sendImage(image.getBytes());
        return new Message(1, "");
    }

}
