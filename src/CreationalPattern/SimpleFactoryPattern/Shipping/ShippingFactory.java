package CreationalPattern.SimpleFactoryPattern.Shipping;

public class ShippingFactory {

    public static Shipping ship(String type) throws Exception {
        switch (type){
            case "EXPRESS" :
                return new ExpressShipping();
            case "STANDARD":
                return new StandardShipping();
            case "ECO":
                return new EcoShipping();
            default:
                throw new Exception("Invalid option");
        }
    }
}
