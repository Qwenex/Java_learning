package org.example.observerPattern.subscribers;

/**
 * Имитация подписчика для рассылки по смс на телефон.
 */
public class PhoneSmsSubscriber implements Subscriber {

    @Override
    public void update(String massage) {
        System.out.println("Произошла рассылка смс на телефон: {" + massage + "}");
    }
}
