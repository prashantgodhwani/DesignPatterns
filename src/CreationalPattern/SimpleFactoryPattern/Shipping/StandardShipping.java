package CreationalPattern.SimpleFactoryPattern.Shipping;

public class StandardShipping implements Shipping{
    @Override
    public void ship(String location) {
        System.out.println("Standard Shipping to " + location);
    }

    @Override
    public int cost() {
        return 10;
    }
}
