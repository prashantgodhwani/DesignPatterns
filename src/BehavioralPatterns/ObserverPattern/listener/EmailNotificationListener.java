package BehavioralPatterns.ObserverPattern.listener;

import java.io.File;

public class EmailNotificationListener implements EventListener<File>{

    private String email;

    public EmailNotificationListener(String email){
        this.email = email;
    }
    @Override
    public void update(String event, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + event + " operation with the following file: " + file.getName());
    }
}
