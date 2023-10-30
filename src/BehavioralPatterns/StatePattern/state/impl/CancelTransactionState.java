package BehavioralPatterns.StatePattern.state.impl;

import BehavioralPatterns.StatePattern.models.Money;
import BehavioralPatterns.StatePattern.models.VendingMachine;
import BehavioralPatterns.StatePattern.state.State;

import java.util.List;

public class CancelTransactionState implements State {
    @Override
    public void onProductSelectionClick(VendingMachine vendingMachine) {

    }

    @Override
    public void onProductConfirmationClick(VendingMachine vendingMachine, int code) throws Exception {

    }

    @Override
    public void onPaymentInititation(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void onDispense(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void onCancelTransaction(VendingMachine vendingMachine, int cost) throws Exception {

    }

    @Override
    public List<Money> refundMoney(VendingMachine vendingMachine, int cost) throws Exception {
        return null;
    }
}
