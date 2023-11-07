package Examples.AmazonLocker.models.order;

import Examples.AmazonLocker.models.location.GeographicLocation;

import java.util.List;

public class Order {

    private final String orderId;

    private final List<Item> items;

    private final OrderType orderType;

    private final GeographicLocation deliveryLocation;

    private long deliveryDate;

    public Order(String orderId, List<Item> items, OrderType orderType, GeographicLocation deliveryLocation) {
        this.orderId = orderId;
        this.items = items;
        this.orderType = orderType;
        this.deliveryLocation = deliveryLocation;
    }

    public void deliverOrder(){
        this.deliveryDate = System.currentTimeMillis();
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
