package CreationalPattern.DecoratorPattern.decorators;

import CreationalPattern.DecoratorPattern.Pizza;

public class ParmesanCheese extends PizzaToppingDecorator {
    public ParmesanCheese(Pizza topping) {
        super(topping);
    }

    public String description(){
        return super.description() + " + Parmesan Cheese";
    }

    public int cost(){
        return super.cost() + 1;
    }
}
