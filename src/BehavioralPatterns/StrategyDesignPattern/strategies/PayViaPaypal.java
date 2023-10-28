package BehavioralPatterns.StrategyDesignPattern.strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayViaPaypal implements PayStrategy{

    private boolean signedIn;
    private String email;
    private String password;
    private Scanner scanner = new Scanner(System.in);

    private static final Map<String, String> DATABASE = new HashMap<>();

    static {
        DATABASE.put("pra.godhwani@gmail.com", "test");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if(signedIn){
            System.out.println("Paying " + paymentAmount + " using Paypal.");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try{
            while(!signedIn){
                System.out.println("Enter user's email: ");
                email = scanner.next();

                System.out.println("Enter user's password: ");
                password = scanner.next();

                if(verify()){
                    System.out.println("Data verified.");
                }else{
                    System.out.println("Wrong email or password");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private boolean verify(){
         setSignedIn(DATABASE.containsKey(email) && DATABASE.get(email).equals(password));
         return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
