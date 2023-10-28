package CreationalPattern.DecoratorPattern.decorators;

import CreationalPattern.DecoratorPattern.Pizza;

public class PaperJackCheese extends PizzaToppingDecorator {
    public PaperJackCheese(Pizza topping) {
        super(topping);
    }

    public String description(){
        return super.description() + " + PaperJack Cheese";
    }

    public int cost(){
        return super.cost() + 2;
    }
}
