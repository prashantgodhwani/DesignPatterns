package CreationalPattern.DecoratorPattern;

public class PizzaBase extends Pizza{
    @Override
    public String description() {
        return super.description() + "Pizza Base";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
