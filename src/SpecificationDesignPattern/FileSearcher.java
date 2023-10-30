package SpecificationDesignPattern;

import SpecificationDesignPattern.models.Directory;
import SpecificationDesignPattern.models.File;
import SpecificationDesignPattern.models.IEntry;
import SpecificationDesignPattern.models.specification.Filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileSearcher {
    public List<File> search(Directory dir, Filter compositeSpecification) throws Exception {
        List<File> files = new ArrayList<>();

        Queue<Directory> queue = new LinkedList<>();
        queue.add(dir);

        while (!queue.isEmpty()) {
            Directory folder = queue.poll();

            for (IEntry entry : folder.getEntries()) {
                if (entry.isDirectory()) {
                    queue.add((Directory) entry);
                } else {
                    File file = (File) entry;
                    if (compositeSpecification.isValid(file)) {
                        files.add(file);
                    }
                }
            }
        }

        return files;
    }
}
