package entregador.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class DefaultJmsMessageReceiver implements JmsMessageReceiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultJmsMessageReceiver.class);

    private JmsTemplate jmsTemplate;

    public DefaultJmsMessageReceiver(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override public Object receive() {
        return (Object) jmsTemplate.receiveAndConvert("Send2Recv");
    }
}
