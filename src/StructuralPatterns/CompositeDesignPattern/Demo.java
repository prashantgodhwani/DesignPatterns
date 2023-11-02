package StructuralPatterns.CompositeDesignPattern;

public class Demo {

    public static void main(String[] args) {
        File file1 = new File();
        file1.setName("xyz.txt");
        File file2 = new File();
        file2.setName("abx.json");
        File file3 = new File();
        file3.setName("abx.txt");

        Directory dir0 = new Directory();
        dir0.setName("dir0");
        dir0.addEntry(file1);
        dir0.addEntry(file2);

        Directory dir1 = new Directory();
        dir1.setName("dir1");
        dir1.addEntry(dir0);
        dir1.addEntry(file3);

        dir1.ls();
    }

}
