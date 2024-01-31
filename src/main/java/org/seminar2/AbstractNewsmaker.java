package org.seminar2;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNewsmaker implements Newsmaker {

    protected String message;
    private final List<Subscriber> subscribers = new ArrayList();


    @Override
    public void sendMessage() {
        for (Subscriber subscriber : subscribers) {
            subscriber.getMessage(message);
        }
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public abstract void setMessage(String message);
}
