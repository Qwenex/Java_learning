package org.example.observerPattern.subscribers;

/**
 * Имитация подписчика для рассылки писем на электронную почту.
 */
public class EmailSubscriber implements Subscriber {

    @Override
    public void update(String massage) {
        System.out.println("Произошла рассылка сообщений на почту: {" + massage + "}");
    }
}
