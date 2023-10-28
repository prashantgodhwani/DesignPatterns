package CreationalPattern.DecoratorPattern.decorators;

import CreationalPattern.DecoratorPattern.Pizza;

public class Chicken extends PizzaToppingDecorator {
    public Chicken(Pizza topping) {
        super(topping);
    }

    public String description(){
        return super.description() + " + Chicken";
    }

    public int cost(){
        return super.cost() + 10;
    }
}
