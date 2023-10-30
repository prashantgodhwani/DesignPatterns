package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;

public class NotFilter extends CompositeFilter {

    private Filter specification;

    public NotFilter(Filter specification){
        this.specification = specification;
    }

    @Override
    public boolean isValid(File file) throws Exception {
        return !specification.isValid(file);
    }
}
