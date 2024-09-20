package org.example.observerPattern.publishers;

import org.example.observerPattern.subscribers.Subscriber;

public interface Publisher {

    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notification(String massage);
}
