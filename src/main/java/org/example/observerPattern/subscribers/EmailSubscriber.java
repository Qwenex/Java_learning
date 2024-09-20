package org.example.observerPattern.subscribers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Имитация подписчика для рассылки писем на электронную почту.
 */
public class EmailSubscriber implements Subscriber {

    public static Logger logger = LoggerFactory.getLogger(EmailSubscriber.class);

    @Override
    public void update(String massage) {
        logger.info("Произошла рассылка сообщений на почту: {" + massage + "}");
    }
}
