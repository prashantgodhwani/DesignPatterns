package CreationalPattern.DecoratorPattern.decorators;

import CreationalPattern.DecoratorPattern.Pizza;

public class Capsicum extends PizzaToppingDecorator {
    public Capsicum(Pizza topping) {
        super(topping);
    }

    public String description(){
        return super.description() + " + Capsicum";
    }

    public int cost(){
        return super.cost() + 1;
    }
}
