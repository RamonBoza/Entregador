package entregador.telegram.security;

public interface Bot {

    boolean sendMessage(String text);

    boolean sendPicture(byte[] picture);

}
