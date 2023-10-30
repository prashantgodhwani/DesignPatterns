package SpecificationDesignPattern.models.specification;

public abstract class CompositeFilter implements Filter {

    @Override
    public Filter and(Filter filter) {
        return new AndFilter(this, filter);
    }

    @Override
    public Filter or(Filter filter) {
        return new OrFilter(this, filter);
    }

    @Override
    public Filter not(Filter filter) {
        return new NotFilter(filter);
    }
}
