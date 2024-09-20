package org.example.observerPattern.subscribers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Имитация подписчика для рассылки по смс на телефон.
 */
public class PhoneSmsSubscriber implements Subscriber {

    public static Logger logger = LoggerFactory.getLogger(PhoneSmsSubscriber.class);

    @Override
    public void update(String massage) {
        logger.info("Произошла рассылка смс на телефон: {" + massage + "}");
    }
}
