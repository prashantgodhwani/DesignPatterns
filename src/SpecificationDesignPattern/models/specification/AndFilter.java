package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;

public class AndFilter extends CompositeFilter {

    private Filter left;
    private Filter right;

    public AndFilter(Filter left, Filter right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isValid(File file) throws Exception {
        return left.isValid(file) && right.isValid(file);
    }
}
