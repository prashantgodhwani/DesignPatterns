package Examples.ATM.models.atm;

import java.util.Scanner;

public class Panel {

    private static Scanner sc;

    public Panel(){
        sc = new Scanner(System.in);
    }

    public int readInput(){
        return sc.nextInt();
    }

}
