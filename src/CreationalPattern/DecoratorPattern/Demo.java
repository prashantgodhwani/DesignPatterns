package CreationalPattern.DecoratorPattern;

import CreationalPattern.DecoratorPattern.decorators.Chicken;
import CreationalPattern.DecoratorPattern.decorators.PaperJackCheese;
import CreationalPattern.DecoratorPattern.decorators.ParmesanCheese;

public class Demo {
    public static void main(String[] args) {
        Pizza pizza = new ParmesanCheese(new Chicken( new PaperJackCheese(new PizzaBase())));
        System.out.println(pizza.description());
        System.out.println(pizza.cost());
    }
}
