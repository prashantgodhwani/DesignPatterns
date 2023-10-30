package BehavioralPatterns.StatePattern.state.impl;

import BehavioralPatterns.StatePattern.models.Item;
import BehavioralPatterns.StatePattern.models.Money;
import BehavioralPatterns.StatePattern.models.VendingMachine;
import BehavioralPatterns.StatePattern.state.State;

import java.util.List;

public class DispenseItemState implements State {

    private int code;

    public DispenseItemState(int code) {
        this.code = code;
    }

    @Override
    public void onProductSelectionClick(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot select product in dispensing phase");
    }

    @Override
    public void onProductConfirmationClick(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Cannot confirm product in dispensing phase");
    }

    @Override
    public void onPaymentInititation(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot initiate Payment in dispensing phase");
    }

    @Override
    public void onDispense(VendingMachine vendingMachine) throws Exception {
        Item item = vendingMachine.getInventory().get(code);
        System.out.println("dispensing " + item.getItemType());
        vendingMachine.setVendingMachineState(new IdleState());
    }

    @Override
    public void onCancelTransaction(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Cannot cancel txn in dispensing phase");
    }

    @Override
    public List<Money> refundMoney(VendingMachine vendingMachine, int cost) throws Exception {
        throw new Exception("Cannot refund txn in dispensing phase");
    }
}
