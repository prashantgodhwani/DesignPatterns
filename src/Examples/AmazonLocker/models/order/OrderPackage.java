package Examples.AmazonLocker.models.order;

import Examples.AmazonLocker.models.Size;

public class OrderPackage {

    private final Order order;

    private final Size size;

    public OrderPackage(Order order, Size size) {
        this.order = order;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public Order getOrder() {
        return order;
    }
}
