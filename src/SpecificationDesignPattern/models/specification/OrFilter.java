package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;

public class OrFilter extends CompositeFilter {

    private Filter left;
    private Filter right;

    public OrFilter(Filter left, Filter right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isValid(File file) throws Exception {
        return left.isValid(file) || right.isValid(file);
    }
}
