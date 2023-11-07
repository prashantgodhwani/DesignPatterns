package Examples.AmazonLocker.models.locker;

import Examples.AmazonLocker.models.Size;
import Examples.AmazonLocker.models.order.OrderPackage;
import Examples.AmazonLocker.models.order.OrderType;

public class LockerSlot {

    private final int lockerSlotId;

    private OrderPackage orderPackage;

    private final Size size;

    private int pin;

    private LockerStatus lockerStatus;

    private long placedOn;


    public LockerSlot(int lockerSlotId, Size size) {
        this.lockerSlotId = lockerSlotId;
        this.size = size;
    }

    public OrderPackage getOrderPackage() {
        return orderPackage;
    }

    public int getLockerSlotId() {
        return lockerSlotId;
    }

    public void placeOrderAtSlot(OrderPackage orderPackage) {
        this.placedOn = System.currentTimeMillis();
        OrderType orderType = orderPackage.getOrder().getOrderType();
        if(orderType == OrderType.SALE){
            this.lockerStatus = LockerStatus.ITEM_AVAILABLE_FOR_PICKUP;
        }else if(orderType == OrderType.RETURN){
            this.lockerStatus = LockerStatus.ITEM_AVAILABLE_FOR_RETURN;
        }
        orderPackage.getOrder().deliverOrder();
        this.orderPackage = orderPackage;
    }

    public boolean canContain(OrderPackage orderPackage){
        return switch (orderPackage.getSize()){
            case S -> this.size == Size.S || this.size == Size.M || this.size == Size.L || this.size == Size.XL || this.size == Size.XXL;
            case M -> this.size == Size.M || this.size == Size.L || this.size == Size.XL || this.size == Size.XXL;
            case L -> this.size == Size.L || this.size == Size.XL || this.size == Size.XXL;
            case XL -> this.size == Size.XL || this.size == Size.XXL;
            case XXL -> this.size == Size.XXL;
        };
    }

    public LockerStatus getLockerStatus() {
        return lockerStatus;
    }

    public void setLockerStatus(LockerStatus lockerStatus) {
        this.lockerStatus = lockerStatus;
    }

    public boolean isLockerSlotAvailable(){
        return this.lockerStatus == LockerStatus.AVAILABLE;
    }
}
