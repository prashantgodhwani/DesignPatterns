package BehavioralPatterns.ObserverPattern.listener;

import java.io.File;

public class LogNotificationListener implements EventListener<File>{

    private File logFile;

    public LogNotificationListener(String logFile){
        this.logFile = new File(logFile);
    }

    @Override
    public void update(String event, File file) {
        System.out.println("Save to log " + logFile + ": Someone has performed " + event + " operation with the following file: " + file.getName());
    }
}
