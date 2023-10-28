package BehavioralPatterns.ObserverPattern.editor;

import BehavioralPatterns.ObserverPattern.publisher.EventManager;
import java.io.File;

public class Editor {
    public EventManager<File> eventManager;
    private File file;

    public Editor(){
        this.eventManager = new EventManager("save", "open");
    }

    public void openFile(String filePath){
        this.file = new File(filePath);
        eventManager.notify("open", file);
    }

    public void saveFile() throws Exception {
        if(this.file != null){
            eventManager.notify("save", file);
        }else{
            throw new Exception("Please open a file first");
        }
    }
}
