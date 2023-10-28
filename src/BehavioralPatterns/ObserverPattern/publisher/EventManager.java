package BehavioralPatterns.ObserverPattern.publisher;

import BehavioralPatterns.ObserverPattern.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager<T> {

    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations){
        for(String operation : operations){
            listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String operation, EventListener el){
        listeners.get(operation).add(el);
    }

    public void unsubcribe(String operation, EventListener el){
        listeners.get(operation).remove(el);
    }

    public void notify(String operation, T data){
        for(EventListener el : listeners.get(operation)){
            el.update(operation, data);
        }
    }
}
