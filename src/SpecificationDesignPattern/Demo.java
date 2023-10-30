package SpecificationDesignPattern;

import SpecificationDesignPattern.models.Directory;
import SpecificationDesignPattern.models.File;
import SpecificationDesignPattern.models.Operator;
import SpecificationDesignPattern.models.specification.ExtensionFilter;
import SpecificationDesignPattern.models.specification.Filter;
import SpecificationDesignPattern.models.specification.NameFilter;

import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        new Demo().test();
    }

    private void test() throws Exception {

        File xmlFile = new File();
        xmlFile.setContent("aaa.xml".getBytes());
        xmlFile.setName("aaa.xml");

        File txtFile = new File();
        txtFile.setContent("bbb.txt".getBytes());
        txtFile.setName("bbb.txt");

        File jsonFile = new File();
        jsonFile.setContent("ccc.json".getBytes());
        jsonFile.setName("ccc.json");

        Directory dir1 = new Directory();
        dir1.addEntry(txtFile);
        dir1.addEntry(xmlFile);

        Directory dir0 = new Directory();
        dir0.addEntry(jsonFile);
        dir0.addEntry(dir1);

        NameFilter nameFilter = new NameFilter("aaa", Operator.EQUALS);
        ExtensionFilter extensionSpecification = new ExtensionFilter("xml");
        Filter compositeSpecification = nameFilter.and(extensionSpecification);
        FileSearcher fileSearcher = new FileSearcher();
        List<File> files = fileSearcher.search(dir1, compositeSpecification);
        System.out.println(files);

    }
























}