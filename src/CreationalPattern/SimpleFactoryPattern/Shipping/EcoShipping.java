package CreationalPattern.SimpleFactoryPattern.Shipping;

public class EcoShipping implements Shipping{
    @Override
    public void ship(String location) {
        System.out.println("Eco Shipping to " + location);
    }

    @Override
    public int cost() {
        return 5;
    }
}
