package CreationalPattern.SimpleFactoryPattern;

import CreationalPattern.SimpleFactoryPattern.Shipping.Shipping;
import CreationalPattern.SimpleFactoryPattern.Shipping.ShippingFactory;

import java.util.Scanner;

public class Demo {

    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        String location = scanner.next();
        String shippingType = scanner.next();

        //Static Factory Pattern because the ShippingFactory is static
        Shipping shippingMedium = ShippingFactory.ship(shippingType);
        shippingMedium.ship(location);
    }
}
