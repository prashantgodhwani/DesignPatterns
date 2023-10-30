package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;
import SpecificationDesignPattern.models.Operator;

public class NameFilter extends CompositeFilter {

    private String fileName;

    private final Operator operator;

    public NameFilter(String fileName, Operator operator) {
        this.fileName = fileName;
        this.operator = operator;
    }

    @Override
    public boolean isValid(File file) throws Exception {
        return switch (operator) {
            case LESS_THAN_EQUALS -> throw new Exception("Invalid Operator");
            case GREATER_THAN -> throw new Exception("Invalid Operator");
            case GREATER_THAN_EQUALS -> throw new Exception("Invalid Operator");
            case NOT_EQUALS -> !file.getName().equals(this.fileName);
            case EQUALS -> file.getName().equals(this.fileName);
            case LESS_THAN -> throw new Exception("Invalid Operator");
        };
    }
}
