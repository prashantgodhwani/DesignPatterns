package BehavioralPatterns.ObserverPattern.listener;

public interface EventListener<T> {
    void update(String event, T data);

}
