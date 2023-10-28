package CreationalPattern.SimpleFactoryPattern.Shipping;

public interface Shipping {
    void ship(String location);
    int cost();
}
