package SpecificationDesignPattern.models.specification;

import SpecificationDesignPattern.models.File;

public interface Filter {

    boolean isValid(File file) throws Exception;

    Filter and(Filter filter);

    Filter or(Filter filter);

    Filter not(Filter filter);
}
