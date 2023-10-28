package BehavioralPatterns.ObserverPattern;

import BehavioralPatterns.ObserverPattern.editor.Editor;
import BehavioralPatterns.ObserverPattern.listener.EmailNotificationListener;
import BehavioralPatterns.ObserverPattern.listener.LogNotificationListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.eventManager.subscribe("open", new LogNotificationListener("/path/to/log/file.txt"));
        editor.eventManager.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}