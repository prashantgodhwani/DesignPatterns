package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;

public class ExtensionFilter extends CompositeFilter {

    private String extension;

    public ExtensionFilter(String ext){
        this.extension = ext;
    }

    @Override
    public boolean isValid(File file) {
        return file.getExtension().equals(this.extension);
    }
}
