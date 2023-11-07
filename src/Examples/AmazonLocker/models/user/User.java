package Examples.AmazonLocker.models.user;

public abstract class User {

    String phone;

    UserType userType;

    User(String phone, UserType userType){
        this.phone = phone;
        this.userType = userType;
    }

}
