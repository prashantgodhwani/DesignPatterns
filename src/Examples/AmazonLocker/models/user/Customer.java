package Examples.AmazonLocker.models.user;

public class Customer extends User{
    Customer(String phone) {
        super(phone, UserType.CUSTOMER);
    }
}
