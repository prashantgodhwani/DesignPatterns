package Examples.AmazonLocker.models.user;

public class Agent extends User{
    Agent(String phone) {
        super(phone, UserType.AGENT);
    }
}
