package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;
import SpecificationDesignPattern.models.Operator;

public class SizeFilter extends CompositeFilter {

    private final int maxSize;

    private final Operator operator;

    SizeFilter(Operator operator, int maxSize){
        this.operator = operator;
        this.maxSize = maxSize;
    }

    @Override
    public boolean isValid(File file) {
        return switch (operator) {
            case LESS_THAN_EQUALS -> file.getSize() <= this.maxSize;
            case GREATER_THAN -> file.getSize() > this.maxSize;
            case GREATER_THAN_EQUALS -> file.getSize() >= this.maxSize;
            case NOT_EQUALS -> file.getSize() != this.maxSize;
            case EQUALS -> file.getSize() == this.maxSize;
            case LESS_THAN -> file.getSize() < this.maxSize;
        };
    }

}