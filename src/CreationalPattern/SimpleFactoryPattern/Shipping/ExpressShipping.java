package CreationalPattern.SimpleFactoryPattern.Shipping;

public class ExpressShipping implements Shipping{
    @Override
    public void ship(String location) {
        System.out.println("Express Shipping to " + location);
    }

    @Override
    public int cost() {
        return 20;
    }
}
