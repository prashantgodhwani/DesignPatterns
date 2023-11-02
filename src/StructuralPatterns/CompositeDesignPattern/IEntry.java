package StructuralPatterns.CompositeDesignPattern;

public interface IEntry {

    String getName();

    void setName(String name);

    int getSize();

    boolean isDirectory();

    void ls();
}