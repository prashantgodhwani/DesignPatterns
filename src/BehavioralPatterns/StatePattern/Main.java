package BehavioralPatterns.StatePattern;

import BehavioralPatterns.StatePattern.models.Item;
import BehavioralPatterns.StatePattern.models.VendingMachine;
import BehavioralPatterns.StatePattern.state.State;
import BehavioralPatterns.StatePattern.models.*;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine();
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on Product Selection");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.onProductSelectionClick(vendingMachine);

            System.out.println("|");
            System.out.println("Selecting Product");
            System.out.println("|");

            vendingState = vendingMachine.getVendingMachineState();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter item code : ");
            vendingState.onProductConfirmationClick(vendingMachine, sc.nextInt());

            System.out.println("|");
            System.out.println("Making Payment for Product");
            System.out.println("|");

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.onPaymentInititation(vendingMachine);
            // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("Dispensing");
            System.out.println("|");
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.onDispense(vendingMachine);

//            displayInventory(vendingMachine);

        }
        catch (Exception e){
            displayInventory(vendingMachine);
        }


    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setItemType(ItemType.COLD_DRINK);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setItemType(ItemType.WATER);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setItemType(ItemType.CARBONATED_WATER);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setItemType(ItemType.ENERGY_DRINK);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getShelfId() +
                    " Item: " + slots[i].getItem().getItemType() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }

}
