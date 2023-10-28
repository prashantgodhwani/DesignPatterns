package CreationalPattern.DecoratorPattern.decorators;

import CreationalPattern.DecoratorPattern.Pizza;

public class PizzaToppingDecorator extends Pizza {

    private Pizza topping;

    PizzaToppingDecorator(Pizza topping){
        this.topping = topping;
    }

    public String description() {
        return topping.description();
    }

    public int cost() {
        return topping.cost();
    }
}
